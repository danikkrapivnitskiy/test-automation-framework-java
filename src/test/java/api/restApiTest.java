package api;

import com.api.User;
import com.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;

public class restApiTest {

    private UserController userController;
    @Before
    public void setUp() {
        userController = new UserController();
    }
    @Test
    public void assertRestApiTest() {

        User user = userController.getUserByUsername("danikkrapivnitskiy");

        assertTrue(user.getHtml_url().contains(user.getLogin()));
    }

    @Test
    public void FollowersRestApiTest() {

        User[] followers = userController.getFollowersByUsrname("Dan");
        System.out.println(followers.length);
        assertTrue(followers.length > 0);
    }

}
