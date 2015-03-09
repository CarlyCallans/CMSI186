public class Ball {

    public static Vector location;
    public static Vector initialVelocity;
    public static double radius;
    
    public Ball(Vector location, Vector initialVelocity) {
        this.location = location;
        this.initialVelocity = initialVelocity;
    }

    public Vector getLocation() {
        return location;
    }

    public double getRadius() {
        return radius = 2.25;
    }
    
    public void applyFriction(double grain) {
       initialVelocity = initialVelocity.scale(Math.pow(.99, grain));
            if (Math.sqrt(Math.pow(initialVelocity.x(),2) + Math.pow(initialVelocity.y(),2)) <= 1){
                initialVelocity = new Vector (0,0);
        } else{
    
        }
        //To simulate friction, a balls's velocity 
        //decreases by 1% each second until its velocity has decreased to less than 1 inch per second.
    }

    public void move(double grain) {

        this.location = this.location.add(initialVelocity.scale(grain));


        // Implement me!
    }

}
