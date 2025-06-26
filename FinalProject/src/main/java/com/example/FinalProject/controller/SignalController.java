package com.example.FinalProject.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.entity.Vehicle;
import com.example.FinalProject.service.SignalService;
import com.example.FinalProject.tool.tojson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.example.FinalProject.tool.UniqueStringGeneratorWithBase64.generateUniqueString;

@RestController
@RequestMapping(value = "/signal")
public class SignalController {

    @Autowired
    private SignalService signalService;

    @RequestMapping(value = "/info")
    public Signal getBatterySignalByCid(HttpServletRequest request) throws IOException {
        JSONObject jsonobj = tojson.httptojson(request);
        int cid = 0;
        try {
            cid = jsonobj.getIntValue(("ID"));
        } catch (Exception e) {
            //  处理错误的代码块
            System.out.println("ID非法输入");
        }
        return signalService.getBatterySignalByCid(cid);
    }

    @RequestMapping(value = "/add")
    public boolean addBatterySignal(HttpServletRequest request) throws IOException {
        Signal result = new Signal();
        JSONObject jsonobj = tojson.httptojson(request);
        try {
            result.setCid(jsonobj.getIntValue(("ID")));
            result.setMx(jsonobj.getDoubleValue(("Mx")));
            result.setMi(jsonobj.getDoubleValue(("Mi")));
            result.setLx(jsonobj.getDoubleValue(("Lx")));
            result.setLi(jsonobj.getDoubleValue(("Li")));
        } catch (Exception e) {
//            //  处理错误的代码块
            System.out.println("非法输入");
        }


        return signalService.insertSignal(result);
    }

    @RequestMapping(value = "/update")
    public boolean updateBatterySignal(HttpServletRequest request) throws IOException {


        JSONObject jsonobj = tojson.httptojson(request);
        int cid = 0;
        try {
            cid = jsonobj.getIntValue(("ID"));
        } catch (Exception e) {
            //  处理错误的代码块
            System.out.println("ID非法输入");
        }
        Signal result = signalService.getBatterySignalByCid(cid);
        try {

            result.setMx(jsonobj.getDoubleValue(("Mx")));
            result.setMi(jsonobj.getDoubleValue(("Mi")));
            result.setLx(jsonobj.getDoubleValue(("Lx")));
            result.setLi(jsonobj.getDoubleValue(("Li")));
        } catch (Exception e) {
//            //  处理错误的代码块
            System.out.println("非法输入");
        }

        return signalService.updateBatterySignal(result);
    }

    @RequestMapping(value = "/delete")
    public boolean deleteBatterySignal(HttpServletRequest request) throws IOException {


        JSONObject jsonobj = tojson.httptojson(request);
        int cid = 0;
        try {
            cid = jsonobj.getIntValue(("ID"));
        } catch (Exception e) {
            //  处理错误的代码块
            System.out.println("ID非法输入");
        }

        return signalService.deleteSignal(cid);
    }

}
