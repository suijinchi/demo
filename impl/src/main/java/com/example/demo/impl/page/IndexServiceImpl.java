package com.example.demo.impl.page;

import com.example.demo.service.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.service.IndexService;

/**
 * @auther suijinchi
 * @description
 * @date 2022/3/18
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${test.username}")
    String username;

    public User getUser() {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
