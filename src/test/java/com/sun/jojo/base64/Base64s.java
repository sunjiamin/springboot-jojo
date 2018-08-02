//package com.sun.jojo.base64;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class Base64s {
//
//    public static void main(String[] agrs){
//        String text = "jojo is beautiful";
//
//        String  encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
//        System.out.println(encoded);
//
//        String decoded = new String (Base64.getDecoder().decode(encoded),StandardCharsets.UTF_8);
//        System.out.println(decoded);
//
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
//        //concurrentHashMap.put()
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        //加密"0"
//        String encode = bCryptPasswordEncoder.encode("0");
//        System.out.println(encode);
//
//
//    }
//}
