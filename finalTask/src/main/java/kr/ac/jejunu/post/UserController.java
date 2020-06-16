package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
//@RequestMapping("/post") //최상위
@RequiredArgsConstructor
public class UserController {
    private final PostDao postDao;
    @RequestMapping(path="/post")
    public ModelAndView getUser(@RequestParam("id") Integer id){
        ModelAndView modelAndView=new ModelAndView("user");
        modelAndView.addObject("postInfo",postDao.get(id));
        return modelAndView;
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
