package com.example.FinalProject.mappers;

import com.example.FinalProject.entity.Vehicle;
import com.example.FinalProject.entity.VehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleMapper {
    long countByExample(VehicleExample example);

    int deleteByExample(VehicleExample example);

    int deleteByPrimaryKey(Integer vin);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    List<Vehicle> selectByExample(VehicleExample example);

    Vehicle selectByPrimaryKey(Integer vin);

    int updateByExampleSelective(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    int updateByExample(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
}