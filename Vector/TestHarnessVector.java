public class TestHarnessVector {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_vectorTest();
        //test_();
        //test_();
        //test_();
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
}
