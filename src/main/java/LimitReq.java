import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LimitReq
{
    public static void limit(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
                header("X-RateLimit-ClientRemaining","X-RateLimit-ClientRemaining").
        when().log().all().
                get(Constants.BASE_URL + Constants.LIMIT_ENDPOINT).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }
}
