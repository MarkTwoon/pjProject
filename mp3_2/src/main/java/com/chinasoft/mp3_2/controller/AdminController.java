package com.chinasoft.mp3_2.controller;


import com.chinasoft.mp3_2.service.AdminService;
import com.chinasoft.mp3_2.util.FileUtil;
import com.chinasoft.mp3_2.util.RequestUtil;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*第一个IOC方面的  业务逻辑控制器*/
@RestController
/*控制层的二级目录*/
@RequestMapping("admin")
public class AdminController {
   /*引入ORM的Service层 做为当前控制器的类变量  全局变量*/
  @Autowired
   private AdminService adminService;

  @RequestMapping("GeetestOnLoad")
  public void  GeetestOnLoad(HttpServletRequest request, HttpServletResponse response){
      RequestUtil.GeetestOnLoad(request,response);
  }

  @RequestMapping("login")
  public void login(HttpServletRequest request,HttpServletResponse response){
 /*当前登录控制器 分2步进行
 * 第一步  和工具类中  验证码判断状态 功能一致*/

 /*第二步 继续判断账户与密码 在数据库中是否已存在，是否为已注册账户  select * where usename and password */
try{
    PrintWriter out=response.getWriter();
    JSONObject data=RequestUtil.GeetestBy(request, response);
    //data.put();  可以继续进行登录账户的 数据库相关查询
    Map<String,Object> map=RequestUtil.getQueryMap(request);
    List<Map<String,Object>> list=adminService.selectUserByNameAndPassWord(map);
   data.put("LoginStatus",list.size());

    out.println(data.toString());
}catch (Exception e){
    e.printStackTrace();
}

  }

  @RequestMapping("index")
    public Object index(@RequestBody Map<String,Object> map){
       List<Map<String,Object>> list=adminService.selectMp3Index(map);
      /*map.put("total",list.size());*/
      PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(list);
      map.put("total",pageInfo.getTotal());
      map.put("list",list);
     //System.out.println("当前页码值："+map.get("page")+"  当前分页量："+map.get("limit"));
      return  map;
  }

  @RequestMapping("uploadMp3")
    public Object uploadMp3(MultipartFile mp3ManImg,MultipartFile mp3Src, HttpServletRequest request){
     Map<String,Object> map=RequestUtil.getQueryMap(request);
     map.put("mp3ManImg",FileUtil.fileUpload(mp3ManImg,request));
     map.put("mp3Src",FileUtil.fileUpload(mp3Src,request));
     map.put("mp3Big",(mp3Src.getSize()/1024.0/1024.0+"")
     .substring(0,(mp3Src.getSize()/1024.0/1024.0+"").lastIndexOf(".")+2)+"MB");
     return adminService.insertMp3Data(map);
    }

    @RequestMapping("deleteMp3Data")
   public Object deleteMp3Data(@RequestBody Map<String,Object> map,HttpServletRequest request){
    /*后端 再从map容器中  获取三个字符串 切割成Java的 字符串数组*/
        /*id数组 用于迭代删除SQL数据*/
   String[] mp3Ids=(map.get("mp3Ids")+"").split(",");
  /*相对路径数组 用于IO流的 文件对象删除*/
   String[] mp3ManImgs=(map.get("mp3ManImgs")+"").split(",");
   String[] mp3Srcs=(map.get("mp3Srcs")+"").split(",");
/*先删除io文件  再删除SQL数据*/
      return  adminService.deleteMp3DataByIds(mp3Ids,mp3ManImgs,mp3Srcs,request);
    }

}
