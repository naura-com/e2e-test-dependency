package com.naura.test.specs.db;

import com.github.leeonky.jfactory.Spec;


public class Routes {
    public static class Route extends Spec<com.naura.test.entity.Route> {
        @Override
        public void main() {
            property("idx").ignore();
            property("steps[0]").is(Step.class);
        }
    }

    public static class Step extends Spec<com.naura.test.entity.Route.Step> {
        @Override
        public void main() {
            property("visits[0]").is(LA.class);
            property("visits[1]").is(LB.class);
        }
    }

    public static class LA extends Spec<com.naura.test.entity.Route.Visit> {
        @Override
        public void main() {
            property("station").value("LA");
            property("slot").value("0");
        }
    }

    public static class LB extends Spec<com.naura.test.entity.Route.Visit> {
        @Override
        public void main() {
            property("station").value("LB");
            property("slot").value("0");
        }
    }
}
