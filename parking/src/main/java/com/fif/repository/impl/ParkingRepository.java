//package com.fif.repository.impl;
//
//import com.fif.entity.ParkingEntity;
//import com.fif.record.ParkingRecord;
//import com.fif.repository.ParkingInterface;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ParkingRepository implements ParkingInterface {
//
//    private static int idCounter = 1;
//    private static final List<ParkingEntity> parkings = new ArrayList<>();
//
//    static {
//        parkings.add(new ParkingEntity(
//                idCounter,
//                "MENARA FIF",
//                100,
//                50,
//                80,
//                40
//        ));
//    }
//
//
//    public List<ParkingEntity> getParkingData() {
//        return parkings;
//    }
//
//    public void createParking(ParkingRecord parking) {
//        ParkingEntity prd = new ParkingEntity(
//                ++idCounter,
//                parking.getAddress(),
//                parking.getCarCapacity(),
//                parking.getMotorCapacity(),
//                parking.getAvailCarSpot(),
//                parking.getAvailMotorSpot()
//        );
//        parkings.add(prd);
//    }
//}
