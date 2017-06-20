
public interface BSTTranslator<T extends Comparable<? super T>> {
   
   BST<T> getBST();
   String translate(String s);

}
