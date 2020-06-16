package kr.ac.jejunu.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@Controller("/userServlet")
@WebServlet(urlPatterns = "/hello")
public class UserServlet extends GenericServlet {
    @Autowired
    private PostDao postDao;
    @Override
    public void destroy() {
        System.out.println("******* destroy ********");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("******* init ********");
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
        this.postDao =applicationContext.getBean("userDao", PostDao.class);
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("******* service ********");
    }
}
