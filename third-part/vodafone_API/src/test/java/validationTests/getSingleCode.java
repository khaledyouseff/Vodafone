package validationTests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class getSingleCode {
    @Test
    public void validateStatusCodeIs200ok(){
        given().when().get("https://api.zippopotam.us/us/90210").then().
                statusCode(200);
    }

    @Test
    public void ValidatingResponseBodyContainsSpecificField(){
        Response response = RestAssured.get("https://api.zippopotam.us/us/90210");
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("country"));
    }
    @Test
    public void validateAllFields() {
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("country", equalTo("United States")).
                body("places[0].'place name'", equalTo("Beverly Hills")).
                body("places[0].longitude", equalTo("-118.4065")).
                body("places[0].state", equalTo("California")).
                body("places[0].'state abbreviation'", equalTo("CA")).
                body("places[0].latitude", equalTo("34.0901"));
    }
    @Test
    public void ValidateContentType() {
        given().when().get("https://api.zippopotam.us/us/90210").then().
                assertThat().
                contentType(ContentType.JSON);
    }
    @Test
    public void verifyErrorForInvalidZipCode() {
        RestAssured.baseURI = "http://api.zippopotam.us";

        Response response = given()
                .when()
                .get("/us/8545454");

        assertEquals(404, response.getStatusCode());
    }




    @Test
    public void verifyErrorForUnsupportedCountry() {
        RestAssured.baseURI = "http://api.zippopotam.us";

        Response response = given()
                .when()
                .get("/xbjhbx/00000");

        assertEquals(404, response.getStatusCode());
        // Add additional assertions based on the expected error response
    }

    @Test
    public void verifySuccessfulRequestForAll() {
        RestAssured.baseURI = "http://api.zippopotam.us";

        Response response = given()
                .when()
                .get(RestAssured.baseURI);

        assertEquals(200, response.getStatusCode());
    }



}
