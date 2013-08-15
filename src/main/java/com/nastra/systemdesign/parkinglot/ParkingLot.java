package com.nastra.systemdesign.parkinglot;

/**
 *
 * @author nastra
 */
public class ParkingLot {

    private int numberOfLevels;
    private Level[] levels;

    public ParkingLot(int numberOfLevels) {
        this.numberOfLevels = numberOfLevels;
        levels = new Level[numberOfLevels];
        for (int i = 0; i < numberOfLevels; i++) {
            levels[i] = new Level(i, 30);
        }
    }

    public boolean park(Vehicle v) {
        for (Level level : levels) {
            if (level.park(v)) {
                return true;
            }
        }
        return false;
    }

    class Spot {

        Vehicle vehicle;
        SpotSize spotSize;

        public Spot(SpotSize spotSize) {
            this.spotSize = spotSize;
        }

        public boolean isAvailable() {
            return null == vehicle;
        }

        public boolean park(Vehicle v) {
            if (isAvailable()) {
                this.vehicle = v;
                return true;
            }
            return false;
        }

        public void removeVehicle() {
            vehicle = null;
        }
    }

    class Level {

        private Spot[] spots;
        private int maxSpots;
        private int availableSpots;
        private int floor;

        public Level(int floor, int maxSpots) {
            this.maxSpots = maxSpots;
            this.floor = floor;
            initSpots();
        }

        private void initSpots() {
            spots = new Spot[maxSpots];
            for (int i = 0; i < maxSpots; i++) {
                if (i % 10 == 0) {
                    spots[i] = new Spot(SpotSize.SMALL);
                } else if (i % 20 == 0) {
                    spots[i] = new Spot(SpotSize.LARGE);
                } else {
                    spots[i] = new Spot(SpotSize.MEDIUM);
                }
            }
        }

        public boolean park(Vehicle v) {
            if (availableSpots < v.spotsNeeded()) {
                return false;
            }
            int spotNumber = findAvailableSpot(v);
            if (spotNumber < 0) {
                return false;
            }

            return startParkingInSpot(v, spotNumber);
        }

        private int findAvailableSpot(Vehicle v) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private boolean startParkingInSpot(Vehicle vehicle, int spotNumber) {
            boolean success = true;
            for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded(); i++) {
                success &= spots[i].park(vehicle);
            }
            availableSpots -= vehicle.spotsNeeded();
            return success;
        }
    }
}
