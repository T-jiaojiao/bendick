package com.xr.ava.controller;

import com.xr.ava.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 航班接口
 */
@Controller
@RequestMapping("/GNF")
public class GuoNeiFlay {

    @RequestMapping(value = "/hangban",produces = "text/String;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String getFlyMes(String flightNo,String query_date) {
        System.out.println("进了查询飞机的方法");
        String jsonStr="";

        String host = "http://airtime.market.alicloudapi.com";
        String path = "/airtime";
        String method = "POST";
        String appcode = "1f3dfe6d0941430196dbf590c6c27da8";
        Map<String, String> headers = new HashMap<String, String>();
        System.out.println(headers);
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        System.out.println(querys+""+bodys);
        bodys.put("flightNo", flightNo);
        bodys.put("query_date", query_date);
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
