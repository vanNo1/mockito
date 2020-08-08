package van.unittest.test.serviceImpl;

import org.springframework.stereotype.Service;
import van.unittest.test.dao.UserMapper;
import van.unittest.test.entity.User;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {
    @Resource
    private UserMapper userMapper;

}
