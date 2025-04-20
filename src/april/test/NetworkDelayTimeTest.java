package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import april.NetworkDelayTime;

public class NetworkDelayTimeTest {

    NetworkDelayTime a = new NetworkDelayTime();
    @Test
    void testNetworkDelayTime() {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};

        int n = 4;
        int k = 2;

        int expected = 2;

        assertEquals(expected,a.networkDelayTime(times, n, k));
    }

    @Test
    void testNetworkDelayTime1() {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1},{2,4,1}};

        int n = 4;
        int k = 2;

        int expected = 1;

        assertEquals(expected,a.networkDelayTime(times, n, k));
    }
}
