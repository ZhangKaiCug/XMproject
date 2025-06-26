package com.example.FinalProject.service;

import com.example.FinalProject.entity.Rules;

public interface RulesService {
    public Rules queryRules(int id) ;

    public boolean updateRules(Rules rules);

    public boolean insertRules(Rules rules);

    public boolean deleteRules(int id);



}
