import java.util.Arrays;

public class ChangeMaker {



	public static void main(String[] args) throws Exception {
		try {
            
            int input = Integer.parseInt(args[0]);

            if( input >=  0){
            	int[] answer = getChange(input);
          
            	System.out.println("Quarters:"+answer[0]+",Dimes:"+answer[1]+",Nickles:"+answer[2]+",Pennies:"+answer[3]);
 
            }else{
                throw new Exception("Cannot make change for negative amount.");

            }
        
        
        } catch (ArrayIndexOutOfBoundsException e) {
        
            System.out.println("Usage: java ChangeMaker <amount in cents>");

        
        } catch (NumberFormatException e2) {
        
            System.out.println("Given value is not an integer.");
 
        
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }

	public static int getQuarters(int cents){
		int quarter = 25;
		int quarters = cents / quarter;
		return quarters;
	}

	public static int getDimes(int cents){
		int dimes = 10;
		dimes = cents/dimes;
		return dimes;
	}

	public static int getNickels(int cents){
		int nickels = 5;
		nickels = cents/nickels;
		return nickels;
	}

	public static int getPennies(int cents){
		int pennies = 1;
		pennies = cents/pennies;
		return pennies;
	}
	
	public static int[] getChange(int cents){


		int quarters = getQuarters(cents);



		int remainder = cents - (25 * quarters);

		int dimes = getDimes(remainder);

		remainder = remainder - (10 * dimes);

		int nickles = getNickels(remainder);

		remainder = remainder - (5 * nickles);

		int pennies = getPennies(remainder);



		
		int[] answer = new int[4];

		answer[0] = quarters;
		answer[1] = dimes;
		answer[2] = nickles;
		answer[3] = pennies;
	

		return answer;

	}
}
