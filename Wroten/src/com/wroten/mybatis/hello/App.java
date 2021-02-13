package com.wroten.mybatis.hello;

import com.wroten.mybatis.util.MyBatisUtil;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;


public class App {

    private static final Logger logger = Logger.getLogger(App.class);

    @Test
    public void testLog() {
        if (logger.isInfoEnabled()) {
            logger.info("转账操作info");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("查询操作debug");
        }
        if (logger.isTraceEnabled()) {
            logger.trace("链接数据库trace");
        }
    }

    @Test
    public void testGet() {
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            User u = new User();
            u.setId(2L);
            User user = sqlSession.selectOne("com.wroten.mybatis.hello.UserMapper.get", 2L);
            System.out.println(user);
        }
    }

    @Test
    public void testListAll() {
        @Cleanup
        SqlSession sqlSession = MyBatisUtil.getSession();
        List<User> us = sqlSession.selectList("com.wroten.mybatis.hello.UserMapper.listAll");
        sqlSession.close();
        for (User u : us
        ) {
            System.out.println(u);
        }
    }

    @Test
    public void testUpdate() {
        @Cleanup
        SqlSession sqlSession = MyBatisUtil.getSession();
        User u = new User();
        u.setId(4L);
        u.setName("叶孤城");
        u.setSalary(new BigDecimal("1100"));
        sqlSession.update("com.wroten.mybatis.hello.UserMapper.update", u);
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        @Cleanup
        SqlSession sqlSession = MyBatisUtil.getSession();
        sqlSession.delete("com.wroten.mybatis.hello.UserMapper.delete", 4L);
        sqlSession.commit();
    }

    @Test
    public void testSave() {
        @Cleanup
        SqlSession sqlSession = MyBatisUtil.getSession();
        User u = new User();
        u.setName("楚留香");
        u.setSalary(new BigDecimal("700"));
        sqlSession.insert("com.wroten.mybatis.hello.UserMapper.save", u);
        sqlSession.commit();
        System.out.println(u);
    }
}
