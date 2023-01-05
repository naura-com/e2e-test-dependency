package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Spec;

public class Jobs {
    public static class Job extends Spec<com.naura.db.entity.Job> {
        @Override
        public void main() {
            property("idx").ignore();
            property("preprocess").value("");
        }

    }
}
