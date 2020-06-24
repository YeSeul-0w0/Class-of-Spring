package kr.ac.jejunu.user.Controller;

import kr.ac.jejunu.user.DTO.Post;
import kr.ac.jejunu.user.DAO.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.logging.Logger;

@Controller
//@RequiredArgsConstructor
public class PostController {
    @Autowired
    private PostDao postDao;

    @RequestMapping(path = "/post")
    public Post getUser(@RequestParam("id") Integer id) {
        if (id <= 0) {
            id = 1;
        }
        if (id >= postDao.count()) {
            id = postDao.count();
        }
        return postDao.get(id);
    }


    @RequestMapping("/start")
    public ModelAndView startHtml() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", "/WEB-INF/static/startimg.jpg");
        return modelAndView;
    }


    @RequestMapping(value = "/update",  method = RequestMethod.POST)
    public String update(@ModelAttribute Post post) {
        postDao.insert(post);
        Integer id = post.getId();
        return "redirect:/post?id=" + id;
    }

    @RequestMapping("/upload")
    public void upload() {

    }



    @RequestMapping(path = "/modify")
    public Post modify(@RequestParam("id") Integer id) {
        return postDao.get(id);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyPost(@ModelAttribute Post post) {
        System.out.println(post.getId());
        postDao.update(post);
        Integer id = post.getId();
        return "redirect:/post?id=" + id;
    }

}
