package com.example.demo.login.domain.repository.mybatis;

import com.example.demo.login.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper2 {
    public boolean insert(User user);
    public User selectOne(String userId);
    public List<User> selectMany();
    public boolean updateOne(User user);
    public boolean deleteOne(String userId);
}
