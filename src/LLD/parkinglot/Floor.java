package LLD.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;




public class Floor {
    private Stack<Slot> carSlot;

    private Stack<Slot> bikeSlot;

    private Stack<Slot> truckSlot;

    private Map<String,Slot> parked;

    public Floor(int carSlotCount, int bikeSlotCount, int truckSlotCount) {
        carSlot = Slot.allotSlots(carSlotCount, Type.CAR);
        bikeSlot = Slot.allotSlots(carSlotCount, Type.BIKE);
        truckSlot = Slot.allotSlots(carSlotCount, Type.TRUCK);
        parked = new HashMap<>();
    }


    public boolean availableSlot(Vehicle veh) {
        Type vehicleType = veh.type;

        switch(vehicleType) {
            case TRUCK:
                return truckSlot.size() > 0;
            case CAR:
                return carSlot.size() > 0;
            case BIKE:
                return bikeSlot.size() > 0;
            default:
                return false;
        }
    }

    public String parkVehicle(Vehicle veh) throws Exception {
        if (!availableSlot(veh)) {
            return "-1";
        }

        Type vehicleType = veh.type;

        Slot takenSlot;

        switch(vehicleType) {
            case TRUCK:
                takenSlot = truckSlot.pop();
                break;
            case CAR:
                takenSlot = carSlot.pop();
                break;
            case BIKE:
                takenSlot = bikeSlot.pop();
                break;
            default:
                takenSlot = null;
                throw new Exception("slot not found, availability check failed");
        }

        parked.put(veh.licence,takenSlot);

        return takenSlot.id;
    }

    public boolean parkedVehicle(Vehicle veh) {
        return parked.containsKey(veh.licence);
    }

    public boolean unparkVehicle(Vehicle veh) {
        if (! parkedVehicle(veh)) {
            return false;
        }

        Slot parkedVehicle = parked.get(veh.licence);

        Type vehicleType = parkedVehicle.type;

        parked.remove(veh.licence);

        switch(vehicleType) {
            case TRUCK:
                truckSlot.push(parkedVehicle);
                break;
            case CAR:
                carSlot.push(parkedVehicle);
                break;
            case BIKE:
                bikeSlot.push(parkedVehicle);
                break;
        }

        return true;
    }

}
