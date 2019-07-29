package tk.snolin.blog.entity;

import lombok.Data;

import java.util.List;


/**
 *
 * 映射tag表
 * */
@Data
public class Tag {
    private int id;
    private String tag;
    private List<BlogMain> blogMainList;
}
