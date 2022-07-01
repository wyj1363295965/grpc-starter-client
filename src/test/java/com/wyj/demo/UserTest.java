package com.wyj.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyj.demo.entity.User;
import com.wyj.demo.mapper.UserMapper;
import com.wyj.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
public class UserTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void test7() {
        //tbUserService.save(null);
    }

    @Test
    public void test1() {
        //查询name不为空的用户，并且邮箱不为空的用户，年龄大于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test2() {
        //查询名字为五毛
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "派大星");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3() {
        //查询年龄在16-30岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.between("age", 16, 30);
        Long count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    //模糊查询
    @Test
    void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //左和右  是指通配符在左边还是右边 t%
        wrapper.notLike("name", "l")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);

    }

    //排序
    @Test
    void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("id");

        //通过id进行排序
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
}
