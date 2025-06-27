package com.example.FinalProject.service.serviceimpl;

import com.example.FinalProject.entity.Vehicle;
import com.example.FinalProject.entity.VehicleExample;
import com.example.FinalProject.mappers.VehicleMapper;
import com.example.FinalProject.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl  implements VehicleService {

    @Autowired
    private VehicleMapper mapper;

    @Override
    public Vehicle queryVehicle(int id) {
        return mapper.selectByPrimaryKey(id);
    }
    public List<Vehicle> queryVehicleByVID(String vid) {
        VehicleExample example = new VehicleExample();
        example.createCriteria().andVidEqualTo(vid);
        return mapper.selectByExample(example);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {

        mapper.insert(vehicle);
        return true;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle){
        mapper.updateByPrimaryKey(vehicle);
        return true;
    }

    @Override
    public boolean deleteVehicle(int id){
        mapper.deleteByPrimaryKey(id);
        return true;
    }

    public List<Vehicle> getAllVehicles() {
        // 创建一个未设置任何条件的 VehicleExample 对象
        VehicleExample example = new VehicleExample();
        // 查询表内所有数据
        return mapper.selectByExample(example);
    }
}
