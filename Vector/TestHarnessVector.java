public class TestHarnessVector {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_vectorTest();
        test_add();
        test_magnitude();
        //test_();
        //test_();
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
            displaySuccessIfTrue(testVector1.add(testVector1).y() == -2);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector2.add(testVector3).x() == -2);
        } catch (Exception e){
            displaySuccessIfTrue(false);
        }
        try{
            displaySuccessIfTrue(testVector2.add(testVector3).y() == -2);
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
}
