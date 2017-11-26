package main.huixian.serviceImpl;

import main.huixian.bean.User;
import main.huixian.dao.UserMapper;
import main.huixian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2017/11/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void add(User user) {

        userMapper.add(user);

    }
}
