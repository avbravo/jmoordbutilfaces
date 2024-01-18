/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbutils.websocket;

import com.avbravo.jmoordbutils.FacesUtil;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.Date;

/**
 *
 * @author avbravo
 * Ejemplo de uso
  MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                    .producer("Dashboard")
                    .action("edit")
                    .key("proyecto")
                    .value("5")
                    .message("se modifico las fechas")
                    .iduser(0L)
                    .date(JmoordbCoreDate.fechaHoraActual())
                    .build();
 * 
 */
public class MessageWebSocket {

    private String producer;

    private String key;
    private String value;

    private String action;

    private String message;

    private Long iduser;
    
    private Date date;

    public MessageWebSocket() {
    }

    public MessageWebSocket(String producer, String key, String value, String action, String message, Long iduser, Date date) {
        this.producer = producer;
        this.key = key;
        this.value = value;
        this.action = action;
        this.message = message;
        this.iduser = iduser;
        this.date = date;
    }

    
    
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "MessageWebSocket{" + "producer=" + producer + ", key=" + key + ", value=" + value + ", action=" + action + ", message=" + message + ", iduser=" + iduser + ", date=" + date + '}';
    }

  
    
    public String toJSON() {
        // Create Jsonb and serialize
        String result = "";
        try {
            Jsonb jsonb = JsonbBuilder.create();
            result = jsonb.toJson(this);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    public MessageWebSocket toMessageWebSocket(String json) {
        MessageWebSocket result = new MessageWebSocket();
        try {
            Jsonb jsonb = JsonbBuilder.create();
         result=   jsonb.fromJson(json, MessageWebSocket.class);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    
   

    public static class Builder {

        private String producer;

        private String key;
String value;
        private String action;

        private String message;

        private Long iduser;
private Date date;
        public Builder iduser(Long iduser) {
            this.iduser = iduser;
            return this;
        }

        public Builder producer(String producer) {
            this.producer = producer;
            return this;
        }
        public Builder date( Date date) {
            this.date = date;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }
        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public MessageWebSocket build() {
            return new MessageWebSocket(producer, key, value, action, message, iduser, date);
        }

    }

}
