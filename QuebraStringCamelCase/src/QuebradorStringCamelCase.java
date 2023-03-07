import java.util.List;
import java.util.ArrayList;

public class QuebradorStringCamelCase {

	public static List<String> converterCamelCase(String string) {
		List<String> listaStrings = new ArrayList<String>();
		Integer nextUpperCaseIndex = nextUpperCaseLetter(string, 0);
		if (isAllUpperCase(string)) {
			listaStrings.add(string);
			return listaStrings;
		}
		else if (nextUpperCaseIndex <= 0) {
			listaStrings.add(string.toLowerCase());
			return listaStrings;
		}
		else {
			String word = (String) string.subSequence(0, nextUpperCaseIndex);
			String rest = (String) string.subSequence(nextUpperCaseIndex, string.length());
			if (isAllUpperCase(word)) listaStrings.add(word);
			else listaStrings.add(word.toLowerCase());
			listaStrings.addAll(converterCamelCase(rest));
		}
		System.out.println(listaStrings);
		return listaStrings;
	}

	private static boolean isAllUpperCase(String string) {
		// TODO Auto-generated method stub
		boolean isUpperCase = true;
		for(char c : string.toCharArray()) {
		    if(Character.isLetter(c) && !Character.isUpperCase(c)) {
		    	isUpperCase = false;
		        break;
		    }
		}
		return isUpperCase;
	}
	
	private static Integer nextUpperCaseLetter(String string, Integer index){
		String subString = (String) string.subSequence(index, string.length() - 1);
		int nextUpperCaseIndex = -1;
		for(int i = 0; i < subString.length(); i++) {
		    if(Character.isUpperCase(subString.charAt(i))) {
		    	nextUpperCaseIndex = i;
		        break;
		    }
		}
		return nextUpperCaseIndex;
	}
	
//	private static Integer nextLowerCaseLetter(String string, Integer index){
//		String subString = (String) string.subSequence(index, string.length() - 1);
//		int nextLowerCaseIndex = -1;
//		for(int i = 0; i < subString.length(); i++) {
//		    if(Character.isLowerCase(subString.charAt(i))) {
//		    	nextLowerCaseIndex = i;
//		        break;
//		    }
//		}
//		return nextLowerCaseIndex;
//	}

}
