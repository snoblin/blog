package tk.snolin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import tk.snolin.blog.entity.Blog;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.entity.PictureResult;
import tk.snolin.blog.service.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/")
    public String admin(){
        return "/admin";
    }


    @PostMapping("/upload")
    @ResponseBody()
    public PictureResult uploadFile(MultipartHttpServletRequest request) throws IOException{
        request.setCharacterEncoding("UTF-8");
        PictureResult result = new PictureResult();
        ArrayList<String> data = new ArrayList<>();
        Iterator<String> names= request.getFileNames();
        while(names.hasNext()){
            MultipartFile file = request.getFile(names.next());
            if(!file.isEmpty()){
                try {
                    BufferedOutputStream out =
                            new BufferedOutputStream(
                                    new FileOutputStream(
                                            new File("G:/pictures/" + file.getOriginalFilename())));
                    //System.out.println(file.getOriginalFilename());
                    out.write(file.getBytes());
                    out.close();
                    result.setErrno(0);
                    data.add("/static/" + file.getOriginalFilename());
                }catch(IOException e){
                    e.printStackTrace();
                    result.setErrno(1);
                }
            }
            result.setData(data);
        }

        return result;
    }


    @PostMapping("/save")
    @ResponseBody
    public String saveBlog(@RequestBody Blog blog){
        boolean success = adminService.saveBlog(blog);
        return success?"true":"false";
    }

    @PostMapping("/getall")
    @ResponseBody
    public List<BlogMain> getBlog(){
        return adminService.getAllBlog();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteBlog(HttpServletRequest request){
        if(adminService.deleteBlogById(Integer.parseInt(request.getParameter("id")))) {
            return "true";
        }
        return "false";
    }
    @PostMapping("/update")
    @ResponseBody
    public String updateBlog(@RequestBody Blog blog){
        boolean success = adminService.updateBlogById(blog);
        return  success?"true":"false";
    }
}
