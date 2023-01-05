package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Global;
import com.github.leeonky.jfactory.Spec;

public class Transfers {
    @Global
    public static class Transfer extends Spec<com.naura.db.entity.Transfer> {
        @Override
        public void main() {
            property("num").ignore();
            //property("lot").is(Lots.Lot.class);
        }
    }
}
