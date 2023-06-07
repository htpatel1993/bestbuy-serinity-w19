package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/storeinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStoresDataDrivenTest extends TestBase {

    static String name;
    static String type;
    static String address;

    static String address2;
    static String city;

    static String state;
    static String zip;
    @Steps
    StoresSteps storesSteps;

    @Title("Data driven test for adding multiple stores to the application")
    @Test
    public void createMultipleStore() {
        storesSteps.createStore(name, type, address, address2, city, state, zip).then().log().all().statusCode(201);
    }
}
