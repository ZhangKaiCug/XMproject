package com.example.FinalProject.service.serviceimpl;

import com.example.FinalProject.entity.Rules;
import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.entity.Warn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    @Autowired
    private VehicleServiceImpl vehicleServiceImpl;

    @Autowired
    private SignalServiceImpl signalServiceImpl;
    @Autowired
    private RulesServiceImpl rulesServiceImpl;
    @Autowired
    private WarnServiceImpl warnServiceImpl;

    // 生成预警信息
    public void generateAlert(Signal signal) {
        int cid = signal.getCid();
        String btype = vehicleServiceImpl.queryVehicle(cid).getBatteryType();
        List<Rules> rules = rulesServiceImpl.getRulesType(btype);
        for (Rules rule : rules) {
            int rid=rule.getRid();
            int temp =-1;
            if (rid==1){
                temp =rule.judge(signal.getMx()- signal.getMi());}
            else if(rid==2){
                temp =rule.judge(signal.getLx()- signal.getLi());

            }


            if (temp !=-1) {
                Warn warn= new Warn();
                warn.setCid(cid);
                warn.setName(rule.getName());
                warn.setType(rule.getType());
                warn.setLevel(temp);
                warnServiceImpl.insertWarn(warn);
            }

        }
    }



}
