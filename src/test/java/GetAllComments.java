import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllComments {
    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }


    @Test
    public void quarry_param() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("postId",2)
                .get("comments")
                .then()
                .extract().response();


      //  Assert.assertEquals(response.getStatusCode(), 201);
          response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");
        System.out.println(name);
    }
}
