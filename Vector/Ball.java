public class Ball {

    // Declare my instance variables!
    
    public Ball(Vector location, Vector initialVelocity) {
        // Implement me!
        // Corrected (03/02/2015): required constructor will not take in radius, as all balls 
        // should have a fixed 2.25 in diameter.
    }

    public Vector getLocation() {
        // Implement me!
    }

    public double getRadius() {
        // Implement me!
    }
    
    public void applyFriction(double grain) {
        // Implement me!
    }

    public void move(double grain) {
        // Implement me!
    }

}
