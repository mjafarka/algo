package LLD.parkinglot;

public class main {
    public static void main(String[] args) throws Exception {
        ParkingLot p = ParkingLot.getInstance();

        Vehicle car1 = new Vehicle("123", Type.CAR);

        Vehicle car2 = new Vehicle("223", Type.CAR);

        Vehicle car3 = new Vehicle("323", Type.CAR);

        Vehicle car4 = new Vehicle("423", Type.CAR);


        String id1 = p.park(car1);
        String id2 = p.park(car2);
        String id3 = p.park(car3);
        String id4 = p.park(car4);

        System.out.println(id1+", "+
        id2+", "+
        id3+", "+
        id4+", ");
        p.unpark(car4);
    }
}
