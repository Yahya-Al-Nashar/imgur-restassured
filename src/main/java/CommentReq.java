import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CommentReq
{
    public static void uploadComment(Boolean responseSuccess , int responseCode)
    {
        Response response =
                given().log().all().
                        header("Authorization",Constants.TOKEN).
                        multiPart("image_id", Constants.IMAGE_HASH1).
                        formParam("comment","This comment is a comment").
                when().log().all().
                        post(Constants.BASE_URL + Constants.COMMENT_ENDPOINT).
                then().log().all().
                        assertThat().statusCode(responseCode).
                        body("success", equalTo(responseSuccess)).
                        extract().response();

        Constants.COMMENT_HASH = response.jsonPath().getString("data.id");
    }

    public static void getComment(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
        when().log().all().
                get(Constants.BASE_URL + Constants.COMMENT_ENDPOINT + Constants.COMMENT_HASH).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }

    public static void deleteComment(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
        when().log().all().
                delete(Constants.BASE_URL + Constants.COMMENT_ENDPOINT + Constants.COMMENT_HASH).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }
}
