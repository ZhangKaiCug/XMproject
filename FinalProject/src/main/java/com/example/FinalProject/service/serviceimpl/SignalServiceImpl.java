package com.example.FinalProject.service.serviceimpl;

import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.mappers.SignalMapper;
import com.example.FinalProject.service.SignalService;
import com.example.FinalProject.tool.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SignalServiceImpl implements SignalService {

    private static final String CACHE_KEY_PREFIX = "signal:cid:";

    @Autowired
    private SignalMapper signalMapper;

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    public Signal querySignal(int id){
        return signalMapper.selectByPrimaryKey(id);
    }

    public boolean updateSignal(Signal signal){
        signalMapper.updateByPrimaryKeySelective(signal);
        return true;
    }
    public boolean insertSignal(Signal signal){
        String cacheKey = CACHE_KEY_PREFIX + signal.getCid();

        // 更新数据库中的电池信号状态
        int updateCount = signalMapper.insert(signal);
        if (updateCount > 0) {
            // 更新 Redis 缓存中的电池信号状态
            redisCacheUtil.setCacheObject(cacheKey, signal, 60, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteSignal(int id){
        String cacheKey = CACHE_KEY_PREFIX + id;
        redisCacheUtil.deleteCache(cacheKey);
        int deleteCount = signalMapper.deleteByPrimaryKey(id);
        return deleteCount > 0;
    }

    public Signal getBatterySignalByCid(Integer cid) {
        // 从 Redis 缓存中获取电池信号状态对象
        String cacheKey = CACHE_KEY_PREFIX + cid;
        Signal cachedSignal = redisCacheUtil.getCacheObject(cacheKey, Signal.class);

        if (cachedSignal != null) {
            // 缓存存在，直接返回缓存值
            return cachedSignal;
        } else {
            // 缓存不存在，从数据库中查询
            Signal signal = signalMapper.selectByPrimaryKey(cid);

            if (signal != null) {
                // 将查询结果存入 Redis 缓存，设置过期时间（例如 60 秒）
                redisCacheUtil.setCacheObject(cacheKey, signal, 60, TimeUnit.SECONDS);
                return signal;
            } else {
                // 未查询到电池信号状态
                return null;
            }
        }
    }

    public boolean updateBatterySignal(Signal newSignal) {
        String cacheKey = CACHE_KEY_PREFIX + newSignal.getCid();

        // 更新数据库中的电池信号状态
        int updateCount = signalMapper.updateByPrimaryKey(newSignal);
        if (updateCount > 0) {
            // 更新 Redis 缓存中的电池信号状态
            redisCacheUtil.setCacheObject(cacheKey, newSignal, 60, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }
}
