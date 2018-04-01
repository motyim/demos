package me.motyim.learn.spring.entitydtocinversion.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 01-Apr-18
 */
@Entity
@Table(name = "city")
public class CityEntity {
    private int id;
    private String cityName;
    private long population;
    private Date holiday;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public Date getHoliday() {
        return holiday;
    }

    public void setHoliday(Date holiday) {
        this.holiday = holiday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id &&
                Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cityName);
    }
}
