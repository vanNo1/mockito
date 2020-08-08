package van.unittest.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import van.unittest.test.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    private UserDao userDao;
    private UserController userController;
    private HttpServletRequest request;

    @Before
   public void setUp() {
        this.userDao= Mockito.mock(UserDao.class);
        this.userController=new UserController(userDao);
        this.request=Mockito.mock(HttpServletRequest.class);
    }
    @Test
    public void testLoginSuccess() throws Exception {
    when(request.getParameter("name")).thenReturn("van");
    when(request.getParameter("password")).thenReturn("123");
    when(userDao.exist(anyString(),anyString())).thenReturn(true);
    assert(userController.login(request)).equals("login");
    }

}