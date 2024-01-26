package validationTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getSingleCode {
    @Test
    public void validateStatusCodeIs200ok(){
        given().when().get("https://api.zippopotam.us/us/33162").then().
                statusCode(200);
    }

    @Test
    public void ValidatingResponseBody(){
        Response response = RestAssured.get("https://api.zippopotam.us/us/33162");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("country"));
    }
    @Test
    public void validateSpecificFields() {
        given().
                when().
                get("https://api.zippopotam.us/us/33162").
                then().
                assertThat().
                body("country", equalTo("United States")).
                body("places[0].'place name'", equalTo("Miami")).
                body("places[0].longitude", equalTo("-80.183")).
                body("places[0].state", equalTo("Florida")).
                body("places[0].'state abbreviation'", equalTo("FL")).
                body("places[0].latitude", equalTo("25.9286"));
        // Add other validations as needed based on the actual response structure
    }
    @Test
    public void ValidateContentType() {
        given().when().get("https://api.zippopotam.us/us/33162").then().
                assertThat().
                contentType(ContentType.JSON);
    }

}
