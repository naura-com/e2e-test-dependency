package com.naura.db.entity;

import com.github.leeonky.jfactory.JFactory;
import com.naura.db.entity.converter.RouteDefinitionConverter;
import com.naura.pvd.IComRecipe.RemoteRecipeInfo;
import com.naura.test.config.ContextWrapper;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

@Entity
@Table(name = "routes")
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    private String name;
    private LocalDateTime createtime, modifytime;

    @Convert(converter = RouteDefinitionConverter.class)
    @Column(name = "value")
    private List<Step> steps = new ArrayList<>();

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Step {
        private List<Visit> visits = new ArrayList<>();

        public String encodeVisits() {
            return getVisits().stream().map(Visit::encode).collect(Collectors.joining(":"));
        }

        public static Step decode(String s) {
            return new Step().setVisits(stream(s.split(":")).map(Visit::decode).collect(toCollection(ArrayList::new)));
        }
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Visit {
        private String station;
        private int slot;
        private RemoteRecipeInfo recipe;

        public String encode() {
            return String.format("%s[]|%d||%s|", station, slot, recipeName());
        }

        @NotNull
        private String recipeName() {
            if (recipe == null)
                return "";
            else
                return String.format("%s/%s;%s", recipe.rcpClass, recipe.name, recipe.version);
        }

        public static Visit decode(String str) {
            String[] items = str.split("\\|");
            if (items.length == 3) {
                String[] recipeNames = items[3].split(";");
                int classIndex = recipeNames[0].lastIndexOf('/');
                RemoteRecipeInfo recipeInfo = ContextWrapper.getApplicationContext().getBean(JFactory.class).type(RemoteRecipeInfo.class)
                        .property("rcpClass", recipeNames[0].substring(0, classIndex))
                        .property("name", recipeNames[0].substring(classIndex + 1))
                        .property("version", recipeNames[1])
                        .query();
                return new Visit()
                        .setSlot(parseInt(items[1]))
                        .setStation(items[0].replace("[]", ""))
                        .setRecipe(recipeInfo);
            } else {
                return new Visit()
                        .setSlot(parseInt(items[1]))
                        .setStation(items[0].replace("[]", ""));
            }
        }
    }
}
