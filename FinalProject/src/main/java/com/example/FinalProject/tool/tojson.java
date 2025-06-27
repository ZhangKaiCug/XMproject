package com.example.FinalProject.tool;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;

// 使用 getInputStream()

public class tojson {

    public static JSONObject httptojson(HttpServletRequest request) throws IOException {
        String result = "";
        BufferedReader in = null;
        try {
            in= new BufferedReader(new InputStreamReader(
                    request.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return (JSONObject) JSONObject.parse(result);

    }
}

