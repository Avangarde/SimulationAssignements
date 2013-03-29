/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avangarde.libraries;

import java.util.Random;
import java.lang.Math.*;

/**
 *
 * @author zergio
 */
public class RandomGenerators {

    double expRandomVariable(double mean) {

        double z = uniRandomVariable(0, 1);

        return (-mean * java.lang.Math.log10(z));

    }

    double uniRandomVariable(int min, int max) {
        Random r1 = new Random();
        double result = r1.nextInt(max - min);
        result += min;
        return result;

    }
}
