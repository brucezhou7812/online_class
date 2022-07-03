package cn.chinatelecom.online_class.interceptor;


import cn.chinatelecom.online_class.utils.CommonUtils;
import cn.chinatelecom.online_class.utils.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       try {
           String token = request.getHeader("token");
           if (token == null) {
               token = request.getParameter("token");
           }
           if (StringUtils.isEmptyOrWhitespaceOnly(token) || StringUtils.isNullOrEmpty(token)) {
               sendJsonMessage(response,JsonData.buildError(-1,"Please Login"));
               return false;
           }
           Claims claims = CommonUtils.checkJWT(token);
           if (claims != null) {
               Integer id = (Integer) claims.get("id");
               String name = (String) claims.get("user_name");
               request.setAttribute("id", id);
               request.setAttribute("user_name", name);
               return true;
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        sendJsonMessage(response,JsonData.buildError(-1,"Please Login"));
        return false;
    }

    public void sendJsonMessage(HttpServletResponse response, JsonData jsonData){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(jsonData);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(jsonString);
            printWriter.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
