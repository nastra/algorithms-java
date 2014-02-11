package com.nastra.systemdesign.callcenter;

/**
 * 
 * @author nastra
 */
public class Call {

    private Caller caller;
    private Employee handler;
    private String reply;

    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public Employee getHandler() {
        return handler;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public boolean isAssigned() {
        return null != handler;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
