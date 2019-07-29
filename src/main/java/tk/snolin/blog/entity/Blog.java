package tk.snolin.blog.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * 这是个用来接收josn数据javaBean
 * */
@Data
public class Blog {
    private int id;
    private String title;
    private String text;
    private ArrayList<String> tags;
}
