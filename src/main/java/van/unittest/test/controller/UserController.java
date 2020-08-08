package van.unittest.test.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import van.unittest.test.dao.UserDao;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (userDao.exist(name, password)) {
            return "index";
        } else {
            return "login";
        }
    }
}
