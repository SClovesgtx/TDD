import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class QuebradorStringCamelCase {
	
	private static List<String> abreviations = Arrays.asList("CPF", "CNPJ", "CEP");
	
	public static List<String> converterCamelCase(String string) {
		List<String> listaStrings = new ArrayList<String>();
		Integer firstUpperCaseIndex = nextUpperCaseLetter(string, 0);
		Integer secondUpperCaseIndex = nextUpperCaseLetter(string, 1);
		checkIsValidString(string);
		if (stringIsOneWord(string, firstUpperCaseIndex, secondUpperCaseIndex)) 
			listaStrings.add(isAllUpperCase(string) ? string : string.toLowerCase());
		else {		
			Integer index = firstUpperCaseIndex > 0 ? firstUpperCaseIndex : secondUpperCaseIndex;
			HashMap<String, String> splitedString = splitString(string, index);
			listaStrings.add(splitedString.get("word"));
			listaStrings.addAll(converterCamelCase(splitedString.get("remaining")));
		}
		return listaStrings;
	}
	
	static void checkIsValidString(String string) {
		if (Character.isDigit(string.charAt(0))) throw new StringInvalida("não deve começar com números");
		else if (containSpecialCharacters(string)) throw new StringInvalida("caracteres especiais não são permitidos, somente letras e números");
	}
	
	private static boolean containSpecialCharacters(String string) {
		boolean itContains = !string.matches("[a-zA-Z0-9]*");
		return itContains;
	
	}

	private static Boolean stringIsOneWord(String string, Integer firstUpperCaseIndex, Integer secondUpperCaseIndex) {
		Boolean itIs = false;
		if (isAllUpperCase(string)) itIs = true;
		else if (firstUpperCaseIndex == -1) itIs = true;
		else if (firstUpperCaseIndex == 0 & secondUpperCaseIndex == -1) itIs = true;
		return itIs;
	}
	
	private static HashMap<String, String> splitString(String string, Integer index){
		HashMap<String, String> splitedString = new HashMap<String, String>();
		for (String abreviation: abreviations)
			if (string.indexOf(abreviation) == 0) index = abreviation.length();
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

}
