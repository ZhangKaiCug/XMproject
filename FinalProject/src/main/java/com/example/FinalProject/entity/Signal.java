package com.example.FinalProject.entity;

import java.io.Serializable;

/**
 * signal
 * @author 
 */
public class Signal implements Serializable {
    private Integer cid;

    private Double mx;

    private Double mi;

    private Double lx;

    private Double li;

    private static final long serialVersionUID = 1L;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getMx() {
        return mx;
    }

    public void setMx(Double mx) {
        this.mx = mx;
    }

    public Double getMi() {
        return mi;
    }

    public void setMi(Double mi) {
        this.mi = mi;
    }

    public Double getLx() {
        return lx;
    }

    public void setLx(Double lx) {
        this.lx = lx;
    }

    public Double getLi() {
        return li;
    }

    public void setLi(Double li) {
        this.li = li;
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
        Signal other = (Signal) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getMx() == null ? other.getMx() == null : this.getMx().equals(other.getMx()))
            && (this.getMi() == null ? other.getMi() == null : this.getMi().equals(other.getMi()))
            && (this.getLx() == null ? other.getLx() == null : this.getLx().equals(other.getLx()))
            && (this.getLi() == null ? other.getLi() == null : this.getLi().equals(other.getLi()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getMx() == null) ? 0 : getMx().hashCode());
        result = prime * result + ((getMi() == null) ? 0 : getMi().hashCode());
        result = prime * result + ((getLx() == null) ? 0 : getLx().hashCode());
        result = prime * result + ((getLi() == null) ? 0 : getLi().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", mx=").append(mx);
        sb.append(", mi=").append(mi);
        sb.append(", lx=").append(lx);
        sb.append(", li=").append(li);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}