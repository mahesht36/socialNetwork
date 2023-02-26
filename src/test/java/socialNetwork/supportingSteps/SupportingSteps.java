package socialNetwork.supportingSteps;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class SupportingSteps {

    public String baseURI = "https://jsonplaceholder.typicode.com";
    Response postResponse;
    Response userResponse;
    Response commentResponse;
    String jsonString;

    public void userIdVerification(String userid) {
        try {
            userResponse = given().when().get(baseURI + "/users/" + userid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creatingPost(String title, String body) {
        try {
            given().when().get(baseURI + "/posts").then().statusCode(200);
            Simulation simulation = Simulation.builder().
                    title(title).postBody(body).build();
            postResponse = given().body(simulation).contentType(ContentType.JSON).
                    when().post(baseURI + "/posts");
            Assert.assertEquals("Resource creation status", 201, postResponse.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateResponseBody(String title, String body) {
        try {
            jsonString = postResponse.body().asString();
            String actualTitle = JsonPath.from(jsonString).get("title");
            String actualBody = JsonPath.from(jsonString).get("postBody");
            Assert.assertEquals(title, actualTitle);
            Assert.assertEquals(body, actualBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateUserInput(String postId, String name, String email) {
        jsonString = userResponse.asString();
        String actualName = JsonPath.from(jsonString).get("name");
        String actualEmail = JsonPath.from(jsonString).get("email");
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(email, actualEmail);
        postResponse = given().get(baseURI + "/posts/" + postId);
        jsonString = postResponse.asString();
        String actualPostId = JsonPath.from(jsonString).get("id").toString();
        Assert.assertEquals(postId, actualPostId);
    }

    public void createCommentOnPost(String comment, String name, String email, String postId) {
        given().when().get(baseURI + "/comments").then().statusCode(200);
        Simulation simulation = Simulation.builder().
                postId(postId).name(name).email(email).commentBody(comment).build();
        commentResponse = given().body(simulation).contentType(ContentType.JSON).
                when().post(baseURI + "/comments");
        Assert.assertEquals("Resource creation status", 201, commentResponse.statusCode());
        jsonString = commentResponse.asString();
        String actualCommentBody = JsonPath.from(jsonString).get("commentBody");
        Assert.assertEquals("Validating created comment", comment, actualCommentBody);
    }
}
