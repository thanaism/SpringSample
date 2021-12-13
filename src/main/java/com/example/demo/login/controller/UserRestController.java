package com.example.demo.login.controller;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    @Qualifier("RestServiceMybatisImpl")
    RestService service;

    @GetMapping("/rest/get")
    public List<User> getUserMany() {
        return service.selectMany();
    }

    @GetMapping("/rest/get/{id:.+}")
    public User getUserOne(@PathVariable("id") String userId) {
        return service.selectOne(userId);
    }

    /*
    curl -X POST -H "Content-Type:application/json" -d "{\"userId\":\"tamura@co.jp\",\"password\":\"pass\",\"userName\":\"tamura\",\"birthday\":\"1986-11-05\",\"age\":\"31\",\"marriage\":\"false\",\"role\":\"ROLE_ADMIN\"}" http://localhost:8080/rest/insert
     */
    @PostMapping("/rest/insert")
    public String postUserOne(@RequestBody User user) {
        boolean result = service.insert(user);
        String str = "";
        if (result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }
    /*
    curl http://localhost:8080/rest/update -X PUT -H "Content-Type:application/json" -d "{\"userId\":\"yamada@xxx.co.jp\",\"password\":\"password\",\"userName\":\"yamada\",\"birthday\":\"19900101\",\"age\":\"28\",\"marriage\":\"false\",\"role\":\"ROLE_ADMIN\"}"
     */
    @PutMapping("/rest/update")
    public String putUserOne(@RequestBody User user) {
        boolean result = service.update(user);
        return result ? "{\"result\":\"ok\"}" : "{\"result\":\"error\"}";
    }

    /*
    curl http://localhost:8080/rest/delete/yamada@xxx.co.jp -X DELETE
     */
    @DeleteMapping("/rest/delete/{id:.+}")
    public String deleteUserOne(@PathVariable("id") String userId) {
        boolean result = service.delete(userId);
        return result ? "{\"result\":\"ok\"}" : "{\"result\":\"error\"}";
    }
}
