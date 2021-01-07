package com.csis.giron.models;

import java.util.ArrayList;
import java.util.List;

import com.csis.giron.exceptions.InvalidMeetDayException;

public class SectionNumber extends CollegeClass {
	
	private String roomNumber;
	private String _meetDays;
	private List<String> meetDays;
	
	public SectionNumber(){
	}
	
	public SectionNumber(String roomNumber, List<String> meetDays){
		this.roomNumber = roomNumber;
		this.meetDays = meetDays;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public List<String> getMeetDays() {
		return meetDays;
	}
	public void setMeetDays(List<String> meetDays) {
		this.meetDays = meetDays;
	}
	
	public String getMeetingDays() {
		_meetDays = "";
		List<String> list = getMeetDays();
		for(String s : list) {
			_meetDays += s;
		}
		String format = _meetDays.replace("y", "y, ").trim();
		if(format.endsWith(",")) {
			format = format.substring(0, format.length() -1);
		}
		return format;
	}
	
	public static List<String> getDays(String userInputAsString) throws InvalidMeetDayException {
		
		List<String> dayList = new ArrayList<String>();
		
		try {
			for (int i = 0; i < userInputAsString.length(); i++) {
				char dayAsNumericChar = userInputAsString.charAt(i);

				String day;

				switch (dayAsNumericChar) {
					case '1':
						day = "Sunday";
						break;
					case '2':
						day = "Monday";
						break;
					case '3':
						day = "Tuesday";
						break;
					case '4':
						day = "Wednesday";
						break;
					case '5':
						day = "Thursday";
						break;
					case '6':
						day = "Friday";
						break;
					case '7':
						day = "Saturday";
						break;
						
					default:
						throw new InvalidMeetDayException("Invalid MeetDay entered-> " + dayAsNumericChar);
				}
				if (dayList.contains(day)) {
					throw new InvalidMeetDayException("Day: " + day + " is picked twice");
				}
				dayList.add(day);
			}
			
			return dayList;
		} 
		catch(InvalidMeetDayException e) {
			System.err.println(""+e.getMessage());
		}
		return null;

	}
	
	
	@Override
	public String toString() {
		return String.format("\nClass Information\n"+"Class name: %s \n" + "Class number: %s \n"+
						"Room number: %s \n" + "Meeting Days: %s" , super.getClassName(), super.getClassNum(), getRoomNumber(), getMeetingDays());
	}
}