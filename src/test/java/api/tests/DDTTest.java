package api.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDTTest {

	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userId,String userName, String fName,String lname,String userEmail, String password,String ph) {
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastNmae(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(password);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="Usernames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String username) {
		
		Response response=UserEndPoints.deleteUser(username);
		//response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
