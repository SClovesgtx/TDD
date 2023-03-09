import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class QuebradorStringCamelCase {

	public static List<String> converterCamelCase(String string) {
		List<String> listaStrings = new ArrayList<String>();
		Integer firstNextUpperCaseIndex = nextUpperCaseLetter(string, 0);
		Integer secondNextUpperCaseIndex = nextUpperCaseLetter(string, 1);
		if (stringIsOneWord(string, firstNextUpperCaseIndex, secondNextUpperCaseIndex)) 
			listaStrings.add(isAllUpperCase(string) ? string : string.toLowerCase());
		else {
			Integer index = firstNextUpperCaseIndex > 0 ? firstNextUpperCaseIndex : secondNextUpperCaseIndex;
			HashMap<String, String> splitedString = splitString(string, index);
			listaStrings.add(splitedString.get("word"));
			listaStrings.addAll(converterCamelCase(splitedString.get("remaining")));
		}
		return listaStrings;
	}
	
	private static Boolean stringIsOneWord(String string, Integer firstNextUpperCaseIndex, Integer secondNextUpperCaseIndex) {
		Boolean itIs = false;
		if (isAllUpperCase(string)) itIs = true;
		else if (firstNextUpperCaseIndex == -1) itIs = true;
		else if (firstNextUpperCaseIndex == 0 & secondNextUpperCaseIndex == -1) itIs = true;
		return itIs;
	}
	
	private static HashMap<String, String> splitString(String string, Integer index){
		HashMap<String, String> splitedString = new HashMap<String, String>();
		String word = (String) string.subSequence(0, index);
		String remaining = (String) string.subSequence(index, string.length());
		if (!isAllUpperCase(word)) word = word.toLowerCase();
		splitedString.put("word", word);
		splitedString.put("remaining", remaining);
		return splitedString;
	}

	private static boolean isAllUpperCase(String string) {
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
		int nextUpperCaseIndex = -1;
		for(int i = index; i < string.length(); i++) {
		    if(Character.isUpperCase(string.charAt(i))) {
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
