package tk.snolin.blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.entity.Tag;
import tk.snolin.blog.mapper.BaseMapper;
import tk.snolin.blog.serviceimpl.BaseService;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseMapper baseMapper;
    @Override
    public PageInfo<BlogMain> getPageContent(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<BlogMain> blogMainList = baseMapper.selectAllBlogMain();
        for(BlogMain blogMain:blogMainList){
            List<Tag> tags = baseMapper.selectTagByBlogId(blogMain.getId());
            blogMain.setTagList(tags);
        }
        PageInfo<BlogMain> pageInfo = new PageInfo<>(blogMainList);
        return pageInfo;
    }

    @Override
    public BlogMain selectBlogById(int id) {
        return baseMapper.selectBlogById(id);
    }
}
