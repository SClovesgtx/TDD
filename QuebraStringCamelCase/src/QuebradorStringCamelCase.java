import java.util.List;
import java.util.ArrayList;

public class QuebradorStringCamelCase {

	public static List<String> converterCamelCase(String string) {
		List<String> listaStrings = new ArrayList<String>();
		Integer firstNextUpperCaseIndex = nextUpperCaseLetter(string, 0);
		Integer secondNextUpperCaseIndex = nextUpperCaseLetter(string, 1);
		if (isAllUpperCase(string) || firstNextUpperCaseIndex == -1) {
			listaStrings.add(string);
			return listaStrings;
		}
		else if (firstNextUpperCaseIndex == 0 & secondNextUpperCaseIndex == -1) {
			listaStrings.add(string.toLowerCase());
			return listaStrings;
		}
		else if (firstNextUpperCaseIndex > 0){
			String word = (String) string.subSequence(0, firstNextUpperCaseIndex);
			String rest = (String) string.subSequence(firstNextUpperCaseIndex, string.length());
			if (isAllUpperCase(word)) listaStrings.add(word);
			else listaStrings.add(word.toLowerCase());
			listaStrings.addAll(converterCamelCase(rest));
		}
		else if (firstNextUpperCaseIndex < secondNextUpperCaseIndex){
			String word = (String) string.subSequence(0, secondNextUpperCaseIndex);
			String rest = (String) string.subSequence(secondNextUpperCaseIndex, string.length());
			if (isAllUpperCase(word)) listaStrings.add(word);
			else listaStrings.add(word.toLowerCase());
			listaStrings.addAll(converterCamelCase(rest));
		}
		return listaStrings;
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
