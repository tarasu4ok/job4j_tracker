package ru.job4j.stream;

public class House {
    private short yearBuild;
    private String material;
    private byte floorsCount;
    private double square;
    private boolean hasGarage;

    @Override
    public String toString() {
        return "House{"
                + "yearBuild=" + yearBuild
                + ", material='" + material + '\''
                + ", floorsCount=" + floorsCount
                + ", square=" + square
                + ", hasGarage=" + hasGarage
                + '}';
    }

    static class Builder {
        private short yearBuild;
        private String material;
        private byte floorsCount;
        private double square;
        private boolean hasGarage;

        public Builder buildYear(short yearBuild) {
            this.yearBuild = yearBuild;
            return this;
        }

        public Builder buildMaterial(String material) {
            this.material = material;
            return this;
        }

        public Builder buildFloorsCount(byte floorsCount) {
            this.floorsCount = floorsCount;
            return this;
        }

        public Builder buildSquare(double square) {
            this.square = square;
            return this;
        }

        public Builder buildHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        House build() {
            House house = new House();
            house.yearBuild = yearBuild;
            house.material = material;
            house.floorsCount = floorsCount;
            house.square = square;
            house.hasGarage = hasGarage;
            return house;
        }
    }

    public static void main(String[] args) {
        House house = new Builder().buildYear((short) 2015)
                .buildMaterial("Brick")
                .buildFloorsCount((byte) 3)
                .buildSquare(235.8)
                .buildHasGarage(true)
                .build();
        System.out.println(house);
    }
}
