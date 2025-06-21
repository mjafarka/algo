package LLD.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    
    private final List<Floor> floors;

    private static ParkingLot instance;

    private ParkingLot() {
        this.floors = createFloors(); // hard coded sizes.
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public String park(Vehicle vehicle) throws Exception {
        for (Floor f : floors) {
            if (f.availableSlot(vehicle)) {
                return f.parkVehicle(vehicle);
            }
        }

        return "-1";
    }

    public boolean unpark(Vehicle vehicle) {
        for (Floor f : floors) {
            if (f.parkedVehicle(vehicle)) {
                return f.unparkVehicle(vehicle);
            }
        }

        return false;
    }

    private List<Floor> createFloors() {
        List<Floor> floors = new ArrayList<>();

        for (int i = 0 ; i < 1 ; i ++) {
            floors.add(new Floor(3,3,3));
        }

        return floors;

    }
}

// kukkuri kutti kurukkan, movie, other song
