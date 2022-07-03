package cn.chinatelecom.online_class.handler;

import cn.chinatelecom.online_class.exception.CustomException;
import cn.chinatelecom.online_class.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(CustomException.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData CustomExceptionHandler(Exception e){
        if(e instanceof CustomException){
            CustomException ce = (CustomException)e;
            return JsonData.buildError(ce.getCode(),ce.getMsg());
        }else{
            return JsonData.buildError(null,-1,"Global error: invalid exception");
        }
    }
}