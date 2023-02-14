package com.naura.test;

import com.github.leeonky.jfactory.DataRepository;
import com.github.leeonky.jfactory.repo.JPADataRepository;
import com.naura.test.ice.IComRecipe.RemoteProcessRcpInfo;
import com.naura.test.ice.IComRecipe.RemoteRcpBodyInfo;
import com.naura.test.ice.IComRecipe.RemoteRecipeInfo;
import com.naura.test.api.api.LowerApi;
import com.naura.test.api.api.RecipeApi;
import com.naura.test.specs.slice.RecipeClasses;
import com.naura.test.ui.MockLower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Service
public class Repository implements DataRepository {

    @Autowired
    private JPADataRepository jpaDataRepository;

    @Autowired
    private LowerApi lowerApi;

    @Override
    @SuppressWarnings("unchecked")
    public <T> Collection<T> queryAll(Class<T> type) {
        if (type.getAnnotation(Entity.class) != null)
            return jpaDataRepository.queryAll(type);
        if (type.equals(RemoteRecipeInfo.class)) {
            RecipeApi recipeApi = lowerApi.recipe();
            return (List<T>) stream(recipeApi.getAllRecipes()).map(recipeApi::getRecipeInfo).collect(toList());
        }
        return Collections.emptyList();
    }

    @Autowired
    private MockLower mockLower;

    @Override
    public void clear() {
        jpaDataRepository.clear();
    }

    @Override
    public void save(Object o) {
        if (o instanceof RemoteRecipeInfo) {
            lowerApi.recipe().test().given((RemoteRecipeInfo) o);
            if (((RemoteRecipeInfo) o).body != null) {
                RemoteRcpBodyInfo remoteRcpBodyInfo = ((RemoteRecipeInfo) o).body;
                lowerApi.recipe().storeRcpBody(((RemoteRecipeInfo) o).rcpClass + "/" + ((RemoteRecipeInfo) o).name + ";1", true, (RemoteProcessRcpInfo) ((RemoteRecipeInfo) o).body);
            }
        } else if (o instanceof RecipeClasses.RecipeClassParam) {
            RecipeClasses.RecipeClassParam classParam = (RecipeClasses.RecipeClassParam) o;
            lowerApi.recipe().test().givencls(classParam.name, classParam.params);
        } else if (o != null && o.getClass().getAnnotation(Entity.class) != null) {
            jpaDataRepository.save(o);
        }
    }
}
