package week04;

public class Square implements IPolygonArea{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    @Override
    public double getArea() {
        return this.getSide() * this.getSide();
    }
}
