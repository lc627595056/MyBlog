package com.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.blog.entity.Blogtype;
import com.blog.dao.BlogtypeMapper;
import com.blog.service.BlogtypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.utils.SysConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
@Service
public class BlogtypeServiceImpl extends ServiceImpl<BlogtypeMapper, Blogtype> implements BlogtypeService {

    @Resource
    private BlogtypeMapper blogtypeMapper;

//springboot操作redis对象
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String getBlogTypeNameAndBlogCount() throws Exception {
//        从redis缓存中读取博客分类信息
        String blogTypeInfo = redisTemplate.opsForValue().get(SysConstant.BLOG_NAME_COUNT);
//        判断：redis缓存中是否存在分类的数据，如果缓存中没有数据，此时需要从数据库中查询，查询出来的结果要放在redis缓存中
//        为空，则表示缓存没有数据
        if (blogTypeInfo==null || blogTypeInfo.equals("") || blogTypeInfo.length()==0){
//          如果缓存中没有数据，此时需要从数据库中查询，查询出来的结果要放在redis缓存中
            List<Blogtype> blogtypeList = blogtypeMapper.getBlogTypeNameAndBlogCount();
//            将集合转换成json
            blogTypeInfo = JSON.toJSONString(blogtypeList);
//            将集合的数据放到缓存中
            redisTemplate.opsForValue().set(SysConstant.BLOG_NAME_COUNT,blogTypeInfo);
        }
        return blogTypeInfo;
    }
}
