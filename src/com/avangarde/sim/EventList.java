/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.sim;

import java.util.ArrayList;

/**
 *
 * @author Zergio
 */
public class EventList {

    int numServers;
    ArrayList<Integer> finishTime = new ArrayList<Integer>(); //tiempo de finalizacion

    int nextEventTime(int server) {
        return finishTime.get(server);
    }

    void setFinishTime(int server, int time) {
        finishTime.add(server, time);
    }

    int nextEventServer() {
        int p = 0;
        int t = finishTime.get(0);
        for (int i = 1; i < numServers; i++) {
            if (finishTime.get(i) < t) {
                p = i;
                t = finishTime.get(i);
            }
        }
        return p;
    }

    public EventList(int theNumServers, int largeTime) {

        if (theNumServers < 1) {
            System.out.println("Error");
        }

        this.numServers = theNumServers;
        for (int i = 1; i <= numServers; i++) {
            finishTime.add(largeTime);
            
        }
    }
}
