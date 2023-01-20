/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbutils;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @authoravbravo
 */
@Named
@SessionScoped
public class JmoordbResourcesFiles implements Serializable {

    private static final long serialVersionUID = 1L;
    Locale currentLocale;
    ResourceBundle mrb; //for messages atributos
    ResourceBundle crb; //for application
    ResourceBundle corerb; //for core
    String pathMessagesProperties = "com.properties.messages";
    String pathConfigurationProperties = "com.properties.configuration";

    public JmoordbResourcesFiles() {
    }

    @PostConstruct
    public void init() {
        saveLocale();
    }

    public void saveLocale() {
        currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        mrb = ResourceBundle.getBundle(pathMessagesProperties, currentLocale);
        crb = ResourceBundle.getBundle(pathConfigurationProperties, currentLocale);
        corerb = ResourceBundle.getBundle("com.jmoordbutilfaces.properties.core", currentLocale);
    }

  

    public String getPathMessagesProperties() {
        return pathMessagesProperties;
    }

    public void setPathMessagesProperties(String pathMessagesProperties) {
        this.pathMessagesProperties = pathMessagesProperties;
    }

    public ResourceBundle getCrb() {
        return crb;
    }

    public void setCrb(ResourceBundle crb) {
        this.crb = crb;
    }

    public String getPathConfigurationProperties() {
        return pathConfigurationProperties;
    }

    public void setPathConfigurationProperties(String pathConfigurationProperties) {
        this.pathConfigurationProperties = pathConfigurationProperties;
    }

  

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    
      public ResourceBundle getCorerb() {
        return corerb;
    }

    public void setCorerb(ResourceBundle corerb) {
        this.corerb = corerb;
    }
    public ResourceBundle getMrb() {
        return mrb;
    }

    public void setMrb(ResourceBundle mrb) {
        this.mrb = mrb;
    }

  

    /*
     *Devuelve el mensaje Mrb
     */
    public String fromMessage(String mensaje) {
        return mrb.getString(mensaje);
    }

    /*
     *Devuelve el mensaje Arb
     */
    public String fromConfiguration(String mensaje) {
        return crb.getString(mensaje);
    }
    /*
     *Devuelve el mensaje Arb
     */
    public String fromCore(String mensaje) {
        return corerb.getString(mensaje);
    }

}
