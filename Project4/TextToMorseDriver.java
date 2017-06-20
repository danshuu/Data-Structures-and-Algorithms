/**
* Driver for TextToMorse
*
* @author Daniel Shu
* @version Project4 CPE103
*/

public class TextToMorseDriver {

	public static void main(String[] args) {
		TextToMorse m = new TextToMorse();
		System.out.println(m.translate("abcde"));
		System.out.println(m.translate("a@"));
		System.out.println(m.translate("   .  @ "));


	}

}