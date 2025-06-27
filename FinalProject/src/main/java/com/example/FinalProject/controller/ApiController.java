package com.example.FinalProject.controller;


import com.example.FinalProject.entity.*;
import com.example.FinalProject.service.serviceimpl.RulesServiceImpl;
import com.example.FinalProject.service.serviceimpl.VehicleServiceImpl;
import com.example.FinalProject.service.serviceimpl.WarnServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private WarnServiceImpl warnServiceImpl;
    @Autowired
    private RulesServiceImpl rulesServiceImpl;
    @Autowired
    private VehicleServiceImpl vehicleServiceImpl;
    @PostMapping(value = "/warn")
    public ResponseEntity<List<WarnRequest>> apiwarn(@RequestBody List<SignalRequest> signalRequests) {
        List<WarnRequest> warns = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        // 从数组中获取单个请求
        for (SignalRequest request : signalRequests) {
            Signal signal = new Signal();
            List<Rules> rules;
            // 获取车辆信息
            signal.setCid(request.getCarId());
            int cid= request.getCarId();
            // 电池信息
            String btype = vehicleServiceImpl.queryVehicle(cid).getBatteryType();
            if (request.getWarnId() != null){
                rules = rulesServiceImpl.findRulesByTypeAndRid(btype, request.getWarnId());
            }
            else {
                rules = rulesServiceImpl.getRulesType(btype);
            }
            try {
                // 解析 signal 字符串为 JSON 对象
                Map<String, Object> signalMap = objectMapper.readValue(request.getSignal(), Map.class);
                // 设置 mx
                if (signalMap.get("Mx") != null) {
                    signal.setMx((Double) signalMap.get("Mx"));
                }
                // 设置 mi
                if (signalMap.get("Mi") != null) {
                    signal.setMi((Double) signalMap.get("Mi"));
                }
                // 设置 lx（将 Ix 映射到 lx）
                if (signalMap.get("Ix") != null) {
                    signal.setLx((Double) signalMap.get("Ix"));
                }
                // 设置 li（将 Ii 映射到 li）
                if (signalMap.get("Ii") != null) {
                    signal.setLi((Double) signalMap.get("Ii"));
                }

                for (Rules rule : rules) {
                    int rid=rule.getRid();
                    int temp =-1;
                    if (rid==1){
                        temp =rule.judge(signal.getMx()- signal.getMi());}
                    else if(rid==2){
                        temp =rule.judge(signal.getLx()- signal.getLi());

                    }
                        WarnRequest warn= new WarnRequest();
                        warn.setCid(request.getCarId());
                        warn.setName(rule.getName());
                        warn.setType(rule.getType());

                    if (temp !=-1) {
                        warn.setLevel(String.valueOf(temp));
                    }
                    else {
                        warn.setLevel("不报警");
                    }
                    warns.add(warn);
                }

            } catch (IOException e) {
                // 处理 JSON 解析异常
                return ResponseEntity.badRequest().body(null);
            }
        }
        return ResponseEntity.ok(warns);
    }

}
