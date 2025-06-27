package com.example.FinalProject.service;


import com.example.FinalProject.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle queryVehicle(int id) ;

    public List<Vehicle> queryVehicleByVID(String vid) ;

    public boolean addVehicle(Vehicle vehicle) ;

    public boolean updateVehicle(Vehicle vehicle) ;

    public boolean deleteVehicle(int id) ;
}
