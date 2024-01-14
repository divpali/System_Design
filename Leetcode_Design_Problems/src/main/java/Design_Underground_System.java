/*

1396. Design Underground System

An underground railway system is keeping track of customer travel times between different stations. They are using this
data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.

void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.

double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation to endStation that happened directly,
meaning a check in at startStation followed by a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the time it takes to travel from
endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then
checks out at time t2, then t1 < t2. All events happen in chronological order.
 */


import java.util.HashMap;
import java.util.Map;

public class Design_Underground_System {

    Map<Integer, ArrivalInfo> arrivals;
    Map<String, double[]> total;


    Design_Underground_System() {
        arrivals = new HashMap<>();
        total = new HashMap<>();
    }

    public static void main(String[] args) {

    }

    public void checkIn(int id, String startPoint, int start_time) {

        //Map<int id, (ArrivalInfo -> id,startPoint,start_time)>

        arrivals.put(id, new ArrivalInfo(id, startPoint, start_time));

    }

    public void checkOut(int id, String stopPoint, int end_time) {

        //Map<String start+end, [double[0](end_time-start_time),double[1](count)]>

        ArrivalInfo arrivalInfo = arrivals.get(id);
        String startPoint = arrivalInfo.startPoint;

        String key = startPoint+"_"+stopPoint;

        int start_time = arrivalInfo.start_time;
        int final_time = end_time - start_time;

        double[] value = new double[2];
        value[0] += final_time;
        value[1] = total.get(key)[1]+1;

        total.put(key, value);

    }

    public double getAverageTime(String startPoint, String stopPoint) {

        String key = startPoint+"_"+stopPoint;
        double[] val = total.get(key);
        double avg = val[0] / val[1];

        return avg;
    }
}


class ArrivalInfo {
    int id;
    String startPoint;
    int start_time;

    public ArrivalInfo(int id, String startPoint, int start_time) {
        this.id = id;
        this.startPoint = startPoint;
        this.start_time = start_time;
    }

}