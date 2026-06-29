package automation.pages.api;

import automation.utility.apiEndpoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class apiClient {

    //Creating Local Variables
    String setUrl;
    Response response;
    JSONObject newData, updatedData;

    // Handling url input for testing scenario
    public void urlPrep(String url){
        switch (url){
            case "base_url":
                setUrl = apiEndpoint.api_endpoint;
                break;
            case "get_id":
                setUrl = apiEndpoint.getApi_endpoint_id;
                break;
            default:
                System.out.println("Endpoint Not found");
        }
        System.out.println(" Url to be hit: " + setUrl);
    }
    //Create request body
    public void userHasCreateRequestBody(){

        newData = new JSONObject();
        newData.put("title",  "Learn API Testing");
        newData.put("body",   "Practicing API testing with JSON Placeholder");
        newData.put("userId", 101);

        System.out.println("📋 Request body: " + newData);
    }
    //Sending POST data
    public void userSendPOSTRequestToEndpoint(){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newData.toString())
                .when()
                .post(setUrl)
                .then()
                .extract()
                .response();

        System.out.println("Response body: " + response.getBody().asPrettyString());

    }
    // Validate status code
    public void validateStatusCode(int expectedStatusCode) {
        try {
            assertThat(response.statusCode()).isEqualTo(expectedStatusCode);
            System.out.println("✅ Status code as expected: " + response.statusCode());
        } catch (AssertionError e) {
            System.out.println("❌ Status code mismatch! Expected: "
                    + expectedStatusCode + ", Actual: " + response.statusCode());
            throw e;
        }
    }
    // Validate response body matches what was sent
    public void validateResponseBody() {
        JsonPath json = response.jsonPath();

        String actualTitle  = json.getString("title");
        String actualBody   = json.getString("body");
        int    actualUserId = json.getInt("userId");
        int    actualId     = json.getInt("id");

        assertThat(actualTitle).isEqualTo(newData.get("title"));
        assertThat(actualBody).isEqualTo(newData.get("body"));
        assertThat(actualUserId).isEqualTo(newData.get("userId"));
        assertThat(actualId).isNotNull();

        System.out.println("✅ Response body validated. Generated id: " + actualId);
        System.out.println("Response body: " + response.getBody().asPrettyString());
    }
    // Validate JSON schema
    public void validateJsonSchema(String schemaFileName) {
        File schemaFile = new File("src/test/resources/schemas/" + schemaFileName);

        assertThat(response.asString())
                .satisfies(body ->
                        JsonSchemaValidator.matchesJsonSchema(schemaFile).matches(body)
                );

        System.out.println("✅ JSON schema validation passed");
    }

    // GET the POST data
    // Send GET request
    public void sendGetRequest() {
        response = RestAssured.given()
                .when()
                .get(setUrl)
                .then()
                .extract()
                .response();

        System.out.println("Response body: " + response.getBody().asPrettyString());
    }

    // Loop validation — checks EVERY post has a non-null id
    public void validateEachPostHasNonNullId() {
        List<Integer> ids = response.jsonPath().getList("id");  // grabs all id fields at once

        assertThat(ids).isNotNull();
        assertThat(ids.size()).isGreaterThan(0);

        int failCount = 0;

        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == null) {
                System.out.println("❌ Post at index " + i + " has null id");
                failCount++;
            } else {
                System.out.println("✅ Post [" + i + "] id: " + ids.get(i));
            }
        }

        assertThat(failCount)
                .as("Found " + failCount + " posts with null id")
                .isEqualTo(0);

        System.out.println("✅ All " + ids.size() + " posts have valid ids");
    }
    //Deleting existing user
    public void deletePost(String id){
        response = RestAssured.given()
                .when()
                .delete(setUrl +id)
                .then()
                .extract()
                .response();

        System.out.println("✅ Status code after DELETE is: " + response.statusCode());

    }
    //Validating Data has been deleted
    public void validateDeleteResponse() {
        String responseBody = response.getBody().asString().trim();

        assertThat(responseBody)
                .as("Delete response body should be empty object")
                .isEqualTo("{}");

        System.out.println("✅ Response body confirmed empty: " + responseBody);
    }
    //Updating data
    public void updatePOSTSData(){

        updatedData = new JSONObject();
        updatedData.put("title",  "Updated Post Title");
        updatedData.put("body",   "This is the updated body content");
        updatedData.put("userId", 99);

        System.out.println("Update Request body: " + updatedData);
    }

    // Send PUT request
    public void sendPutRequest(String id) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(updatedData.toString())
                .when()
                .put(setUrl + id)
                .then()
                .extract()
                .response();

        System.out.println("Response body: " + response.getBody().asPrettyString());
    }

    // Validate PUT response matches what was sent
    public void validatePutResponse() {
        JsonPath json = response.jsonPath();

        String actualTitle  = json.getString("title");
        String actualBody   = json.getString("body");
        int    actualUserId = json.getInt("userId");

        assertThat(actualTitle).isEqualTo(updatedData.get("title"));
        assertThat(actualBody).isEqualTo(updatedData.get("body"));
        assertThat(actualUserId).isEqualTo(updatedData.get("userId"));

        System.out.println("✅ PUT response validated successfully");
    }

}
