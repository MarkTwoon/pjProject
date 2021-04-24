package com.chinasoft.jinrong_api.exception;

import com.chinasoft.jinrong_api.util.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*后端 异常抛出的捕获类
* 处理与用户 相关的数据业务异常*/
@RestController
@ResponseBody
 @ControllerAdvice(basePackages = {"com.chinasoft.jinrong_api.controller",
"com.chinasoft.jinrong_api.service.impl"})
public class CustomExceptionAdvice   {
/*一旦捕获自定义异常  记得slf4j 打印一下日志记录*/
  private  static  final Logger logger=
        LoggerFactory.getLogger(CustomExceptionAdvice.class);




  @ExceptionHandler(value = MyException.class)
    public ReturnData userExceptionHandle(HttpServletRequest request,MyException e){
      logger.error("错误码:{},错误信息:{},用户信息异常：Host:{},invoke URL:{}",
             e.getCode(),e.getMessage(),request.getRemoteHost(),request.getRequestURL());
        return new ReturnData(e.getCode(),e.getMessage());
  }
}
