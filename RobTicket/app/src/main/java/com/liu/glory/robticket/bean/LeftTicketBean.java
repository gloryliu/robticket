package com.liu.glory.robticket.bean;

import java.util.List;

/**
 * Created by liu.zhenrong on 2017/2/28.
 */

public class LeftTicketBean {
    private String validateMessagesShowId;
    private boolean status;
    private int httpstatus;
    private Object validateMessages;
    private Object messages;
    private List<QueryLeftNewDTO> data;

    public List<QueryLeftNewDTO> getData() {
        return data;
    }

    public void setData(List<QueryLeftNewDTO> data) {
        this.data = data;
    }

    public int getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(int httpstatus) {
        this.httpstatus = httpstatus;
    }

    public Object getMessages() {
        return messages;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getValidateMessages() {
        return validateMessages;
    }

    public void setValidateMessages(Object validateMessages) {
        this.validateMessages = validateMessages;
    }

    public String getValidateMessagesShowId() {
        return validateMessagesShowId;
    }

    public void setValidateMessagesShowId(String validateMessagesShowId) {
        this.validateMessagesShowId = validateMessagesShowId;
    }
}
