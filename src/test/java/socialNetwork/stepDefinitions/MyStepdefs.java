package socialNetwork.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialNetwork.supportingSteps.SupportingSteps;

public class MyStepdefs {

    SupportingSteps supportingSteps = new SupportingSteps();

    @Given("Authorized {string} request for post on social network website")
    public void authorizedRequestForPostOnSocialNetworkWebsite(String userId) {
        supportingSteps.userIdVerification(userId);
    }

    @When("Authorized user given the {string} and {string} for creation of post on social network website")
    public void authorizedUserGivenTheAndForCreationOfPostOnSocialNetworkWebsite(String title, String body) {
        supportingSteps.creatingPost(title, body);

    }

    @Then("User request post is created with {string} and {string} on social network website")
    public void userRequestPostIsCreatedWithAndOnSocialNetworkWebsite(String title, String body) {
        supportingSteps.validateResponseBody(title, body);
    }

    @Given("Authorized {string} request for Comment on post on social network website")
    public void authorizedUserRequestForCommentOnPostOnSocialNetworkWebsite(String userId) {
        supportingSteps.userIdVerification(userId);
    }

    @When("Authorized user given valid {string},{string} and {string} for creation of Comment on post")
    public void authorizedUserGivenValidAndForCreationOfCommentOnPost(String postId, String name, String email) {
        supportingSteps.validateUserInput(postId, name, email);
    }

    @Then("User {string} must created on post with {string} and {string} on {string}")
    public void userMustCreatedOnPostWithAnd(String comment, String name, String email, String postId) {
        supportingSteps.createCommentOnPost(comment, name, email, postId);
    }
}
