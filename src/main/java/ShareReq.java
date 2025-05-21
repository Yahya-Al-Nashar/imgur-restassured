import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ShareReq
{
    public static void shareImg1(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
                formParam("title", "FOOL").
                formParam("topic", "Food").
                formParam("terms", "1").
                formParam("tags", "Food,Beans").
        when().log().all().
                post(Constants.BASE_URL + Constants.SHARE_ENDPOINT + Constants.IMAGE_HASH1).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }

    public static void shareImg2(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
                formParam("title", "TAMEYA").
                formParam("topic", "Food").
                formParam("terms", "1").
                formParam("tags", "Food,Tameya").
        when().log().all().
                post(Constants.BASE_URL + Constants.SHARE_ENDPOINT + Constants.IMAGE_HASH2).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }
}
