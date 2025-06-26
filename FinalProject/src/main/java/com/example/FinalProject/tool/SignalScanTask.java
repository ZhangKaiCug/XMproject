package com.example.FinalProject.tool;

import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.entity.SignalRequest;
import com.example.FinalProject.entity.Vehicle;
import com.example.FinalProject.entity.VehicleExample;
import com.example.FinalProject.mappers.SignalMapper;
import com.example.FinalProject.mappers.VehicleMapper;
import com.example.FinalProject.service.VehicleService;
import com.example.FinalProject.service.serviceimpl.SignalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.apache.rocketmq.spring.core.RocketMQTemplate;

import java.util.List;

@Component
public class SignalScanTask {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private SignalServiceImpl signalService;
    // 每隔60秒执行一次定时任务
    @Scheduled(fixedRate = 60000)
    public void scanSignals() {
        // 查询电池信号数据
        VehicleExample example = new VehicleExample();
        List<Vehicle> vehicles = vehicleMapper.selectByExample(example);

        for (Vehicle vehicle : vehicles) {
            // 构建 Signal 对象
            Signal signal = signalService.getBatterySignalByCid(vehicle.getVin());



            // 发送信号数据到 RocketMQ
            rocketMQTemplate.convertAndSend("signal-topic", signal);
//            rocketMQTemplate.sendOneWay("signal-topic", signal);

        }
    }
}