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
    default public String showDate(Date date,String...format) {
        String h = "";
        try {
  String dateFormat ="dd/MM/yyyy";
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
    default public String showHour(Date date,String...format) {
        String h = "";
        try {
              String hourFormat ="hh:mm a";
            if (format.length != 0) {
               hourFormat = format[0];

            }
            h = DateUtil.hourFromDateToString(date,hourFormat);
        } catch (Exception e) {
            System.out.println("showHour() " + e.getLocalizedMessage());
        }
        return h;
    }// </editor-fold>
}
