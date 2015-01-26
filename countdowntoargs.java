public class countdowntoargs {
    
    
    
    public static void main(String[] args) throws Exception {
        try {
            
            
            
            int input = Integer.parseInt(args[0]);
            
            
            
            if( input >=  0){
               countTo(Integer.parseInt(args[0]));
            }else{
                throw new Exception("bad stuff");
            }
        
        
        } catch (ArrayIndexOutOfBoundsException e) {
        
            System.out.println("No argument provided");
            System.out.println(e.getMessage());
            System.out.println(e.toString());

        
        } catch (NumberFormatException e2) {
        
            System.out.println("Please only insert integers!");
        
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public static void countTo(int maxCount) {

        
        for (int i = maxCount; i >= 0; i--) {
            System.out.println(i);
        }
        
        
        
    }
}
