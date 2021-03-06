package com.sajor.study.c06.dao;

import com.sajor.study.c06.model.Job;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class JobDAO {
    /**
     * 根据用户编号查询用户及简历信息
     */
    public Job findJobsWithResumeByID(int id) throws Exception {
        // 1、读取配置文件
        String resource = "mybatis-config-c06-relation.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 2、根据配置文件构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3、通过 SqlSessionFactory 创建 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4、SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        Job job = sqlSession.selectOne("com.sajor.study.c06.mapper.JobMapper.findJobWithResumesByID", id);
//        Job job = sqlSession.selectOne("com.sajor.study.c06.mapper.JobMapper.findJobWithResumesByID2", id);

        // 5、关闭 SqlSession
        sqlSession.close();
        return job;
    }

}