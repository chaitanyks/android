package com.example.sqltest;

public class RadiologyData {
    String id;
    String name;
    String notes;
    String subclass;

    public RadiologyData() {
    }

    public String toString() {
        return this.id + " " + this.notes;
    }

    public RadiologyData(String id2, String name2, String subclass2, String notes2) {
        this.id = id2;
        this.name = name2;
        this.subclass = subclass2;
        this.notes = notes2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getSubclass() {
        return this.subclass;
    }

    public void setSubclass(String subclass2) {
        this.subclass = subclass2;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes2) {
        this.notes = notes2;
    }
}
