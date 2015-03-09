public class TestHarnessVector {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_vectorTest();
        test_add();
        test_magnitude();
        test_ball();
        test_getLocation();
        //test_();
        //test_();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }
        private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }
    private static void test_vectorTest() {
        System.out.println("Testing vector constructors");
        Vector testVector1 = new Vector(0,0);
        Vector testVector2 = new Vector(1,3);
        Vector testVector3 = new Vector(3,2);
        System.out.println("Testing null");
        try{
            displaySuccessIfTrue(null != testVector1);
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try{
            displaySuccessIfTrue(null != testVector2);
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try{
            displaySuccessIfTrue(null != testVector3);
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("Testing values of vector");
        try{
            displaySuccessIfTrue(0 == testVector1.x());
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }


        try{
            displaySuccessIfTrue(0 == testVector1.y());
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try{
            displaySuccessIfTrue(1 == testVector2.x());
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try{
            displaySuccessIfTrue(3 == testVector2.y());
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(3 == testVector3.x());
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(2 == testVector3.y());
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
    }
    private static void test_add() {
        System.out.println("Testing vector constructors");
        Vector testVector1 = new Vector(0,0);
        Vector testVector2 = new Vector(1,3);
        Vector testVector3 = new Vector(-3,-2);

        try{
            displaySuccessIfTrue(testVector1.add(testVector2).x() == 1);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector1.add(testVector2).y() == 3);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector1.add(testVector3).x() == -3);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector1.add(testVector3).y() == -2);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector2.add(testVector3).x() == -2);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector2.add(testVector3).y() == 1);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
    }
    private static void test_magnitude() {
        Vector testVector1 = new Vector(0,0);
        Vector testVector2 = new Vector(1,3);
        Vector testVector3 = new Vector(-3,-2);
        
        try{
            displaySuccessIfTrue(testVector1.scale(2).x() == 0 && testVector1.scale(2).y == 0);
        }catch (Exception e) {
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector2.scale(0.5).x() == 0.5 && testVector2.scale(0.5).y == 1.5);
        }catch (Exception e ){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector3.scale(10).x() == -30 && testVector3.scale(10).x == -20);        
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
    }
    private static void test_ball() {
        System.out.println("Testing Ball constructors");
        Vector locationVector = new Vector(0,0);
        Vector initialVecocityVector = new Vector(1,3);

        System.out.println("Checking for null");
       try{
            displaySuccessIfTrue(null != locationVector);
        }
        catch (Exception e){
            displaySuccessIfTrue(false);
        }

        try{
            displaySuccessIfTrue(null != initialVecocityVector);
        }
        catch (Exception e){
            displaySuccessIfTrue(false);
        }
    }

    public static void test_getLocation(){
        System.out.println("Test getLocation");
        Vector testVector1 = new Vector(0,0);
        Vector testVector2 = new Vector(1,3);
        Vector testVector3 = new Vector(-3,-2);
        
        Ball testBall1 = new Ball(new Vector(0,0), new Vector(0,0));
        try{
            displaySuccessIfTrue(testBall1.getLocation().x() == 0 && testBall1.getLocation().y() == 0);
        } 
        catch (Exception e){
            displaySuccessIfTrue(false);
        }
        Ball testBall2 = new Ball(testVector2, testVector3);
        try{
            displaySuccessIfTrue(testBall2.getLocation().x() == 1 && testBall2.getLocation().y() == 3);
        }
        catch (Exception e){
            displaySuccessIfTrue(false);
        }
        Ball testBall3 = new Ball (testVector3, testVector1);
        try{
            displaySuccessIfTrue(testBall3.getLocation().x() == -3 && testBall3.getLocation().y() == -2);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
    }

}
