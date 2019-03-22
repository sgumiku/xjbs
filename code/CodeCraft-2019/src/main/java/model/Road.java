package model;

public class Road {
    private int id;
    private int len;
    private int spped;
    private int carCount;
    private int start;
    private int end;
    private int twoWay;

    public Road(int id, int len, int spped, int carCount, int start, int end, int twoWay) {
        this.id = id;
        this.len = len;
        this.spped = spped;
        this.carCount = carCount;
        this.start = start;
        this.end = end;
        this.twoWay = twoWay;
    }

    public int getId() {
        return id;
    }

    public int getLen() {
        return len;
    }

    public int getSpped() {
        return spped;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getTwoWay() {
        return twoWay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public void setSpped(int spped) {
        this.spped = spped;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    public void setTwoWay(int twoWay) {
        this.twoWay = twoWay;
    }

    public int bsearch(int[] array, int target)//返回下标
    {
        int low = 0;
        int high = array.length;
        int mid;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(array[mid] > target)
                high = mid - 1;
            if(array[mid] == target)
                return mid;
            else
                low = mid + 1;

        }
        return -1;
    }
}
