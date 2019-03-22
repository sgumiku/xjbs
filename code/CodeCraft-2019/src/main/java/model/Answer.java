package model;

import java.util.List;

public class Answer {
    private int carId;
    private int time;
    private List<Integer> roadList;

    public Answer(int carId, int time, List<Integer> roadList) {
        this.carId = carId;
        this.time = time;
        this.roadList = roadList;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Integer> getRoadList() {
        return roadList;
    }

    public void setRoadList(List<Integer> roadList) {
        this.roadList = roadList;
    }
}
