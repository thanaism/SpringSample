package com.example.demo;

/*
importまわりはjunitのバージョン等の違いで調整した
（コメントアウト部が書籍のコード）
 */
import com.example.demo.login.domain.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class UserDaoTest {
    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    UserDao dao;

    @Test
    public void countTest1() {
        assertEquals(dao.count(), 2);
    }

    @Test
    @Sql("/testdata.sql")
    public void countTest2() {
        assertEquals(dao.count(), 3);
    }
}
