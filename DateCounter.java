public class DateCounter {

public static void main(String[] args) {
	int year1 = Integer.parseInt(args[0]);
	int month1 = Integer.parseInt(args[1]);
	int day1 = Integer.parseInt(args[2]);
	int year2 = Integer.parseInt(args[3]);
	int month2 = Integer.parseInt(args[4]);
	int day2 = Integer.parseInt(args[5]); */

	if(!(isValidDate(year1, month1, day1))){
		System.out.println("Not a valid date");	
	}

	/* if (ifLeapYear(args[0])){
		system.println()
	} */
}
	public static boolean isLeapYear(int year){
		if ((year % 4 == 0) && (year % 100 == 0) || (year % 400 == 0)){
			return true;
		} else {
			return false;
			}
		}
	public static int daysInMonth(int year, int month){
		int days = 0;
		if (month ==4 | month == 6 | month == 9 | month == 11){
			days = 30;
		}
		else if(month == 1 | month == 3 | month == 5 | month ==7 | month == 8 | month == 10| month ==12){
			days = 31;
		}
		else if (month ==2){
			if (isLeapYear(year) == true){
				days = 29;
			}else{
			 days = 28;
		}
		}
		return days;
	}
	public static boolean isValidDate(int year, int month, int day){
		if (month < 0 || month > 12){
			return false;
		}if (day < 0 ||  day > 31){
			return false;
		}if (year < 0){
			return false;
		}else{
			return true;
		}
		}
	public static int daysBetween(int year0, int month0, int day0, int year1, int month1, int day1){

	}
	}

