package com.example.FinalProject.tool;

import com.example.FinalProject.entity.Rules;
import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.entity.Warn;
import com.example.FinalProject.service.serviceimpl.*;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RocketMQMessageListener(topic = "signal-topic", consumerGroup = "default-consumer-group")
public class RocketMQConsumer implements RocketMQListener<Signal> {


    @Autowired
    private AlertService alertService;

    @Override
    public void onMessage(Signal signal) {
        // 生成预警信息
         alertService.generateAlert(signal);
    }
}
