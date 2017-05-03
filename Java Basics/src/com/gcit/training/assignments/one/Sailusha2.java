package com.gcit.training.assignments.one;


public class Sailusha2 {
    private String name;
    private int chipCount = 0;

    public static Sailusha2 createPlayer (String name) throws Sailusha4 {
        if (name == null) {
            return null;
        }
        Sailusha2 obj = new Sailusha2(name);
        if (obj.getName() == null) {
            return null;
        }
        return obj;
    }

    private Sailusha2(String name) throws Sailusha4 {
        setName(name);
    }

    public void setName(String name) throws Sailusha4 {
        if (name.length() < 3 || name.length() > 45) {
            throw new Sailusha4("Name Should be between 3 to 45 characters");

        }
        else if (name.matches(".*\\d.*")) {
            throw new Sailusha4("Only characters are allowed");

        }
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void addChipCount(int chipCount) {
        this.chipCount += chipCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sailusha2)) return false;

        Sailusha2 player = (Sailusha2) o;

        if (chipCount != player.chipCount) return false;
        return name != null ? name.equalsIgnoreCase(player.name) : player.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


}
