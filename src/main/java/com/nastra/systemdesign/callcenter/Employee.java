package com.nastra.systemdesign.callcenter;

/**
 * 
 * @author nastra
 */
public class Employee {

    private Call currentCall;

    public boolean isAvailable() {
        return null == currentCall;
    }

    public boolean canHandleCall(Call call) {
        // some logic goes here
        return false;
    }

    public void assignCall(Call call) {
        this.currentCall = call;
        call.setHandler(this);
    }
}
