package tk.snolin.blog.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.resources.CalendarData;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.service.BaseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private BaseServiceImpl baseService;

    @RequestMapping("/")
    public String home(ModelMap map){
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        map.addAttribute("year",year);
        return "/index";
    }

    @ResponseBody
    @GetMapping("/page")
    public PageInfo<BlogMain> blogPage(HttpServletRequest request){
        return
                baseService.
                        getPageContent(Integer.parseInt(request.getParameter("currentPage")),
                                Integer.parseInt(request.getParameter("pageSize")));
    }

    @GetMapping("/article")
    public String Page(HttpServletRequest request,ModelMap map){
        int blogId = Integer.parseInt(request.getParameter("aid"));
        BlogMain blogMain = baseService.selectBlogById(blogId);
        map.addAttribute("title",blogMain.getTitle());
        map.addAttribute("text",blogMain.getText());
        map.addAttribute("createTime",blogMain.getCreateTime());
        map.addAttribute("tags",blogMain.getTagList());
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        map.addAttribute("year",year);
        return "/article";
    }
}
