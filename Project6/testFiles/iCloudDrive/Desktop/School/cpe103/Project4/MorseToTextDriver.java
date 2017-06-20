/**
* JUnit tests for MorseToText
*
* @author Daniel Shu
* @version Project4 CPE103
*/

public class MorseToTextDriver {

	public static void main(String[] args) {
		MorseToText m = new MorseToText();
		System.out.println(m.translate("---- ---- -... ---- ---- ..- ----.- ---- "));
		System.out.println(m.translate("---- ---- ---- ..... ---- .---"));
		System.out.println(m.translate(".-  ......--.-.-  .-"));


	}

}