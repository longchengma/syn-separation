package com.home.spring.aop;

/**
 * Created by li.ma on 2018/8/8.
 */

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AopTest {
    @Test
    public void testHelloWorld() {
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("aop/helloWorld.xml");
        IHelloWorldService helloWorldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayHello();
    }


    @Test
    public void testHelloWorld1() {
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("META-INF/spring/spring-webmvc.xml");
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
        String url = "http://192.168.103.48:9098/erp-gateway-web/account/profile/login";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("account", "mali");
        jsonObj.put("password", "Fs123qwe~");
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        ResponseEntity<Object> responseResponseEntity = restTemplate.postForEntity(url, formEntity, Object.class);
        Map<String, Object> body = (Map<String, Object>) responseResponseEntity.getBody();
        Map<String, Object> data = (Map<String, Object>) body.get("data");
        System.out.println(data.get("pid"));
    }


    @Test
    public void testHelloWorld2() {
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("META-INF/spring/spring-webmvc.xml");
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
        String url = "http://192.168.103.48:9098/erp-gateway-web/account/menu/query_by_pid";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("pid", 100750);
        jsonObj.put("role_id", 1111);
        jsonObj.put("platform_id", 4);
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        ResponseEntity<Object> responseResponseEntity = restTemplate.postForEntity(url, formEntity, Object.class);
        Map<String, Object> body = (Map<String, Object>) responseResponseEntity.getBody();
        List<LinkedHashMap> data = (List<LinkedHashMap>) body.get("data");


        Map<String, List<MenuInfoResponseBO>> map = new LinkedHashMap<>();

        converList(data, map);


        System.out.println(map);
    }

    private void converList(List<LinkedHashMap> data, Map<String, List<MenuInfoResponseBO>> map) {
        List<MenuInfoResponseBO> menuList;
        for (LinkedHashMap item : data) {
            menuList = new ArrayList<>();

            List<LinkedHashMap> sub = (List<LinkedHashMap>) item.get("sub");

            for (LinkedHashMap subItem : sub) {
                menuList.add(new MenuInfoResponseBO((String)subItem.get("menu_url"), (String)subItem.get("menu_name")));
            }
            map.put((String)item.get("menu_name"), menuList);
        }
    }

}