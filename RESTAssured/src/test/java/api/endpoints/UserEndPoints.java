package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
			.when()
				.post(Routes.post_URL);

		return response;

	}

	public static Response readUser() {

		Response response = given()
//				.pathParam("ID", id)
				
			.when()
				.get(Routes.get_URL);

		return response;

	}
	
	public static Response updateUser(User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
//				.pathParam("ID", id)
				.body(payload)
				
			.when()
				.put(Routes.update_URL);

		return response;

	}

	public static Response deleteUser(String id) {

		Response response = given()
				.pathParam("ID", id)
				
			.when()
				.delete(Routes.delete_URL);

		return response;

	}


}
