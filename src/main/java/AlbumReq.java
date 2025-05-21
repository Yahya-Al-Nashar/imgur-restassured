import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AlbumReq
{
    public static void uploadAlbum(Boolean responseSuccess , int responseCode)
    {
        Response response =
                given().log().all().
                        header("Authorization",Constants.TOKEN).
                        multiPart("id[]", Constants.IMAGE_HASH1).
                when().log().all().
                        post(Constants.BASE_URL + Constants.ALBUM_ENDPOINT).
                then().log().all().
                        assertThat().statusCode(responseCode).
                        body("success", equalTo(responseSuccess)).
                        extract().response();

        Constants.ALBUM_HASH = response.jsonPath().getString("data.id");
    }

    public static void getAlbum(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
        when().log().all().
                get(Constants.BASE_URL + Constants.ALBUM_ENDPOINT + Constants.ALBUM_HASH).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }

    public static void updateAlbum(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
                formParam("title", "Fool").
                formParam("description","This is Fool").
                formParam("privacy", "public").
                multiPart("cover", Constants.IMAGE_HASH1).
        when().log().all().
                put(Constants.BASE_URL + Constants.ALBUM_ENDPOINT + Constants.ALBUM_HASH).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }

    public static void deleteAlbum(Boolean responseSuccess , int responseCode)
    {
        given().log().all().
                header("Authorization",Constants.TOKEN).
        when().log().all().
                delete(Constants.BASE_URL + Constants.ALBUM_ENDPOINT + Constants.ALBUM_HASH).
        then().log().all().
                assertThat().statusCode(responseCode).
                body("success", equalTo(responseSuccess));
    }
}
