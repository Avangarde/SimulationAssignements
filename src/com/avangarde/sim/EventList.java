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
    ArrayList<Double> finishTime = new ArrayList<Double>(); //tiempo de finalizacion

    double nextEventTime(int server) {
        return finishTime.get(server);
    }

    void setFinishTime(int server, double time) {
        finishTime.add(server, time);
    }

    int nextEventServer() {
        int p = 0;
        double t = finishTime.get(0);
        for (int i = 1; i < numServers; i++) {
            if (finishTime.get(i) < t) {
                p = i;
                t = finishTime.get(i);
            }
        }
        return p;
    }

    public EventList(int theNumServers, double largeTime) {

        if (theNumServers < 1) {
            System.out.println("Error");
        }

        this.numServers = theNumServers;
        for (int i = 1; i <= numServers; i++) {
            finishTime.add(largeTime);

        }
    }
}
