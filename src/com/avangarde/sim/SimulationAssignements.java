/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.sim;

import java.util.ArrayList;

/**
 *
 * @author zergio
 */
public class SimulationAssignements {

    /**
     * @param args the command line arguments
     */
    public int TIMENOW;//El tiempo instantaneo
    public int NUMSERVERS;// Cantidad de servidores
    public int NUMCUSTOMERS; //Cantidad de Clientes actuales
    public EventList EVENTLIST; //Lista de eventos
    public int LARGETIME = 480; //Hora de cierre de la tierra
    public ArrayList<Server> SERVERS;

    public void main(String[] args) {
        inputData();
        startShop();
        simulate();
        outputResults();
    }

    public void inputData() {

        NUMSERVERS = 1;

        EVENTLIST = new EventList(NUMSERVERS, LARGETIME);

        for (int i = 1; i <= NUMSERVERS; i++) {
            SERVERS.add(new Server());
        }
        
        



    }

    private static void outputResults() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void simulate() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void startShop() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
