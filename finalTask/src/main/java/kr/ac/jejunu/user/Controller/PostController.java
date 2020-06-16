package kr.ac.jejunu.user.Controller;

import kr.ac.jejunu.user.DTO.Post;
import kr.ac.jejunu.user.DAO.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
//@RequiredArgsConstructor
public class PostController {
    @Autowired
    private PostDao postDao;

@RequestMapping(path="/post")
    public Post getUser(@RequestParam("id") Integer id){
        return postDao.get(id);
    }

    @RequestMapping("/exception")
    public void exception(){
        throw new RuntimeException("어이쿠!");
    }
    @GetMapping("/upload")
    public void upload(){

    }
    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        File path = new File(request.getServletContext().getRealPath("/")+"/WEB-INF/static/"+file.getOriginalFilename());
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("url","/images/"+file.getOriginalFilename());
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e){
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("e",e);
        return modelAndView;
    }
}
