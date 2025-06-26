package com.example.FinalProject.mappers;

import com.example.FinalProject.entity.Signal;
import com.example.FinalProject.entity.SignalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignalMapper {
    long countByExample(SignalExample example);

    int deleteByExample(SignalExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Signal record);

    int insertSelective(Signal record);

    List<Signal> selectByExample(SignalExample example);

    Signal selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Signal record, @Param("example") SignalExample example);

    int updateByExample(@Param("record") Signal record, @Param("example") SignalExample example);

    int updateByPrimaryKeySelective(Signal record);

    int updateByPrimaryKey(Signal record);
}