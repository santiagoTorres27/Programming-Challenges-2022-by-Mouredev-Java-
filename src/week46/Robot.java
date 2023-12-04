package week46;

public class Robot {
    private int x;
    private int y;
    private int faceDirection;
    private int movements;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.faceDirection = 0;
        this.movements = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFaceDirection() {
        return faceDirection;
    }

    public int getMovements() {
        return movements;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFaceDirection(int faceDirection) {
        this.faceDirection = faceDirection;
    }

    public void setMovements(int movements) {
        this.movements = movements;
    }

    public void move(int distance) {
        if (faceDirection == 0) {
            setY(getY() + distance);
        } else if (faceDirection == 90) {
            setX(getX() - distance);
        } else if (faceDirection == 180) {
            setY(getY() - distance);
        } else if (faceDirection == 270) {
            setX(getX() + distance);
        }

        rotate();
    }

    public void rotate() {
        setFaceDirection(getFaceDirection() + 90);

        if (getFaceDirection() == 360) {
            setFaceDirection(360);
        }
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y + ", faceDirection: " + faceDirection;
    }
}
