import java.util.List;
import java.util.ArrayList;

public class QuebradorStringCamelCase {

	public static List<String> converterCamelCase(String string) {
		List<String> listaStrings = new ArrayList<String>();
		int previous = 0;
		while (nextUpperCaseLetter(string, previous) != -1) {
			int index = nextUpperCaseLetter(string, previous);
			if (index > previous) {
				String word = string.substring(previous, index);
				if (!isAllUpperCase(word))
					word = word.toLowerCase();
				listaStrings.add(word);
				previous = index;
			}
		}
		if (listaStrings.size()==0) {
			if (!isAllUpperCase(string))
				listaStrings.add(string.toLowerCase());
			else
				listaStrings.add(string);
		}
		return listaStrings;
	}

	private static boolean isAllUpperCase(String string) {
		// TODO Auto-generated method stub
		boolean ok = true;
		for(char c : string.toCharArray()) {
		    if(Character.isLetter(c) && !Character.isUpperCase(c)) {
		        ok = false;
		        break;
		    }
		}
		return ok;
	}
	
	private static int nextUpperCaseLetter(String string, int index){
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

}
