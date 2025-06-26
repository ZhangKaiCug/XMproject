package com.example.FinalProject.service.serviceimpl;

import com.example.FinalProject.entity.RuleItemExample;
import com.example.FinalProject.entity.Rules;
import com.example.FinalProject.entity.RulesExample;
import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.mappers.RuleItemMapper;
import com.example.FinalProject.mappers.RulesMapper;
import com.example.FinalProject.mappers.VehicleMapper;
import com.example.FinalProject.service.RulesService;
import com.example.FinalProject.tool.RedisCacheUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RulesServiceImpl implements RulesService {

    private static final String CACHE_KEY_PREFIX = "rule:id:";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RulesMapper rulesMapper;

    @Autowired
    private RuleItemMapper ruleItemMapper;

    @Autowired
    private RedisCacheUtil redisCacheUtil;



    @Override
    public Rules queryRules(int id) {
        return rulesMapper.selectByPrimaryKey(id);
    }



    @Override
    public boolean updateRules(Rules rules){
        rulesMapper.updateByPrimaryKeySelective(rules);
        return true;
    }

    @Override
    public boolean insertRules(Rules rules){
        rulesMapper.insertSelective(rules);
        return true;
    }

    @Override
    public boolean deleteRules(int id){
        rulesMapper.deleteByPrimaryKey(id);
        return true;
    }

    public Rules getRules(Integer id) {
        // 从 Redis 缓存中获取电池信号状态对象

        String cacheKey = CACHE_KEY_PREFIX + id;
        Rules cachedRules = redisCacheUtil.getCacheObject(cacheKey, Rules.class);

        if (cachedRules != null) {
            // 缓存存在，直接返回缓存值
            return cachedRules;
        } else {
            // 缓存不存在，从数据库中查询
            Rules rules = rulesMapper.selectByPrimaryKey(id);

            if (rules != null) {
                RuleItemExample ruleItemExample = new RuleItemExample();
                ruleItemExample.createCriteria().andRidEqualTo(rules.getId());
                // 将查询结果存入 Redis 缓存，设置过期时间（例如 60 秒）
                rules.setRuleItems(ruleItemMapper.selectByExample(ruleItemExample));
                redisCacheUtil.setCacheObject(cacheKey, rules, 60, TimeUnit.SECONDS);
                return rules;
            } else {
                // 未查询到电池信号状态
                return null;
            }
        }
    }

    public List<Rules> getRulesType(String type) {
        // 从 Redis 缓存中获取电池信号状态对象
        RulesExample ruleExample = new RulesExample();
        ruleExample.createCriteria().andTypeEqualTo(type);
        List<Rules> rulesList=rulesMapper.selectByExample(ruleExample);
        if (rulesList != null) {
            for (Rules rules : rulesList) {
                String cacheKey = CACHE_KEY_PREFIX + rules.getId();
                RuleItemExample ruleItemExample = new RuleItemExample();
                ruleItemExample.createCriteria().andRidEqualTo(rules.getId());
                // 将查询结果存入 Redis 缓存，设置过期时间（例如 60 秒）
                rules.setRuleItems(ruleItemMapper.selectByExample(ruleItemExample));
                Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
                stringRedisTemplate.opsForValue().set(cacheKey, gson.toJson( rules));

                // 更新索引结构
                String indexKey = String.format("rules:index:type:%s:rid:%s", rules.getType(), rules.getRid());
                stringRedisTemplate.opsForSet().add(indexKey, cacheKey);
            }

        } else {
            // 未查询到电池信号状态
            return null;
        }


        return rulesList;
    }



    public boolean updateRulesRedis(Rules newRules) {
        String cacheKey = CACHE_KEY_PREFIX + newRules.getId();

        // 更新数据库中的电池信号状态
        int updateCount = rulesMapper.updateByPrimaryKey(newRules);
        if (updateCount > 0) {
            // 更新 Redis 缓存中的电池信号状态
//            redisCacheUtil.setCacheObject(cacheKey, newRules, 60, TimeUnit.SECONDS);
            Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
            stringRedisTemplate.opsForValue().set(cacheKey, gson.toJson(newRules));

            // 更新索引结构
            String indexKey = String.format("rules:index:type:%s:rid:%s", newRules.getType(), newRules.getRid());
            stringRedisTemplate.opsForSet().add(indexKey, cacheKey);
            return true;
        } else {
            return false;
        }
    }
    public List<Rules> findRulesByTypeAndRid(String type, int rid) {
        List<Rules> rulesList = new ArrayList<>();
        String indexKey = String.format("rules:index:type:%s:rid:%s", type,rid);

        // 获取所有匹配的缓存键
        Set<String> cacheKeys = stringRedisTemplate.opsForSet().members(indexKey);

        if (cacheKeys != null && !cacheKeys.isEmpty()) {
            for (String cacheKey : cacheKeys) {
                // 从 Redis 获取 Rules 对象
                String rulesJson = stringRedisTemplate.opsForValue().get(cacheKey);
                if (rulesJson != null) {
                    Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
                    Rules rules = gson .fromJson(rulesJson, Rules.class);
                    rulesList.add(rules);
                }
            }
        }
        else {
            RulesExample ruleExample = new RulesExample();
            ruleExample.createCriteria().andTypeEqualTo(type).andRidEqualTo(rid);
            rulesList=rulesMapper.selectByExample(ruleExample);

                if (rulesList != null) {
                    for (Rules rules : rulesList) {
                        String cacheKey = CACHE_KEY_PREFIX + rules.getId();
                        RuleItemExample ruleItemExample = new RuleItemExample();
                        ruleItemExample.createCriteria().andRidEqualTo(rules.getId());
                        // 将查询结果存入 Redis 缓存，设置过期时间（例如 60 秒）
                        rules.setRuleItems(ruleItemMapper.selectByExample(ruleItemExample));
                        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
                        stringRedisTemplate.opsForValue().set(cacheKey, gson.toJson( rules));

                        // 更新索引结构
                        indexKey = String.format("rules:index:type:%s:rid:%s", rules.getType(), rules.getRid());
                        stringRedisTemplate.opsForSet().add(indexKey, cacheKey);
                    }

            } else {
                // 未查询到电池信号状态
                return null;
            }
        }

        return rulesList;
    }
}
