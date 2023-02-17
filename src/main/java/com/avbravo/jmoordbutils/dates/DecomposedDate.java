/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbutils.dates;

import com.avbravo.jmoordbutils.DateUtil;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
public class DecomposedDate {
/**
 * Se usa para almacenar una fecha descompuesta
 */
    Integer year;
    Integer day;
    Integer month;
    Integer hour;
    Integer minute;
    String nameOfMonth;

    public DecomposedDate() {
    }

    public DecomposedDate(Integer year, Integer day, Integer month, Integer hour, Integer minute, String nameOfMonth) {
        this.year = year;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
        this.nameOfMonth = nameOfMonth;
    }

    
    
    
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    public void setNameOfMonth(String nameOfMonth) {
        this.nameOfMonth = nameOfMonth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecomposedDate{");
        sb.append("year=").append(year);
        sb.append(", day=").append(day);
        sb.append(", month=").append(month);
        sb.append(", hour=").append(hour);
        sb.append(", minute=").append(minute);
        sb.append(", nameOfMonth=").append(nameOfMonth);
        sb.append('}');
        return sb.toString();
    }

    
    
    public boolean equalsExcludeTime(DecomposedDate other) {
       
      
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.month, other.month)) {
            return false;
        }
     return true;
    }
    
    
    
    

}
