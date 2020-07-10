package com.blog.controller.foreign;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.entity.Blog;
import com.blog.service.BlogService;
import com.blog.utils.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private BlogService blogService;

    /**
     * 首页查询最新列表
     * @param blog  博客查询条件
     * @param current   当前页码
     * @param model
     * @return
     */
    @RequestMapping(value = {"/","/index","/index.html"})
    public String index(Blog blog, @RequestParam(value = "page",defaultValue = "1")Long current, Model model){
        int size = 5;
//        创建分页对象，指定当前页码及每页显示数量
        Page<Blog> page = new Page<Blog>(current,size);


        StringBuffer param = new StringBuffer();
//        判断查询条件是否为空
        if (blog!=null){
            if (blog.getTypeId()!=null){
                param.append("typeId="+blog.getTypeId());
            }
            if (blog.getReleaseDateStr()!=null && !blog.getReleaseDateStr().equals("")){
                param.append("releaseDateStr="+blog.getReleaseDateStr());
            }
        }

//        分页查询
        IPage<Blog> blogIPage = blogService.findBlogByPage(page,blog);
//        获取博客数据列表
        List<Blog> blogList = blogIPage.getRecords();
//        将对象放到模型中
        model.addAttribute("blogList",blogList);
//        页面代码块，在index.html页面的中间内容代码块使用th:insert
        model.addAttribute("pageContent","foreign/main");
//        分页代码
        model.addAttribute("pageCode",
                PageUtil.genPagination("/",blogIPage.getTotal(),current.intValue(),size,param.toString()));
        return "index";
    }
}
