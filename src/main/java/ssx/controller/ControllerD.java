package ssx.controller;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssx.entity.DBSchemaD;
import ssx.service.ServiceD;
import ssx.util.RedisD;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("five/")
@Controller
public class ControllerD {

@Autowired
    ServiceD serviceD;

    @RequestMapping( value = "/s.do",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map fun1(@RequestBody Map jsonpObject){
        HashMap map = new HashMap();
        map.put("status","succ");

        try {
            Object data = jsonpObject.get("data");

            DBSchemaD que = serviceD.que((String) data);
            String value = que.getValue();
            map.put("data",value);
        }catch (Exception e){
            map.put("status","fail");
        }

        return map;
    }


    @RequestMapping(value = "/i.do",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map fun2(@RequestBody Map jsonpObject){
        HashMap map = new HashMap();
        map.put("status","succ");
        String data1 = jsonpObject.get("data").toString();
        DBSchemaD data = new DBSchemaD("" + new Date().getTime(), data1);
        boolean valuesssss = serviceD.add(data);
        try {
            map.put("data",valuesssss);
        }catch (Exception e){
            map.put("status","fail");
        }
        return map;
    }


    @RequestMapping(value = "/r.do")
    @ResponseBody
    public Map redisTest(@RequestBody Map rm){
        HashMap map = new HashMap();

        Object data = rm.get("data");
        String main = RedisD.main(data.toString());
        map.put("varr",main);
        return map;
    }
}
