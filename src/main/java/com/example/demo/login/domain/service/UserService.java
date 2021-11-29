package com.example.demo.login.domain.service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;
import com.example.demo.login.domain.repository.jdbc.UserDaoJdbcImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
//    @Qualifier("UserDaoJdbcImpl2")
//    UserDao dao;
    UserDaoJdbcImpl2 dao;

    public boolean insert(User user) {
        int rowNumber = dao.insertOne(user);

        boolean result = false;

        if (rowNumber > 0) {
            result = true;
        }

        return result;
    }

    public int count() {
        return dao.count();
    }

    public List<User> selectMany() {
        return dao.selectMany();
    }

    public User selectOne(String userId) {
        return dao.selectOne(userId);
    }

    public boolean updateOne(User user) {
        int rowNumber = dao.updateOne(user);

        boolean result = false;

        if (rowNumber > 0) {
            result = true;
        }

        return result;
    }

    public boolean deleteOne(String userId) {
        int rowNumber = dao.deleteOne(userId);
        boolean result = false;
        if (rowNumber > 0) {
            result = true;
        }
        return result;
    }
}
