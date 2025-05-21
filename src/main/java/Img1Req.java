import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Img1Req
{

    public static void uploadImg1(Boolean responseSuccess , int responseCode)
    {
        File img1 = new File("C:\\Users\\yahia\\IdeaProjects\\IMGUR_API_PROJECT\\src\\main\\resources.\\fool.jpg");

        Response response =
        given().log().all().
                header("Authorization",Constants.TOKEN).
                multiPart("image",img1).
                formParam("title", "Fool").
                formParam("description", "This is Fool").
        when().log().all().
                post(Constants.BASE_URL + Constants.IMAGE_ENDPOINT).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess)).
        extract().response();

        Constants.IMAGE_HASH1 = response.jsonPath().getString("data.id");
        Constants.DELETE_HASH1 = response.jsonPath().getString("data.deletehash");
    }

    public static void getImg1(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
        when().log().all().
                get(Constants.BASE_URL + Constants.IMAGE_ENDPOINT + Constants.IMAGE_HASH1).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }

    public static void deleteImg1(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
        when().log().all().
                delete(Constants.BASE_URL + Constants.IMAGE_ENDPOINT + Constants.DELETE_HASH1).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }
}
