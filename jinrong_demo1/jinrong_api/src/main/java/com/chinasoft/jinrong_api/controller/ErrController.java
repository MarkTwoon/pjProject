package com.chinasoft.jinrong_api.controller;

import com.chinasoft.jinrong_api.exception.MyException;
import com.chinasoft.jinrong_api.util.ReturnData;
import com.chinasoft.jinrong_api.exception.StatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
/*异步控制层 中的控制器
* 均为异步控制器*/
public class ErrController {

    @RequestMapping("/error")
   public Object error(Exception exception, HttpServletResponse response){
    /* String StatCode=exception.*/
      /*return new ReturnData(response.getStatus(),"请求异常！");*/
       /* return new ReturnData(StatusCode.RETURN_ERROR,"请求异常！");*/
        throw new MyException(StatusCode.RETURN_ERROR,"抱歉，请求异常！ERROR");
    }

}
