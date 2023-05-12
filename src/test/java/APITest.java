//import io.restassured.RestAssured;   --- without static import
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    void testAPIResponse(){

//        Response apiResponse = RestAssured.get("{{P2PApiUrl}}/api/Individuals/");
    //    Response apiResponse = RestAssured.get("https://reqres.in/api/users?page=2");  -- without static import
       Response apiResponse = get("https://reqres.in/api/users?page=2");

        System.out.println("Response: "+ apiResponse.asString());
        System.out.println("Status code is " + apiResponse.getStatusCode());
        System.out.println("Time taken " + apiResponse.getTime());

        int statusCode = apiResponse.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    void testApiWithBDD(){

        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }
}
