/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.sim;

import java.util.ArrayList;

/**
 *
 * Un almacén vende dos tipos de prenda: A y B. El tiempo entre llegadas es de 3
 * min/cliente con distribución exponencial. El almacén emplea un solo empleado.
 * El 20% de los clientes no compra y utiliza al empleado durante 1.5 minutos.
 * El 50% compra la prenda A y el almacén obtiene una utilidad de $ 2500/camisa,
 * el tiempo que toma realizar la transacción sigue una distribución uniforme
 * entre 3.1 y 3.8 min. El 30% restante que entra a la tienda compra la prenda B
 * y obtiene una utilidad de $ 4500, el tiempo para realizar la transacción
 * sigue una distribución exponencial con media de 7 min. El almacén abre sus
 * puertas 8 horas diarias y es su política atender a todos sus clientes que se
 * encuentren dentro del almacén al cerrar. Simule las actividades diarias y
 * obtenga: a. La hora en que el empleado se va a su casa b. ¿Cuál es el valor
 * estimado de las utilidades diarias? c. ¿Cuál es el tiempo promedio que un
 * cliente tiene que esperar para ser atendido? d. ¿Qué pasa si el tiempo entre
 * llegadas es de 1.5 min/cliente? e. ¿Cuántos empleados debe tener el almacén
 * si el propietario desea que no haya más de dos clientes esperando ser
 * atendidos? "	*
 *
 * *
 * @author zergio
 */
public class SimulationAssignements {

    /**
     * @param args the command line arguments
     */
    public double TIMENOW = 0;//El tiempo instantaneo
    public int NUMSERVERS;// Cantidad de servidores
    public int NUMCUSTOMERS; //Cantidad de Clientes actuales
    public EventList EVENTLIST; //Lista de eventos
    public double LARGETIME = 480; //Hora de cierre de la tierra
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

    private void outputResults() {
        System.out.println("TIEMPO DE FINALIZACION: " + TIMENOW);
        for (Server each : SERVERS) {
            System.out.println("Un Servidor completo" + each.numCustomers
                    + " servicios, con una ganancia de " + each.totalRevenue
                    + " y un tiempo de espera total de " + each.totalWaits);
        }
    }

    public void simulate() {

        while (LARGETIME > TIMENOW && !SERVERS.isEmpty()) {
            int nextToFinish = EVENTLIST.nextEventServer();
            TIMENOW = EVENTLIST.nextEventTime(nextToFinish);

            Customer customer = changeState(nextToFinish);
        }

    }

    public void startShop() {
        //Carga de los primeros clientes dentro  de la maquina
        for (int p = 1; p <= NUMSERVERS; p++) {
            changeState(p);
        }
    }

    public Customer changeState(int p) {

        Customer lastCustomer;

        if (SERVERS.get(p).getActiveCustomer() == null) {
            lastCustomer = null;
            if (SERVERS.get(p).getCustomers().peek() == null)//No hay nada en la cola de clientes
            {
                EVENTLIST.setFinishTime(p, LARGETIME);
            } else {
                SERVERS.get(p).activeCustomer = SERVERS.get(p).customers.poll();
                SERVERS.get(p).totalWaits += TIMENOW - SERVERS.get(p).activeCustomer.getArrivalTime();
                SERVERS.get(p).totalRevenue += SERVERS.get(p).activeCustomer.getRevenue();
                SERVERS.get(p).numCustomers++;
                EVENTLIST.setFinishTime(p, TIMENOW + SERVERS.get(p).activeCustomer.getLength());
            }
        } else {
            lastCustomer = SERVERS.get(p).activeCustomer;
            SERVERS.get(p).activeCustomer = null;
        }
        return lastCustomer;
    }
}
