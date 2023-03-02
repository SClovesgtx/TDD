import java.util.List;
import java.util.ArrayList;

public class QuebradorStringCamelCase {

	public static List<String> converterCamelCase(String string) {
		List<String> listaStrings = new ArrayList<String>();
		if (!isAllUpperCase(string))
			listaStrings.add(string.toLowerCase());
		else
			listaStrings.add(string);
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

}
