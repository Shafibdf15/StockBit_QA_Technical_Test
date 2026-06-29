package automation.stepdef.api;

import automation.pages.api.apiClient;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class apiStep {

    apiClient ApiClient;

    public apiStep() {this.ApiClient = new apiClient();}

    @Given("user has prepared url for {string}")
    public void userHasPreparedUrlFor(String url) {ApiClient.urlPrep(url);
    }

    @And("user has create data body")
    public void userHasCreateDataBody() {ApiClient.userHasCreateRequestBody();
    }

    @When("user hit POST to endpoint")
    public void userHitPOSTToEndpoint() {ApiClient.userSendPOSTRequestToEndpoint();
    }

    @Then("validate status code is equals to {int}")
    public void validateStatusCodeIsEqualsTo(int status_code) {ApiClient.validateStatusCode(status_code);
    }

    @And("response will contain the new written data")
    public void responseWillContainTheNewWrittenData() {ApiClient.validateResponseBody();
    }

    @And("response passed the json schema validation {string}")
    public void responsePassedTheJsonSchemaValidation(String schemaFilename) {ApiClient.validateJsonSchema(schemaFilename);
    }

    @When("user hit GET to endpoint")
    public void userHitGETToEndpoint() {ApiClient.sendGetRequest();
    }

    @Then("validate id field is not null on all post")
    public void validateIdFieldIsNotNullOnAllPost() {ApiClient.validateEachPostHasNonNullId();
    }

    @When("user hit DELETE to endpoint posts with id {string}")
    public void userHitDELETEToEndpointPosts(String id) {ApiClient.deletePost(id);
    }

    @And("validate the data has been deleted")
    public void validateTheDataHasBeenDeleted() {ApiClient.validateDeleteResponse();
    }

    @And("user has create data body for update")
    public void userHasCreateDataBodyForUpdate() {ApiClient.updatePOSTSData();
    }

    @When("user hit PUT to endpoint posts with id {string}")
    public void userHitPUTToEndpointPostsWithId(String id) {ApiClient.sendPutRequest(id);
    }

    @Then("validate the response match the updated data")
    public void validateTheResponseMatchTheUpdatedData() {ApiClient.validatePutResponse();
    }
}
