package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Global;
import com.github.leeonky.jfactory.Spec;

public class Ch2s {
    @Global
    public static class Ch2 extends Spec<com.naura.db.entity.Ch2> {
        @Override
        public void main() {
            property("num").ignore();
            property("lot").is(Lots.Lot.class);
        }
    }
}
