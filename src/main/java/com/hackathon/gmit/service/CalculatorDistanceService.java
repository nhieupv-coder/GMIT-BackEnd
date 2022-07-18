/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.service;

import org.apache.lucene.util.SloppyMath;
import org.springframework.stereotype.Service;

@Service
public class CalculatorDistanceService {
    public double calculatorDistance(double lat1,
                                     double lat2,
                                     double long1,
                                     double long2) {

        double dist = SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return Math.ceil((dist / 1000) * 100.0) / 100.0;
    }
}
