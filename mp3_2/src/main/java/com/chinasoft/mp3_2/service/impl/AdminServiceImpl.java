package com.chinasoft.mp3_2.service.impl;

import com.chinasoft.mp3_2.dao.AdminMapper;
import com.chinasoft.mp3_2.service.AdminService;
import com.chinasoft.mp3_2.util.FileUtil;
import com.chinasoft.mp3_2.util.RedisUtil;
import com.chinasoft.mp3_2.util.RequestUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;

    @Autowired
    public RedisUtil redisUtil;

    @Override
    public List<Map<String, Object>> selectAdminAll() {
        return adminMapper.selectAdminAll();
    }

    @Override
    public List<Map<String, Object>> selectUserByNameAndPassWord(Map<String, Object> map) {
        /*注意  数据通过限定参数区分*/
        String key="user_"+map.get("userName")+map.get("passWord");
        boolean hasKey=redisUtil.hasKey(key);
        if(hasKey){
      List<Map<String,Object>> list= (List<Map<String, Object>>) redisUtil.get(key);
     System.out.println("从redis缓存中获取数据："+list);
  return  list;
        }else{
         List<Map<String,Object>> list=adminMapper.selectUserByNameAndPassWord(map);
         System.out.println("查询数据库获得数据"+list);
         System.out.println("------数据结果集存入缓存中------------------");
            //写入缓存  最好在缓存中添加生效时间 默认是秒单位
         redisUtil.set(key,list, RequestUtil.RandomNumber(14,30));
         return  list;
        }

    }

    @Override
    public List<Map<String, Object>> selectMp3Index(Map<String, Object> map) {
         /*注意  后端要配合前端进行limit分页查询
         * 后端需要使用pageHelper分页控件。则不要在controller层中调用
         * 在Service的Impl 接口实现类中，调用后端控件 因为有具体的方法执行体。*/
         /*注意调用PageHelper的三个参数传入，第一个参数为当前页码数 第二个参数是分页数据量 第三个参数是查询数据的排序规则*/
        String key="mp3Table_"+map.get("page")+map.get("limit")+map.get("mp3Name")+map.get("mp3Man");
        boolean hasKey=redisUtil.hasKey(key);
        if(hasKey){
List<Map<String,Object>> list= (List<Map<String, Object>>) redisUtil.get(key);
            System.out.println("从redis缓存中获取数据："+list);
            System.out.println("------------");
            return  list;
        }else{
            PageHelper.startPage(Integer.parseInt(map.get("page")+"")
                    ,Integer.parseInt(map.get("limit")+"")," mp3Id desc");
             List<Map<String,Object>> list=adminMapper.selectMp3Index(map);
            System.out.println("查询数据库获得数据："+list);
            System.out.println("------数据结果集存入缓存中 若干秒生效时间------------------");
            redisUtil.set(key,list, RequestUtil.RandomNumber(14,30));
            return  list;
        }
    }

    @Override
    public boolean insertMp3Data(Map<String, Object> map) {
        /*执行DML时 redis缓存在执行SQL指令后 及时复位清空
        * 数据持久层缓存 在DML增删改操作后 都要及时清空复位
        * 以便数据更新后 进行新的查询结果集 记录*/
        boolean mark=adminMapper.insertMp3Data(map);
       if(mark){
       /*如果进行过数据更新  则之前的查询结果集 页码缓存 清除*/
           String key="mp3Table_";
           redisUtil.redisDeletes(key);
       }
        return mark;
    }

    @Override
    public boolean deleteMp3DataByIds(String[] mp3Ids,String[] mp3ManImgs,String[] mp3Srcs, HttpServletRequest request) {
        /*先删除IO文件，再删除Mysql数据记录*/
        FileUtil.fileDelete(mp3ManImgs,request);
        FileUtil.fileDelete(mp3Srcs,request);
        /*删除Mysql数据记录后  继续清空redis的运行缓存信息*/
        boolean mark=adminMapper.deleteMp3DataByIds(mp3Ids);
        if(mark){
            String key="mp3Table_";
            redisUtil.redisDeletes(key);
        }
        return mark;
    }


}
