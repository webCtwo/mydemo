package com.fz;

import com.fz.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sir.Cui on 2017/1/11 19:29.
 */
public class Demo {
    SqlSessionFactory sf;
    SqlSession s;

    @Before
    public void init() throws IOException {
        sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf.xml"));
        //读取会话
        s = sf.openSession();
    }

    @Test
    public void abc() {
        //实现查询操作 返回List结果
        List<Student> sts = s.selectList("aa");
        for (Student st : sts) {
            System.out.println(st.getName());
        }
    }

    @After
    public void close(){
        s.close();
    }
}
