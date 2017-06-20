/**
* Driver for BST
*
* @author Daniel Shu
* @version Project4 CPE103
*/
import java.util.Iterator;

public class BSTDriver {

	public static void main(String[] args) {
		// BST<Integer> bst = new BST<Integer>();
		// bst.insert(10);
		// bst.insert(5);
		// bst.insert(15);
		// // System.out.println(bst.get(10));
		// Iterator<Integer> it = bst.iterator();
		// System.out.println(it.next());
		// System.out.println(it.next());
		// System.out.println(it.next());
		MorseToText translator = new MorseToText();

		String text = translator.translate(".........");
		System.out.println(text);

		TextToMorse translator2 = new TextToMorse();

		String code = translator2.translate("5");
		System.out.println(code);
	}

}