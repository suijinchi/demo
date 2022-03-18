package com.example.demo.impl;

import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.dao.pojo.User;
import com.example.demo.dao.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.IndexService;

import java.util.List;

/**
 * @auther suijinchi
 * @description
 * @date 2022/3/18
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    public User selectUser() {

        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id");
        List<User> userList = userMapper.selectByExample(userExample);

        return userMapper.selectByPrimaryKey(1L);
    }
}
