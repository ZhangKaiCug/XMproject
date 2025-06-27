package com.example.FinalProject.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.FinalProject.entity.Vehicle;
import com.example.FinalProject.service.VehicleService;
import com.example.FinalProject.tool.tojson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.example.FinalProject.tool.UniqueStringGeneratorWithBase64.generateUniqueString;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/info")
    public Vehicle getVehicleInfo(HttpServletRequest request) throws IOException {
        Vehicle result;
        JSONObject jsonobj = tojson.httptojson(request);
        int id = 0;
        try {
            id = jsonobj.getIntValue(("ID"));
        } catch (Exception e) {
            //  处理错误的代码块
            System.out.println("ID非法输入");
        }
        result = vehicleService.queryVehicle(id);

        return result;


    }

    @RequestMapping(value = "/add")
    public boolean addVehicle(HttpServletRequest request) throws IOException {
        Vehicle result = new Vehicle();
        JSONObject jsonobj = tojson.httptojson(request);
        try {
            result.setBatteryType(jsonobj.getString("batteryType"));
            result.setStatus(jsonobj.getIntValue(("STATUS")));
            result.setTotalMileage(jsonobj.getIntValue(("totalMileage")));

        } catch (Exception e) {
//            //  处理错误的代码块
            System.out.println("非法输入");
        }
        List<Vehicle> temp;
        String vid;
        while (true){
            vid = generateUniqueString();
            temp = vehicleService.queryVehicleByVID(vid);
            if (temp.isEmpty()) break;
        }
        result.setVid(vid);
        return vehicleService.addVehicle(result);
    }


}
