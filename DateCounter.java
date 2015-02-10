public class DateCounter {

public static void main(String[] args) {
	try{

		int year0 = Integer.parseInt(args[0]);
		int month0 = Integer.parseInt(args[1]);
		int day0 = Integer.parseInt(args[2]);
		int year1 = Integer.parseInt(args[3]);
		int month1 = Integer.parseInt(args[4]);
		int day1 = Integer.parseInt(args[5]);

	if((!(isValidDate(year0, month0, day0))) || (!(isValidDate(year1, month1, day1)))) {
		System.out.println("Not a valid date");
	}
	    System.out.println(daysBetween(year0, month0, day0, year1,  month1, day1));

	}catch (ArrayIndexOutOfBoundsException e) {
        
        System.out.println("Usage: java DateCounter <year0> <month0> <day0> <year1> <month1> <day1>");

	} catch (NumberFormatException e2) {

		System.out.println("One or more of the supplied dates is not valid");
	}

}
	public static boolean isLeapYear(int year){
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
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
		}if ((isLeapYear(year))&& month == 2 && day > 29){
			return false;
		}else{
			return true;
		}
		}
	public static int daysBetween(int year0, int month0, int day0, int year1, int month1, int day1){
		if ((!(isValidDate(year0, month0, day0))) || (!(isValidDate(year1, month1, day1)))){
			System.exit(0);
		}
		int difference0 =0;
		int difference1 =0;
		int i;
		int totalDifference;
		for (i=1; i<year0; i++){
			if (isLeapYear(i)){
				difference0 = difference0 + 366;
			}else{
				difference0 = difference0 + 365;
			}
		}

		for (i=1; i<month0; i++){
			difference0 = difference0 + daysInMonth(i, year0);
		}
		difference0 = difference0 + day0;


		for (i=1; i<year1; i++){
			if (isLeapYear(i)){
				difference1 = difference1 + 366;
			}else{
				difference1 = difference1 + 365;
			}
		}


		for (i=1; i<month0; i++){
			difference1 = difference1 + daysInMonth(i, year1);
		}
		difference1 = difference1 + day1;

		totalDifference = Math.abs(difference0 - difference1);

		return totalDifference;
	}

	public static String dayOfTheWeek(int year, int month, int day){
		String[] namesOfTheDays = {"Sunday", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday"};
		if ((isLeapYear(year)) && (month == 1)){
			month = 0;
		} if ((isLeapYear(year)) && (month == 2)){
			month = 3;
		}
		if (month == 1){
			month = 0;
		}if (month == 2){
			month = 3;
		}if (month == 3){
			month = 3;
		}if (month == 4){
			month = 6;
		}if (month == 5){
			month = 1;
		}if (month == 6){
			month = 4;
		}if (month == 7){
			month = 6;
		}if (month == 8){
			month = 2;
		}if (month == 9){
			month = 5;
		}if (month == 10){
			month = 0;
		}if (month == 11){
			month = 3;
		}if (month ==12){
			month = 5;
		}

		int part1 = year / 4;
		
		int total = part1 + year;
		
		int part3 = year / 100;
		total = total - part3;
		
		int part4 = year / 400;
		total = total + part4;
		
		total = total + day;
		
		total = total + month;
		
		total = total - 1;
		
		total = total % 7;
		

		String theDay = namesOfTheDays[total];
		return theDay;

		}

}
