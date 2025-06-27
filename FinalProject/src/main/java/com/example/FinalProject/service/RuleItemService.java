package com.example.FinalProject.service;

import com.example.FinalProject.entity.RuleItem;

import java.util.List;

public interface RuleItemService {
    public RuleItem quryRuleItem(int id);
    public List<RuleItem> quryRuleItems(int rid);
    public boolean addRuleItem(RuleItem ruleItem);
    public boolean updateRuleItem(RuleItem ruleItem);
    public boolean deleteRuleItem(int id);
}
