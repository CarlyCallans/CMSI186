public class Vector {

    public double x;
    public double y;
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double x() {
        return x;
    }
    
    public double y() {
        return y;
    }

    public Vector add(Vector v) {
        double newX = this.x() + v.x();
        double newY = this.y() + v.y();
        return new Vector(newX, newY);
    }

    public Vector scale(double magnitude) {
        return new Vector(this.x() * magnitude, this.y * magnitude);
    }

}
