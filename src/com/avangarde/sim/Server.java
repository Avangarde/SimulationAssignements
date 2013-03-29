/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.sim;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Zergio
 */
public class Server {

    //Cola de gente esperando al servidor
    ConcurrentLinkedQueue<Customer> customers = new ConcurrentLinkedQueue<>();
    int totalWaits;
    int totalRevenue;
    int numCustomers;
    Customer activeCustomer;

    public Server() {
        this.totalWaits = 0;
        this.totalRevenue = 0;
        this.numCustomers = 0;
        this.activeCustomer = null;
    }

    public Customer getActiveCustomer() {
        return activeCustomer;
    }

    public void setActiveCustomer(Customer activeCustomer) {
        this.activeCustomer = activeCustomer;
    }

    public ConcurrentLinkedQueue<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ConcurrentLinkedQueue<Customer> customers) {
        this.customers = customers;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalWaits() {
        return totalWaits;
    }

    public void setTotalWaits(int totalWaits) {
        this.totalWaits = totalWaits;
    }
}
