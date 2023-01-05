package com.naura.test.lower;

import com.naura.test.lower.api.LowerApi;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class RouteSteps {

    @Autowired
    private DataBase dataBase;

    @Autowired
    private LowerApi lowerApi;

    @Before(value = "@clean-lower-route", order = 1100)
    public void cleanRoute() {
        dataBase.cleanTable("routes");
        dataBase.cleanTable("jobs");
        dataBase.cleanTable("lot");
        dataBase.cleanTable("transfer");
        dataBase.cleanTable("pmrecipe");
    }

    @Before(value = "@clean-lower-routeAndRcp", order = 1100)
    public void cleanRouteAndRcp() {
        dataBase.cleanTable("routes");
        lowerApi.recipe().test().cleanRecipes();
    }
}
