package com.hackathon.gmit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GmitApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(distance(15.991253,16.014032,108.256963,108.255149));
    }

    public double distance(double lat1, double lat2, double long1,
                                  double long2) {

        double dist = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return  Math.ceil((dist/1000)*100.0)/100.0;
    }
}
