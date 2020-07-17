package cn.edu.ecut.service;

import cn.edu.ecut.dao.UserDao;
import cn.edu.ecut.model.User;

public class UserServices {
    final UserDao userDao = new UserDao();

    public User loadByUserName(String username){
        return userDao.loadByUserName(username);
    }

    public User loadByUserNameAndPassword(User user){
        return userDao.loadByUserNameAndPassword(user);
    }

}
