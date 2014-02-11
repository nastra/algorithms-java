package com.nastra.systemdesign.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author nastra
 */
public class CallHandler {

    private static CallHandler instance;
    private static final int NUM_RESPONDENTS = 10;
    private static final int NUM_MANAGERS = 4;
    private static final int NUM_DIRECTORS = 2;
    private static List<Employee> respondents = new ArrayList<Employee>();
    private static List<Employee> managers = new ArrayList<Employee>();
    private static List<Employee> directors = new ArrayList<Employee>();
    private static List<Employee>[] levels = new List[3];
    private static Queue<Call> calls = new LinkedList<Call>();

    private CallHandler() {
        levels[0] = respondents;
        levels[1] = managers;
        levels[2] = directors;
    }

    public static CallHandler getInstance() {
        if (null == instance) {
            instance = new CallHandler();
        }
        return instance;
    }

    public static void call(Caller caller) {
        Call call = new Call();
        call.setCaller(caller);
        dispatchCall(call);
    }

    /**
     * we need to find the next possible call handler and assign the call to that person.
     * 
     * @param call
     */
    private static void dispatchCall(Call call) {
        for (int i = 0; i < levels.length; i++) {
            for (Employee e : levels[i]) {
                if (e.isAvailable() && e.canHandleCall(call)) {
                    e.assignCall(call);
                }
            }
        }
        if (!call.isAssigned()) {
            call.setReply("Please hold the line");
            calls.add(call);
        }
    }
}
