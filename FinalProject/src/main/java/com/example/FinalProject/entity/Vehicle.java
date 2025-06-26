package com.example.FinalProject.entity;

import java.io.Serializable;

/**
 * vehicle
 * @author 
 */
public class Vehicle implements Serializable {
    private Integer vin;

    private String vid;

    private String batteryType;

    private Integer totalMileage;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Integer getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Integer totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Vehicle other = (Vehicle) that;
        return (this.getVin() == null ? other.getVin() == null : this.getVin().equals(other.getVin()))
            && (this.getVid() == null ? other.getVid() == null : this.getVid().equals(other.getVid()))
            && (this.getBatteryType() == null ? other.getBatteryType() == null : this.getBatteryType().equals(other.getBatteryType()))
            && (this.getTotalMileage() == null ? other.getTotalMileage() == null : this.getTotalMileage().equals(other.getTotalMileage()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVin() == null) ? 0 : getVin().hashCode());
        result = prime * result + ((getVid() == null) ? 0 : getVid().hashCode());
        result = prime * result + ((getBatteryType() == null) ? 0 : getBatteryType().hashCode());
        result = prime * result + ((getTotalMileage() == null) ? 0 : getTotalMileage().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vin=").append(vin);
        sb.append(", vid=").append(vid);
        sb.append(", batteryType=").append(batteryType);
        sb.append(", totalMileage=").append(totalMileage);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}