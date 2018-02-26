/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.motyim.learn.spring.springdata.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 25, 2018 
 */
@Embeddable
public class StudentHasCityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Student_id")
    private int studentid;
    @Basic(optional = false)
    @Column(name = "city_id")
    private int cityId;

    public StudentHasCityPK() {
    }

    public StudentHasCityPK(int studentid, int cityId) {
        this.studentid = studentid;
        this.cityId = cityId;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentid;
        hash += (int) cityId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentHasCityPK)) {
            return false;
        }
        StudentHasCityPK other = (StudentHasCityPK) object;
        if (this.studentid != other.studentid) {
            return false;
        }
        if (this.cityId != other.cityId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ".StudentHasCityPK[ studentid=" + studentid + ", cityId=" + cityId + " ]";
    }

}
