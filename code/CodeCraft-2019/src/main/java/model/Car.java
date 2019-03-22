package model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private int start;
    private int end;
    private int speed;
    private int time;
    private int acturelTime;
    private List<Integer> roadList;


    public Car(int id, int start, int end, int speed, int time) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.speed = speed;
        this.time = time;
        this.roadList = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getSpeed() {
        return speed;
    }

    public int getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
