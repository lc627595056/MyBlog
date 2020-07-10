package com.blog.controller.foreign;


import com.blog.entity.Blog;
import com.blog.lucene.BlogIndex;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import com.blog.utils.SysConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @Resource
    private CommentService commentService;

    @Resource
    private BlogIndex blogIndex;

    @ResponseBody
    @RequestMapping("/blogDateList")
    public String blogDateList(){
        try {
//            调用查询博客日期和数量的方法
            return blogService.findBlogDateAndCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询博客详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        try {
//            查看详情
            Blog blog = blogService.findBlogById(id);
//            获取关键字
            if (blog!=null && blog.getKeyWord()!=null && blog.getKeyWord().length()!=0){
//                不为空，则进行拆分（按空格拆分）
                String []  keyWords = blog.getKeyWord().split(" ");
                model.addAttribute("keyWordList",keyWords);
            }else {
                model.addAttribute("keyWordList",null); //无关键字
            }

//            将博客信息保存到模型中
            model.addAttribute("blog",blog);
//            上一篇和下一篇
            model.addAttribute("pageCode",getUpAndDownPageCode(blogService.findPrevBlog(id),blogService.findNextBlog(id)));

            /*QueryWrapper<Comment> queryWrapper = new QueryWrapper<Comment>();
            queryWrapper.eq("blogId",id);//博客id
            queryWrapper.eq("state",1);
            //当前博客下的评论列表
            model.addAttribute("commentList",commentService.list());*/
            //当前博客下的评论列表
            model.addAttribute("commentList",commentService.findCommentByBlogId(id, SysConstant.COMMENT_STATE_OK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("pageContent","foreign/blog/view");
        return "index";
    }

    /**
     * 获取博客的上一篇和下一篇
     * @param prev
     * @param next
     * @return
     */
    private String getUpAndDownPageCode(Blog prev,Blog next){
        StringBuffer sb = new StringBuffer();
//        如果上一篇对象为空，表示没有上一篇
        if (prev==null || prev.getId()==null){
            sb.append("<p>上一篇：没有上一篇了~</p>");
        }else {
            sb.append("<p>上一篇：<a href='/blog/view/"+prev.getId()+"'>"+prev.getTitle()+"</a></p>");
        }

        //如果下一篇对象为空，表示没有下一篇
        if (next==null || next.getId()==null){
            sb.append("<p>下一篇：没有下一篇了~</p>");
        }else {
            sb.append("<p>下一篇：<a href='/blog/view/"+next.getId()+"'>"+next.getTitle()+"</a></p>");
        }
        return sb.toString();
    }

    @RequestMapping("/query")
    public String query(String keyWord, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        try {
//        每页显示的数量
            int pageSize = 3;
//        调用查询博客的方法
            List<Blog> blogList = blogIndex.searchIndex(keyWord);
//            计算集合中的分页
//            16
//            16>1*3 ? 3
//            16>3*3 ? 9
            Integer toIndex = blogList.size() >= page * pageSize ? page * pageSize : blogList.size();
//            将数据放到模型中 subList(参数1：开始的下标位置 参数2：结束位置)
            model.addAttribute("blogList",blogList.subList((page-1)*pageSize,toIndex));
            model.addAttribute("total",blogList.size()); //查询的结果数量
            model.addAttribute("keyWord",keyWord);
            model.addAttribute("pageContent","foreign/blog/result");
//            上一页 下一页
            model.addAttribute("pageCode",getUpAndDownPageCode(page,pageSize,blogList.size(),keyWord));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    /**
     * 生成上一页和下一页的标签
     * @param pageNo        当前页码
     * @param pageSize      每页显示数量
     * @param totalCount    总数量
     * @param keyWord       用户输入查询的关键词
     * @return
     */
    private String getUpAndDownPageCode(int pageNo,int pageSize,int totalCount,String keyWord){
        StringBuffer pageCode = new StringBuffer();

        //计算总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
        //判断总页数
        if(totalPage==0){
            return "";
        }else{
            pageCode.append("<nav>");
            pageCode.append("<ul class='pager'>");
            //判断是否能够点击上一页
            if(pageNo>1){
                pageCode.append("<li><a href='/blog/query?page="+(pageNo-1)+"&keyWord="+keyWord+"'>上一页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a>上一页</a></li>");
            }
            //判断是否能够点击下一页
            if(pageNo<totalPage){
                pageCode.append("<li><a href='/blog/query?page="+(pageNo+1)+"&keyWord="+keyWord+"'>下一页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a>下一页</a></li>");
            }
            pageCode.append("</ul></nav>");
        }

        return pageCode.toString();
    }

}

