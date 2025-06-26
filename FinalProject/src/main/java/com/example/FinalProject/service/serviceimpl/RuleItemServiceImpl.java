package com.example.FinalProject.service.serviceimpl;

import com.example.FinalProject.entity.RuleItem;
import com.example.FinalProject.entity.RuleItemExample;
import com.example.FinalProject.mappers.RuleItemMapper;
import com.example.FinalProject.service.RuleItemService;
import com.example.FinalProject.tool.RedisCacheUtil;
import com.example.FinalProject.tool.RefreshCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleItemServiceImpl implements RuleItemService {

    @Autowired
    private RuleItemMapper ruleItemMapper;

    @Autowired
    private RedisCacheUtil redisCacheUtil;
    @Autowired
    private RefreshCache refreshCache;

    public RuleItem quryRuleItem(int id){
        return ruleItemMapper.selectByPrimaryKey(id);
    }
    public List<RuleItem> quryRuleItems(int rid){
        RuleItemExample ruleItemExample = new RuleItemExample();
        ruleItemExample.createCriteria().andRidEqualTo(rid);
        return ruleItemMapper.selectByExample(ruleItemExample);
    }
    public boolean addRuleItem(RuleItem ruleItem){
        ruleItemMapper.insert(ruleItem);
        return true;
    }
    public boolean updateRuleItem(RuleItem ruleItem){
        ruleItemMapper.updateByPrimaryKey(ruleItem);
        return true;

    }
    public boolean deleteRuleItem(int id){
        ruleItemMapper.deleteByPrimaryKey(id);
        return true;
    }

    public boolean addRuleItemRedis(RuleItem ruleItem){
        ruleItemMapper.insert(ruleItem);
        refreshCache.refeshRules(ruleItem);
        return true;
    }

    public  boolean updateRuleItemRedis(RuleItem ruleItem){
        ruleItemMapper.updateByPrimaryKey(ruleItem);
        refreshCache.refeshRules(ruleItem);
        return true;

    }

    public boolean deleteRuleItemRedis(int id){
        ruleItemMapper.deleteByPrimaryKey(id);
        refreshCache.refeshRules2(id);
        return true;
    }


}
