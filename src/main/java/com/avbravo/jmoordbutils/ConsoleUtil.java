/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbutils;

//import static com.avbravo.jmoordbutils.FacesUtil.nameOfMethod;
import static com.avbravo.jmoordbutils.FacesUtil.nameOfMethod;

//import static com.diogonunes.jcolor.Ansi.colorize;
//import com.diogonunes.jcolor.AnsiFormat;
//import static com.diogonunes.jcolor.Attribute.BLUE_BACK;
//import static com.diogonunes.jcolor.Attribute.BOLD;
//import static com.diogonunes.jcolor.Attribute.BRIGHT_YELLOW_TEXT;
//import static com.diogonunes.jcolor.Attribute.CYAN_TEXT;
//import static com.diogonunes.jcolor.Attribute.GREEN_BACK;
//import static com.diogonunes.jcolor.Attribute.GREEN_TEXT;
//import static com.diogonunes.jcolor.Attribute.RED_BACK;
//import static com.diogonunes.jcolor.Attribute.YELLOW_TEXT;
/**
 *
 * @author avbravo
 */
public class ConsoleUtil {

    // <editor-fold defaultstate="collapsed" desc="void info(String text)">
    public static void info(String text) {
        try {
//            AnsiFormat fInfo = new AnsiFormat(CYAN_TEXT());
//            System.out.println(fInfo.format(text));
            System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="void test(String text)">
    public static void test(String text) {
        try {
//            AnsiFormat fInfo = new AnsiFormat(CYAN_TEXT());
//            System.out.println(fInfo.format(text));
System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="normal(String text)">
//

    public static void normal(String text) {
        try {

            System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="void error(String text)">

    public static void error(String text) {
        try {
//            AnsiFormat fError = new AnsiFormat(YELLOW_TEXT(), RED_BACK());
//            System.out.println(fError.format(text));
            System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc=" void warning(String text)">
//

    public static void warning(String text) {
        try {
//            AnsiFormat fWarning = new AnsiFormat(GREEN_TEXT(), BLUE_BACK(), BOLD());
//            System.out.println(fWarning.format(text));
            System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc=" void greenBackground(String text)">
//
    public static void greenBackground(String text) {
        try {
//           System.out.print(colorize(text, BOLD(), BRIGHT_YELLOW_TEXT(), GREEN_BACK()));
System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="  void redBackground(String text)">
//
    public static void redBackground(String text) {
        try {
//         System.out.println(colorize(text, BOLD(), BRIGHT_YELLOW_TEXT(), RED_BACK()));
            System.out.println(text);
        } catch (Exception e) {
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
    }
//// </editor-fold>
}
