package LLD.parkinglot;

import java.util.ArrayList;
import java.util.Stack;

public class Slot {
    public String id;
    public Type type;

    public Slot(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public static Stack<Slot> allotSlots(int count, Type type) {
        Stack<Slot> slots = new Stack<>();

        for (int i = 0 ; i < count ;i ++) {
            slots.push(new Slot("#"+(i+1), type));
        }

        return slots;
    }

}
