package com.example.FinalProject.service.serviceimpl;

import com.example.FinalProject.entity.Warn;
import com.example.FinalProject.entity.WarnExample;
import com.example.FinalProject.mappers.WarnMapper;
import com.example.FinalProject.service.WarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarnServiceImpl implements WarnService {
    @Autowired
    private WarnMapper warnMapper;

    public List<Warn> queryWarn(int id){
        WarnExample example = new WarnExample();
        example.createCriteria().andCidEqualTo(id);
        return warnMapper.selectByExample(example);
    }
    public boolean insertWarn(Warn warn){
        warnMapper.insert(warn);
        return true;
    }
}
