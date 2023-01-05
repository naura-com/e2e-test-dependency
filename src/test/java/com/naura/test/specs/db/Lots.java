package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Global;
import com.github.leeonky.jfactory.Spec;

public class Lots {
    @Global
    public static class Lot extends Spec<com.naura.db.entity.Lot> {
        @Override
        public void main() {
            property("idx").ignore();
            //property("ch2").is(Ch2s.Ch2.class);
//            property("ch2").reverseAssociation("lot");
            link("id", "lotid");
        }
    }
}
