package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Spec;

public class Alarms {
    public static class Alarm extends Spec<com.naura.test.entity.Alarm> {
        @Override
        public void main() {
            property("idx").ignore();
            property("description").value("");
            property("recovtype").value(null);
            property("recovactor").value(null);
            property("recovtime").value(null);
        }

    }
}
