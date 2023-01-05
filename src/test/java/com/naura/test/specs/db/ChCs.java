package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Spec;

public class ChCs {
    public static class ChC extends Spec<com.naura.db.entity.ChC> {
        @Override
        public void main() {
            property("num").ignore();
            property("stepLogSegmentID").value(1);
        }
    }
}
