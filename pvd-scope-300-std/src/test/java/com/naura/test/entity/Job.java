package com.naura.test.entity;

import com.naura.test.entity.converter.JobDefinitionConverter;
import com.naura.test.entity.converter.JobModeDefinitionConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    private String name;

    private String src;

    private String dest;

    private String cyclenum;

    @Convert(converter = JobModeDefinitionConverter.class)
    private String mode;


    private String isprocess;

    private String isunload;

    private String ishigh;

    private String preprocess;

    private LocalDateTime createtime, modifytime;

    @Convert(converter = JobDefinitionConverter.class)
    @Column(name = "routes")
    private List<Routes> routes = new ArrayList<>();

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Routes {
        private String route;

        private String slots;

        public String encode() {
            return String.format("%s|%s", route, slots.replace(",", "|"));
        }

        public static Routes decode(String s) {
            List<String> lists = new ArrayList<>(Arrays.asList(s.split("\\|")));
            return new Routes().setRoute(lists.get(0))
                    .setSlots(lists.subList(1, lists.size()).toString());
        }
    }
}
