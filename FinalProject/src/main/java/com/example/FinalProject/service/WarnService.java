package com.example.FinalProject.service;

import com.example.FinalProject.entity.Warn;

import java.util.List;

public interface WarnService {
    public List<Warn> queryWarn(int id);
    public boolean insertWarn(Warn warn);
}
