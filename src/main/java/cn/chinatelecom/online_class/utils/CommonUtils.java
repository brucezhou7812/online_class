package cn.chinatelecom.online_class.utils;

import cn.chinatelecom.online_class.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.MessageDigest;
import java.util.Date;

public class CommonUtils {
    private static final String SECRET="bruce";
    private static final long EXPIRED= 7*24*60*6000;
    private static final String PREFIX="Zhou";
    private static final String SUBJECT="OnlineClass";
    public static String generateJWT(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRED))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .claim("head_img",user.getHead_img())
                .claim("user_name",user.getName())
                .claim("id",user.getId())
                .compact();
        token = token + PREFIX;
        return token;
    }

    public static Claims checkJWT(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }

    public static String MD5(String data){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("utf-8"));
            StringBuffer sb = new StringBuffer();
            for(byte b:array){
                sb.append(Integer.toHexString(((b&0xff)|0x100)).substring(1,3));
            }
            return sb.toString().toUpperCase();
        }catch (Exception e){

        }
        return null;
    }
}
