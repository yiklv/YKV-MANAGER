package com.yiklv.trvAdmin.utils.other;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import com.alibaba.fastjson.JSON;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.other
 * <br><b>ClassName:</b> JsonUtil
 * <br><b>Date:</b> 2018年3月24日 下午9:42:42
 */
public class JsonUtil {

    /**
     * 将字符串转成实体类，允许斜杠等字符串
     */
    public static <T> T jsonToEntity(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 允许反斜杆等字符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        return mapper.readValue(json, clazz);
    }

    /**
     * 实体类转JSON字符串
     */
    public static String entityToJson(Object entity) {
        return JSON.toJSONString(entity);
    }

    /**
     * 将字符串转成JsonNode，允许斜杠等字符串
     */
    public static JsonNode jsonToJsonNode(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 允许反斜杆等字符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // 允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        return mapper.readValue(json, JsonNode.class);
    }

    public static <T> String objectToJson(Object object, Class<T> cls) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(cls);
        String reqJson = mapper.writeValueAsString(object);
        return reqJson;
    }
    
    

}
