package com.csis.giron;

import java.util.List;
import java.util.Scanner;

import com.csis.giron.exceptions.InvalidCollegeClassException;
import com.csis.giron.exceptions.InvalidMeetDayException;
import com.csis.giron.exceptions.InvalidRoomNumberException;
import com.csis.giron.helper.FormatterUtility;
import com.csis.giron.models.CollegeClass;
import com.csis.giron.models.SectionNumber;

public class ExceptionProject {

	public static void main(String[] args) {

		CollegeClass collegeClass = new CollegeClass();
		
		Scanner scanner = new Scanner(System.in);

		try {
			
			System.out.print("Enter name of class> ");
			String className = scanner.nextLine();
			collegeClass.setClassName(className);
			System.out.println("You entered " + "'" + collegeClass.getClassName() + "'");

			System.out.print("Enter class section number> ");
			String sectionNumber = scanner.nextLine();
			collegeClass.setClassNum(sectionNumber.toUpperCase());
			System.out.println("You entered " + "'" + collegeClass.getClassNum() + "'");
			

			if (FormatterUtility.properClassNumberFormat(collegeClass.getClassNum())) {
				System.out.println(collegeClass.toString());
			} else {
				throw new InvalidCollegeClassException("Section number is not in correct format!");
			}
			
			System.out.print("Enter room number> ");
			String roomNo = scanner.nextLine();
			
			
			if(roomNo.length() > 4 && roomNo.length() < 6) {
				throw new InvalidRoomNumberException("Room number can not exceed 4 characters or more than 6...");
			} 
			
			System.out.println("You entered: "+roomNo);
			
			System.out.print("Enter class meeting days as numerics> ");
			String userInputAsString = String.valueOf(scanner.nextLine());
			
			List<String> dayList = SectionNumber.getDays(userInputAsString);

	        SectionNumber sec = new SectionNumber(roomNo, dayList);
	        sec.setClassName(className);
	        sec.setClassNum(sectionNumber);
	        
	        System.out.println(sec.toString());
	        

		}

		catch (InvalidCollegeClassException e) {
			System.err.println("An error has occurred: " + e.getMessage());
			System.err.println("Class section must be in the following format:\n");
			System.err.println("LLLL-XXX where L is a letter within the range A-M to indicate department");
			System.err.println("and each X is a digit within the range 0-9. The max number should be 299.");
			System.err.println("the dash ('-') is optional.");
		} 
		catch (InvalidRoomNumberException e) {
			System.err.println("An error has occurred: " + e.getMessage());
		} 
		catch (InvalidMeetDayException e) {
			System.err.println("An error has occurred: " + e.getMessage());
		} 
		finally {
			scanner.close();
		}

	}

}
