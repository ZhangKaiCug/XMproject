package com.example.FinalProject.tool;

import com.example.FinalProject.entity.RuleItem;
import com.example.FinalProject.entity.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RefreshCache {
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    public void refeshRules(RuleItem ruleItem){
        Set<String> keys = redisCacheUtil.getkey("rule:id:");

        if (keys != null && !keys.isEmpty()) {
        for (String key : keys) {
            // 从 Redis 获取 Rules 对象
            Rules cachedRules = redisCacheUtil.getCacheObject(key, Rules.class);

            if (cachedRules != null && cachedRules.getRuleItems() != null) {
                // 检查 Rules 对象的 ruleItems 列表中是否包含需要更新的 RuleItem
                boolean updated = false;
                List<RuleItem> updatedRuleItems = new ArrayList<>();
                for (RuleItem existingItem : cachedRules.getRuleItems()) {
                    if (existingItem.getId().equals(ruleItem.getId())) {
                        updatedRuleItems.add(ruleItem); // 替换为更新后的 RuleItem
                        updated = true;
                    } else {
                        updatedRuleItems.add(existingItem);
                    }
                }
                if (updated) {
                    cachedRules.setRuleItems(updatedRuleItems);
                    // 将更新后的 Rules 对象存回 Redis
                    redisCacheUtil.setCacheObject(key, cachedRules, 60, TimeUnit.SECONDS);
                }
            }
        }
    }
}

    public void refeshRules2(int id){
        Set<String> keys = redisCacheUtil.getkey("rule:id:");

        if (keys != null && !keys.isEmpty()) {
            for (String key : keys) {
                // 从 Redis 获取 Rules 对象
                Rules cachedRules = redisCacheUtil.getCacheObject(key, Rules.class);

                if (cachedRules != null && cachedRules.getRuleItems() != null) {
                    // 检查 Rules 对象的 ruleItems 列表中是否包含需要更新的 RuleItem
                    boolean updated = false;
                    List<RuleItem> updatedRuleItems = new ArrayList<>();
                    for (RuleItem existingItem : cachedRules.getRuleItems()) {
                        if (existingItem.getId().equals(id)) {

                            updated = true;
                        } else {
                            updatedRuleItems.add(existingItem);
                        }
                    }
                    if (updated) {
                        cachedRules.setRuleItems(updatedRuleItems);
                        // 将更新后的 Rules 对象存回 Redis
                        redisCacheUtil.setCacheObject(key, cachedRules, 60, TimeUnit.SECONDS);
                    }
                }
            }
        }
    }

}
