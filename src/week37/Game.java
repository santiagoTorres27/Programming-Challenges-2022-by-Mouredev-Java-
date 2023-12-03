package week37;

public class Game {
    private String name;
    private String launchDate;

    public Game(String name, String launchDate) {
        this.name = name;
        this.launchDate = launchDate;
    }

    public String getName() {
        return name;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    @Override
    public String toString() {
        return name + " (" + launchDate + ")";
    }
}
