import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TextToMorse implements BSTTranslator<CharacterOrder> {
   private BST<CharacterOrder> charBST;
   
   //constructs the bst
   public TextToMorse(){
      charBST = new BST<CharacterOrder>();
      CharacterOrder[] charArr = new CharacterOrder[MorseCode.size()];
      for(int i = 0; i< MorseCode.size(); i++){
         charArr[i]= new CharacterOrder(MorseCode.get(i));
         
      }
      
      Arrays.sort(charArr);
      this.treeMake(charArr, 0, charArr.length);
   }
   
   
   public BST<CharacterOrder> getBST(){
      return charBST;
   }
   
   public String translate(String s){
      StringBuilder sb = new StringBuilder();
      char[] characters = s.toCharArray(); //turn the string word into an array of individual characters
      for(char letter: characters){
         try{
            CharacterOrder toTranslate = new CharacterOrder(letter, "/"); //turn elements in the string into a MorseOrder object
            CharacterOrder found = charBST.get(toTranslate); //find it within the bst
            sb.append(found.getCode()); //append the corresponding character into the StringBuilder 
            sb.append(" ");
         }catch(NoSuchElementException ex){
            sb.append(" ");
         }
      }
      return sb.toString().trim();
   }
   
   private void treeMake(CharacterOrder[] arr, int start, int end){
      if(start < end){
         charBST.insert(arr[(start+end)/2]); //insert the middle element
         treeMake(arr, start, ((start+ end)/2 )); //now recursively go to the left half and insert the middle of the left half         
         treeMake(arr, ((start + end) / 2) + 1 , end ); //now recursively go to the right half and insert the middle of the right half
      }
   }
   
   
   
   

}
