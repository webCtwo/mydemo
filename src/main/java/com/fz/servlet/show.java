package com.fz.servlet;

import com.fz.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Sir.Cui on 2017/1/11 19:54.
 */
@WebServlet("/show.ok")
public class show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf.xml"));
        SqlSession s = sf.openSession();
        PrintWriter out = resp.getWriter();

        if(req.getParameter("id")!=null){
            int id = Integer.parseInt(req.getParameter("id").toString());
            s.delete("dd",id);//dd为StudentMapper
            s.commit();

        }
        List<Student> list = s.selectList("aa");
        req.setAttribute("st",list);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
        out.flush();
        out.close();
    }
}
