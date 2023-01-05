package com.naura.test.config;

import com.github.leeonky.jfactory.DataRepository;
import com.github.leeonky.jfactory.JFactory;
import com.github.leeonky.jfactory.Spec;
import com.github.leeonky.util.Classes;
import org.springframework.stereotype.Service;

@Service
public class Factory extends JFactory {

    public Factory(DataRepository repository) {
        super(repository);
        Classes.subTypesOf(Spec.class, "com.naura.test.specs")
                .forEach(c -> register((Class) c));
    }
}
