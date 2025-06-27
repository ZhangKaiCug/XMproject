package com.example.FinalProject.service;

import com.example.FinalProject.entity.Signal;

public interface SignalService {

    public Signal querySignal(int id);

    public boolean updateSignal(Signal signal);
    public boolean insertSignal(Signal signal);
    public boolean deleteSignal(int id);
    public Signal getBatterySignalByCid(Integer cid);
    public boolean updateBatterySignal(Signal newSignal);
}
