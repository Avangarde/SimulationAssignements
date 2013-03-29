/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.sim;

/**
 *Cliente
 * 
 * @author Zergio
 */
public class Customer {

    private int lenght; //tiempo de trabajo
    private int revenue; //dinero que gana la tienda por atenderlo
    private int id; //id del cliente
    private int arrivalTime;//tiempo de llegada a la tienda
    

    public Customer(int lenght, int revenue, int id, int arrivalTime) {
        this.lenght = lenght;
        this.revenue = revenue;
        this.id = id;
        this.arrivalTime = arrivalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the time
     */
    public int getLength() {
        return lenght;
    }

    /**
     * @param length the time to set
     */
    public void setLength(int length) {
        this.lenght = length;
    }

    /**
     * @return the revenue
     */
    public int getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
