/**
 * Interface for BSTTranslator
 * 
 * @author Daniel Shu
 * @version Project 4 CPE103
 */

public interface BSTTranslator<T extends Comparable<? super T>> {
	BST<T> getBST();

	String translate(String s);
}