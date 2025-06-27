package com.example.FinalProject.mappers;

import com.example.FinalProject.entity.RuleItem;
import com.example.FinalProject.entity.RuleItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleItemMapper {
    long countByExample(RuleItemExample example);

    int deleteByExample(RuleItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RuleItem record);

    int insertSelective(RuleItem record);

    List<RuleItem> selectByExample(RuleItemExample example);

    RuleItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RuleItem record, @Param("example") RuleItemExample example);

    int updateByExample(@Param("record") RuleItem record, @Param("example") RuleItemExample example);

    int updateByPrimaryKeySelective(RuleItem record);

    int updateByPrimaryKey(RuleItem record);
}