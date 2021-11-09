package api.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import utils.ConfigProperties;

public class TrelloService {

    public RequestSpecification REQUEST_SPECIFICATION;
    public ResponseSpecification RESPONSE_SPECIFICATION;

    public static final String API_KEY = "api-key";
    public static final String TOKEN = "token";
    public static final String BASE_URI = "base-uri";

    public String getApiKey() {
        return ConfigProperties.getProperty(API_KEY);
    }

    public String getToken() {
        return ConfigProperties.getProperty(TOKEN);
    }

    public String getBaseUri() {
        return ConfigProperties.getProperty(BASE_URI);
    }

    public RequestSpecification requestSpec() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUri())
                .addHeader("Content-Type", "application/json")
                .addQueryParam("key", getApiKey())
                .addQueryParam("token", getToken())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public ResponseSpecification responseSpec() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }
    
    public Response getPostResponse(Object object, String url) {
        return RestAssured
                .given(requestSpec())
                .body(object)
                .when()
                .post(url)
                .then()
                .spec(responseSpec())
                .extract()
                .response();
    }

    public Response getGetResponse(String url) {
        return RestAssured
                .given(requestSpec())
                .when()
                .get(url)
                .then()
                .spec(responseSpec())
                .extract()
                .response();
    }

    public void getDeleteResponse(String url) {
        RestAssured
                .given(requestSpec())
                .when()
                .delete(url)
                .then()
                .spec(responseSpec())
                .extract()
                .response();
    }

    public Response getPutResponse(Object object, String url) {
        return RestAssured
                .given(requestSpec())
                .body(object)
                .when()
                .put(url)
                .then()
                .spec(responseSpec())
                .extract()
                .response();
    }

    public <T> T parser(Response response, T res){
        res = (T) response.as(res.getClass());

        return res;
    }
}
