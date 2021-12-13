package com.example.demo.login.domain.service;

import com.example.demo.login.domain.model.User;

import java.util.List;

public interface RestService {
    public boolean insert(User user);
    public User selectOne(String userId);
    public List<User> selectMany();
    public boolean update(User user);
    public boolean delete(String userId);
}
