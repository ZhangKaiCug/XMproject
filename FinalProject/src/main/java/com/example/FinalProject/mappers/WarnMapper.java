package com.example.FinalProject.mappers;

import com.example.FinalProject.entity.Warn;
import com.example.FinalProject.entity.WarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarnMapper {
    long countByExample(WarnExample example);

    int deleteByExample(WarnExample example);

    int insert(Warn record);

    int insertSelective(Warn record);

    List<Warn> selectByExample(WarnExample example);

    int updateByExampleSelective(@Param("record") Warn record, @Param("example") WarnExample example);

    int updateByExample(@Param("record") Warn record, @Param("example") WarnExample example);
}