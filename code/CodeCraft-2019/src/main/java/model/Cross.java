package model;

public class Cross {
    private int road;
    private int id1;
    private int id2;
    private int id3;
    private int id4;

    public Cross(int road, int id1, int id2, int id3, int id4) {
        this.road = road;
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.id4 = id4;
    }

    public int getRoad() {
        return road;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public int getId3() {
        return id3;
    }

    public int getId4() {
        return id4;
    }

    public void setRoad(int road) {
        this.road = road;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public void setId4(int id4) {
        this.id4 = id4;
    }
}
