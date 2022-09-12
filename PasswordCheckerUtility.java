import java.util.*; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
public class PasswordCheckerUtility extends Exception{
	
	private static ArrayList<String> myArr;

	//PasswordCheckerUtility(): void
	public PasswordCheckerUtility() {
		
	}
	
	//static comparePasswords​(String password, String passwordConfirm): void
	/**
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 * 
	 */
	public static void comparePasswords​(String password, String passwordConfirm) throws UnmatchedException {
		if(!(password.equals(passwordConfirm))) {
			throw new UnmatchedException();
		}
	}
	
	//static comparePasswordsWithReturn​(String password, String passwordConfirm):boolean
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//static getInvalidPasswords​(ArrayList<String> passwords): ArrayList<String>
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) {
		myArr = new ArrayList<String>();
		for(int i=0; i<passwords.size(); i++) {
			try {
				isValidPassword​(passwords.get(i));
			}
			catch(Throwable e) {
				myArr.add(passwords.get(i) + " " + e.getMessage());
			}
			
		}
		return myArr;
	}
	
	//static hasBetweenSixAndNineChars​(String password): boolean
	public static boolean hasBetweenSixAndNineChars​(String password) {
		if((password.length() >= 6) || (password.length() <= 9)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//static hasDigit​(String password): boolean
	public static boolean hasDigit​(String password) throws NoDigitException{
		int count = 0;
		char c;
		for(int i=0; i<password.length(); i++) {
			c = password.charAt(i);
			if(Character.isDigit(c)) {
				count++;
			}
		}
		if(count == 0) {
			throw new NoDigitException();
		}
		else {
			return true;
		}
	}
	
	//static hasLowerAlpha​(String password): boolean
	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException {
		int count = 0;
		char c;
		for(int i=0; i<password.length(); i++) {
			c = password.charAt(i);
			if(Character.isLowerCase(c)) {
				count++;
			}
		}
		if(count == 0) {
			throw new NoLowerAlphaException();
		}
		else {
			return true;
		}
	}
	
	//static hasSpecialChar​(String password): boolean
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		Matcher m = p.matcher(password);
		if(m.find()) {
			return true;
		}
		else {
			throw new NoSpecialCharacterException();
		}
	}
	
	//static hasUpperAlpha​(String password): boolean
	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException{
		int count = 0;
		char c;
		for(int i=0; i<password.length(); i++) {
			c = password.charAt(i);
			if(Character.isUpperCase(c)) {
				count++;
			}
		}
		if(count == 0) {
			throw new NoUpperAlphaException();
		}
		else {
			return true;
		}
	}
	
	//static isValidLength​(String password): boolean
	public static boolean isValidLength​(String password) throws LengthException {
		if(password.length() < 6) {
			throw new LengthException();
		}
		else {
			return true;
		}
	}
	
	//static isWeakPassword​(String password): boolean
	public static boolean isWeakPassword​(String password) throws WeakPasswordException {
		
		return true;
	}
	
	//static NoSameCharInSequence​(String password): boolean
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException {
		int count = 0;
		char c1, c2;
		for(int i=0; i<password.length()-2; i++) {
			c1 = password.charAt(i);
			c2 = password.charAt(i+1);
			if(c1 == c2) {
				count++;
			}
		}
		if(count == 0) {
			throw new InvalidSequenceException();
		}
		else {
			return true;
		}
	}
	
	//static isValidPassword​(String password): boolean
	//isValidPassword
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, 
															NoLowerAlphaException, NoDigitException, 
															NoSpecialCharacterException, InvalidSequenceException{
		if(     isValidLength​(password) && hasDigit​(password) && 
				hasUpperAlpha​(password) && hasLowerAlpha​(password) && 
				hasSpecialChar​(password) && NoSameCharInSequence​(password)) {
			return true;
		}
		else {
			return false;
		}
		
	}


}
