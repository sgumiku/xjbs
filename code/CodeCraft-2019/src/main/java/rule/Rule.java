package rule;

public class Rule {
    public int getSpeed(int carSpeed, int roadSpeed){
        return carSpeed >= roadSpeed? roadSpeed : carSpeed;
    }

}
