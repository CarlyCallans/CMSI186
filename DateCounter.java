public class CountTheDays {
	public static void main(String[]args){
		long month0 = Long.parseLong(args[0]);
		long day0 = Long.parseLong(args[1]);
		long year0 = Long.parseLong(args[2]);
		long month1 = Long.parseLong(args[3]);
		long day1 = Long.parseLong(args[4]);
		long year1 = Long.parseLong(args[5]);
		if(!(isValidDate(month0, day0, year0))){
			System.out.println("Not a valid date");
		}
		System.out.println(daysBetween(month0, day0, year0, month1, day1, year1));
	}
	public static boolean isLeapYear(long year){
		if (0 == year % 100){
			if(!(0 == year % 400)){
				return false;
			}
			else{ 
				return(0 == year % 4);
			}
		}
		return (0 == year % 4);
	}
	public static long daysInMonth(long month, long year){
		long days = 0;
		if (month == 4 | month == 6 | month == 9 | month == 11){
			days = 30;
		}
		else if (month == 1| month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
			days = 31;
		}
		else if (month == 2){
			if (isLeapYear(year) == true){
				days = 29;
			}
			else days = 28;
		}
		return days;
	}

	public static long daysBetween ( long month0, long day0, long year0, long month1, long day1, long year1 ){
		long difference0=0;
		long difference1=0;
		for (int i=1; i<year0; i++){
			if (isLeapYear(i)){
				difference0=difference0 + 366;
			}
			else{
				difference0=difference0 + 365;
			}

		}
		for (int i=1; i<month0; i++){
			difference0 = difference0 + daysInMonth(i, year0);
		}
		difference0 = difference0 + day0;
		for (int i=1; i<year1; i++){
			if (isLeapYear(i)){
				difference1=difference1 + 366;
		}
			else{
				difference1=difference1+365;
			}
		}
		for (int i=1; i<month1; i++){
			difference1 = difference1 + daysInMonth(i, year1);
		}
		difference1 = difference1 + day1;
		long overall = Math.abs(difference1-difference0);
		return overall;
	}






	 public static boolean isValidDate ( long month, long day, long year ){
	 	int counter = 0;
		for (int i=1; i < 13; i++){
			if (month == i){
				 counter=1;
			}
		}
		if (counter==0){
			return false; 
		}
		if(day < 1 || day > daysInMonth(month, year)){
				return false;
		}
		if (year < 0){
			return false;
		}
		else{
			return true;
		}
				
	}

}


