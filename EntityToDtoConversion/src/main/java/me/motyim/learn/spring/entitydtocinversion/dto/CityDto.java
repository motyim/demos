package me.motyim.learn.spring.entitydtocinversion.dto;

import java.util.Date;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 31-Mar-18
 */
public class CityDto{
    private int id;
    private String cityName;
    private long population;
    private Date holiday;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
