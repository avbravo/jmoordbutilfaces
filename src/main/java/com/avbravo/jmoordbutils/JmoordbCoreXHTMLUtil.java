/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.jmoordbutils;

import java.util.Date;

/**
 *
 * @author avbravo
 */
public interface JmoordbCoreXHTMLUtil {
    // <editor-fold defaultstate="collapsed" desc="String cutTextObservacio(Boletas boletas,Integer largo)">

    default public String cutText(String text, Integer largo) {

        try {

            if (text.length() > largo) {
                text = text.substring(0, largo);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + " " + e.getLocalizedMessage());
        }

        return text;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showDate(Date date,String...format)">
    default public String showDate(Date date, String... format) {
        String h = "";
        try {
            String dateFormat = "dd/MM/yyyy";
            if (format.length != 0) {
                dateFormat = format[0];

            }
            h = DateUtil.dateFormatToString(date, dateFormat);
        } catch (Exception e) {
            System.out.println("showDate() " + e.getLocalizedMessage());
        }
        return h;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showHour(Date dateS,tring...format)">
    default public String showHour(Date date, String... format) {
        String h = "";
        try {
            String hourFormat = "hh:mm a";
            if (format.length != 0) {
                hourFormat = format[0];

            }
            h = DateUtil.hourFromDateToString(date, hourFormat);
        } catch (Exception e) {
            System.out.println("showHour() " + e.getLocalizedMessage());
        }
        return h;
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="String showDateWithHour(Date date, String dateFormat, String hourFormat)">
    default public String showDateWithHour(Date date, String dateFormat, String hourFormat) {
        String result = "";
        try {
            var d = "";
            var h = "";
            var temporalDateFormat = "dd/MM/yyyy";
            if (dateFormat == null || dateFormat.equals("")) {
            } else {
                temporalDateFormat = dateFormat;
            }

            var temporalHourFormat = "hh:mm a";
            if (hourFormat == null || hourFormat.equals("")) {

            } else {
                temporalHourFormat = hourFormat;
            }
            d = DateUtil.dateFormatToString(date, temporalDateFormat);
            h = DateUtil.hourFromDateToString(date, temporalHourFormat);
            result = d+ " "+h;
        } catch (Exception e) {
            System.out.println("showDateWithHour() " + e.getLocalizedMessage());
        }
        return result;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String showDateWithHour(Date date)">
    default public String showDateWithHour(Date date) {
        String result = "";
        try {
            var d = "";
            var h = "";
            var temporalDateFormat = "dd/MM/yyyy";
           

            var temporalHourFormat = "hh:mm a";
            
            d = DateUtil.dateFormatToString(date, temporalDateFormat);
            h = DateUtil.hourFromDateToString(date, temporalHourFormat);
            result = d+ " "+h;
        } catch (Exception e) {
            System.out.println("showDateWithHour() " + e.getLocalizedMessage());
        }
        return result;
    }// </editor-fold>
}
