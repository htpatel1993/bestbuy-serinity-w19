package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDrivenTest extends TestBase {

    static String name;
    static String type;
    static String upc;
    static double price;
    static String description;
    static String model;
    @Steps
    ProductsSteps productsSteps;

    @Title("Data driven test for adding multiple product to the application")
    @Test
    public void createMultipleProduct() {
        productsSteps.createProduct(name, type, upc, price, description, model).then().log().all().statusCode(201);
    }
}
