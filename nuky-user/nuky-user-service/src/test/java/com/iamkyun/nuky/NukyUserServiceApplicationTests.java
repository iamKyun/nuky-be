package com.iamkyun.nuky;

import java.util.Optional;

import com.iamkyun.nuky.repository.UserRepository;
import com.iamkyun.nuky.data.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NukyUserServiceApplication.class)
public class NukyUserServiceApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        Optional<User> user = userRepository.findById(1L);
        System.out.println("user = " + (user.isPresent() ? user.get() :
                "empty"));
    }

}