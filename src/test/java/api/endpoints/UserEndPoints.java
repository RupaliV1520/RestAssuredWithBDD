package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.aventstack.extentreports.gherkin.model.When;

import api.payload.User;

public class UserEndPoints {
	
	//create,update,delete,read
	public static Response createUser(User payload){
	Response response =
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
			.post(Routes.post_Url);
				
	return response;
	}
	//read user
	public static Response readeUser(String username){
	Response response =
			given()
				.pathParam("username", username)
			.when()
			.get(Routes.get_Url);
				
	return response;
	}
	//update user
	public static Response updateUser(String username, User payload){
	Response response =
			given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
		.put(Routes.update_Url);
				
	return response;
	}
	
	//delete user 
	public static Response deleteUser(String username){
	Response response =
			given()
				.pathParam("username", username)
			.when()
			.delete(Routes.delete_Url);
				
	return response;
	}

}
