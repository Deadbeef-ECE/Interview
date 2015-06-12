import java.util.HashSet;
import java.util.Set;

// array of strings "abc", "de", "fgh", 
// 然后search "de"是否在array of strings中。不许调用string.equal()或者==。
public class ContainStrings {
	public static boolean ifContainString(String[] stringArray, String s){
		if(stringArray.length == 0)
			return false;
		Set<String> set = new HashSet<String>();
		for(String str: stringArray){
			set.add(str);
		}
		if(set.contains(s)){
			System.out.println("^.^ Find string: "+s);
			return true;
		}
		System.out.println("@.@ Cannot find string: "+s);
		return false;
	}
	
	public static void main(String[] args){
		String[] stringArray = {"what", "the ", ""," fuck","??", "memeda"};
		String s = "";
		String s1 = "the";
		String s2 = " fuck";
		ifContainString(stringArray, s);
		ifContainString(stringArray, s1);
		ifContainString(stringArray, s2);
	}
}
