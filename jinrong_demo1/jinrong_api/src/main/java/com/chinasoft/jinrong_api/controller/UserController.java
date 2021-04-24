package com.chinasoft.jinrong_api.controller;

import com.chinasoft.jinrong_api.exception.MyException;
import com.chinasoft.jinrong_api.util.FinalMsg;
import com.chinasoft.jinrong_api.util.ReturnData;
import com.chinasoft.jinrong_api.exception.StatusCode;
import com.chinasoft.jinrong_api.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
@RequestMapping("/")
public class UserController {
   @Resource
   private IUserService userService;

  @RequestMapping("/test")
    public Object test(@RequestParam Map<String,Object> map){
     return  new ReturnData(StatusCode.REQUEST_SUCCESS,
             userService.selectGoodsAll(map.get("goodsId")+""),"后端数据交互正常！");
  }
    @RequestMapping("/userImgUpload")
    public Object userImgUpload(HttpServletRequest request,
                                MultipartFile userImg, @RequestParam Map<String,Object> map){
      System.out.println(userImg+">>>>>>>>>>");
      if(userImg==null){
               throw  new MyException(StatusCode.USER_NOT_EXIST,"传输数据为空");
           }
        /*创建新文件名   一个原则 新文件名不能重复*/
        String newFileName=UUID.randomUUID().toString().replaceAll("-", "")
                +userImg.getOriginalFilename().substring(userImg.getOriginalFilename().lastIndexOf("."));
        String newFilePath=request.getSession().getServletContext()
                .getRealPath("/upload/")+newFileName;
      /*System.out.println(newFilePath);*/
        /*新文件 对象实例化*/
       // File newFile=new File(newFilePath);
        Map<String,Object> map1=new HashMap<String,Object>();
        try {
                userImg.transferTo(new File(newFilePath));
            map1.put("imgName",newFileName);
            }catch (Exception e){
            map1.put("imgName","404.png");
e.printStackTrace();
            }
            return  new ReturnData(StatusCode.REQUEST_SUCCESS,map1,"上传用户头像图片正常");
    }

    @RequestMapping(value = "/getCityData")
    public Object getCityData(@RequestParam Map<String,Object> map){
       /* IOC调用ORM 数据持久化 json信息传输 略 */
       List<Map<String,Object>> list=userService.selectCityMainByWhere(map);
        if(list.size()>0){
            return  new ReturnData(StatusCode.REQUEST_SUCCESS,
                    list,"查询城市数据交互正常！");
        }else{
            throw new MyException(StatusCode.DATA_NULL,"抱歉，暂无城市数据选择！");
        }
      /*  return  new ReturnData(StatusCode.REQUEST_SUCCESS,
                "后端数据API返回数据正常","后端数据交互正常！");*/
    }
    @RequestMapping(value = "/indexPageMainData",method = RequestMethod.POST)
    public Object indexPageMainData(HttpServletRequest request,
                                    @RequestParam Map<String,Object> map){
      /*根据城市ID编号 获取对应的城市活动页面 默认主信息并返回*/
        Map<String,Object> data=new HashMap<String,Object>();
        List<Map<String,Object>> indexData1=userService.selectIndexPageHeadNumber(map);
        List<Map<String,Object>> indexData2=userService.selectCityCouponByCityId(map);
        if(indexData1.size()>0&&indexData2.size()>0){
            data.put("indexData1",indexData1.get(0));
            data.put("indexData2",indexData2.get(0));
        }else{
        throw  new MyException(StatusCode.DATA_NULL,"该城市暂未开放商家活动");
        }
        /*data.put("indexData1",userService.selectIndexPageHeadNumber(map).get(0));
        data.put("indexData2",userService.selectCityCouponByCityId(map).get(0));*/
        /*打开主页面 则进行异步交互 判断是否已登录。
        * 若未登录 则session之中健值数据为null 返回前端页面  要求登录或注册*/
        data.put("userData",
                request.getSession().getAttribute(FinalMsg.SESSION_USERDATA));
      return  new ReturnData(StatusCode.REQUEST_SUCCESS,data,"检索城市活动数据信息正常！");
    }

    @RequestMapping(value = "/winUserData",method = RequestMethod.POST)
        public Object winUserData(@RequestParam Map<String,Object> map){
        List<Map<String,Object>> list=userService.selectSuccessUserList(map);
        if(list.size()<=0){
            throw  new MyException(StatusCode.DATA_NULL,"暂无参与用户获奖");
        }
    return  new ReturnData(StatusCode.REQUEST_SUCCESS,list,"查询获奖用户 数据成功！");
    }

    @RequestMapping(value = "/businessTypeAndGoodsData",method = RequestMethod.POST)
    public Object businessTypeAndGoodsData(@RequestParam Map<String,Object> map){
        /*执行ORM过程 返回查询结果集的list*/
    Map<String,Object> data=new HashMap<String,Object>();
    if(Integer.parseInt(map.get("markId")+"")==1){
        /*markId是axios的后端执行次数
        只需要在第一次axios中返回商家类型数据即可 后面均不执行该冗余 SQL指令 注意异步执行效率*/
  List<Map<String,Object>>  businessTypeList=userService.selectBusinessTypeList();
  data.put("businessTypeList",businessTypeList.size()<=0?"暂无商家类型数据":businessTypeList);
    }

   List<Map<String,Object>>  goodsList=userService.ActivitiesCouponListToIndex(map);
      data.put("goodsList",goodsList.size()<=0?"暂无优惠券信息数据":goodsList);
      return new ReturnData(StatusCode.REQUEST_SUCCESS,data,"查询商家类型 及优惠券数据成功");
    }

    @RequestMapping(value = "/checkOrLoginUserMain",method = RequestMethod.POST,params = {"userPhone"})
    public Object checkUserMain(HttpServletRequest request,
                                @RequestParam Map<String,Object> map){
        List<Map<String,Object>> list=userService.selectUserNameAndPassWord(map);
          /*登录又分2块 表单验证与提交登录*/
        boolean msg=false;
      Map<String,Object> map1=new HashMap<String,Object>();
        if(list.size()>0) {
            /*如果是提交登录的情况下 有结果集 session记录 登录用户*/
            map1=list.get(0);
            if (map.containsKey("userPassWord")) {
                request.getSession().setAttribute(FinalMsg.SESSION_USERDATA,map1);
            }
            msg=true;
        }else{
            msg=false;
        }
        map1.put("msg",msg);
    return new ReturnData(StatusCode.REQUEST_SUCCESS,map1,"查询用户个人信息成功");
    }

    @RequestMapping(value = "/registerUserOne",method = RequestMethod.POST,
            params = {"userPhone","userPassWord"})
    public Object registerUserOne(HttpServletRequest request,@RequestParam Map<String,Object> map){
        boolean msg=false;
        if(userService.insertUserMain(map)){
            if (map.containsKey("userPassWord")) {
                request.getSession().setAttribute(FinalMsg.SESSION_USERDATA,map);
            }
            msg=true;
        }else{
            msg=false;
        }
        /*在异步返回数据时 尽量返回复合数据容器类型*/
        return new ReturnData(StatusCode.REQUEST_SUCCESS,msg,"用户新增成功");
    }
}
