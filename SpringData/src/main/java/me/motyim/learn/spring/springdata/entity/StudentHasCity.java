/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.motyim.learn.spring.springdata.entity;

import me.motyim.learn.spring.springdata.entity.City;
import me.motyim.learn.spring.springdata.entity.Student;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 25, 2018 
 */
@Entity
@Table(name = "student_has_city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentHasCity.findAll", query = "SELECT s FROM StudentHasCity s")
    , @NamedQuery(name = "StudentHasCity.findByStudentid", query = "SELECT s FROM StudentHasCity s WHERE s.studentHasCityPK.studentid = :studentid")
    , @NamedQuery(name = "StudentHasCity.findByCityId", query = "SELECT s FROM StudentHasCity s WHERE s.studentHasCityPK.cityId = :cityId")
    , @NamedQuery(name = "StudentHasCity.findByNumberOfBuses", query = "SELECT s FROM StudentHasCity s WHERE s.numberOfBuses = :numberOfBuses")})
public class StudentHasCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentHasCityPK studentHasCityPK;
    @Column(name = "number_of_buses")
    private String numberOfBuses;
    @JoinColumn(name = "Student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private City city;

    public StudentHasCity() {
    }

    public StudentHasCity(StudentHasCityPK studentHasCityPK) {
        this.studentHasCityPK = studentHasCityPK;
    }

    public StudentHasCity(int studentid, int cityId) {
        this.studentHasCityPK = new StudentHasCityPK(studentid, cityId);
    }

    public StudentHasCityPK getStudentHasCityPK() {
        return studentHasCityPK;
    }

    public void setStudentHasCityPK(StudentHasCityPK studentHasCityPK) {
        this.studentHasCityPK = studentHasCityPK;
    }

    public String getNumberOfBuses() {
        return numberOfBuses;
    }

    public void setNumberOfBuses(String numberOfBuses) {
        this.numberOfBuses = numberOfBuses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentHasCityPK != null ? studentHasCityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentHasCity)) {
            return false;
        }
        StudentHasCity other = (StudentHasCity) object;
        if ((this.studentHasCityPK == null && other.studentHasCityPK != null) || (this.studentHasCityPK != null && !this.studentHasCityPK.equals(other.studentHasCityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ".StudentHasCityRepository[ studentHasCityPK=" + studentHasCityPK + " ]";
    }

}
