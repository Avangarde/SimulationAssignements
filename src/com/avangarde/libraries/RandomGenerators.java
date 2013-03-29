/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.libraries;

import java.util.Random;

/**
 *
 * @author zergio
 */
public class RandomGenerators {
    
    double expRandomVariable(double mean){
        
        double z = uniRandomVariable(0,1);
                
        return(-mean*log(z));
        
    }
    
    double uniRandomVariable(double min, double max){
        
        
        return 2;
    }
    
}
