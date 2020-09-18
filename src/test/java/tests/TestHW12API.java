package test.java.tests;

import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;

import java.io.File;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.jvnet.fastinfoset.EncodingAlgorithmIndexes.UUID;

public class TestHW12API {

    Object createdID;

    @Test (priority = 1)
    public void createProjectTest () {

        createdID =  given()
                .header("Authorization", "Bearer 695ed461606475fbb293fe504a213ea43c92d54c")
                .contentType("application/json")
                .body(new File("/Users/alexandramoroz/Documents/Auto_QA/autotests/src/test/java/tests/createProjectBody.json"))
                      //.formParam("name", "api project")
                     // .formParam("color", "48")
                     // .formParam("key3", "value")
                .when()
                      .post(PropertyLoader.loadProperty("api.url") + "/projects")
                .then()
                     .statusCode(200)
                     .extract().path("id");

    }

    @Test (priority = 2)
            //(dependsOnMethods = "createProjectTest")
    public void getAllProjects () {

        given().header("Authorization", "Bearer 695ed461606475fbb293fe504a213ea43c92d54c")
                .contentType("application/json").log().all()
                .when()
                .post(PropertyLoader.loadProperty("api.url") + "/projects")
                .then().log().all()
                .statusCode(200);
    }

    @Test (priority = 3)
    //(dependsOnMethods = "createProjectTest")
    public void updateProject () {


        UUID uuid = UUID.randomUUID();

        given()
         .header("Authorization", "Bearer 695ed461606475fbb293fe504a213ea43c92d54c")
                .contentType("application/json")
                .header("X-Request-Id:",uuid)
                .formParam("name", "api project edited")
                .when()
                .post(PropertyLoader.loadProperty("api.url") + "/projects"+ createdID)
                .then()
                .statusCode(200);
    }



    @Test (priority = 4)
            //(dependsOnMethods = "createProjectTest")
    public void deleteProjectTest() {
        given()
                .header("Authorization", "Bearer 695ed461606475fbb293fe504a213ea43c92d54c")
                .contentType("application/json").log().all()
                .when()
                .delete(PropertyLoader.loadProperty("api.url") + "/projects/" + createdID)
                .then().log().all()
                .statusCode(204);
    }

}
