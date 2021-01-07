package com.csis.giron.helper;

import java.util.regex.Pattern;

public class FormatterUtility {
	
	/**
	 * 
	 * @param str user inputted data 
	 * @return the boolean value if string matches regular expression 
	 */
	public static boolean properClassNumberFormat(String str) {
		Pattern p = Pattern.compile("[A-M]{4}-?[0-2][0-9]{2}");
		if(p.matcher(str).matches()) {
			return true;
		}
		return false;
	}

}
