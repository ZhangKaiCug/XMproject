package com.example.FinalProject.mappers;

import com.example.FinalProject.entity.Rules;
import com.example.FinalProject.entity.RulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RulesMapper {
    long countByExample(RulesExample example);

    int deleteByExample(RulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rules record);

    int insertSelective(Rules record);

    List<Rules> selectByExample(RulesExample example);

    Rules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rules record, @Param("example") RulesExample example);

    int updateByExample(@Param("record") Rules record, @Param("example") RulesExample example);

    int updateByPrimaryKeySelective(Rules record);

    int updateByPrimaryKey(Rules record);
}