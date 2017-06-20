import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MorseToText implements BSTTranslator<MorseOrder>{
   private BST<MorseOrder> morseBST;
   
   //constructs the bst
   public MorseToText(){
     morseBST = new BST<MorseOrder>();
     MorseOrder[] moArr = new MorseOrder[MorseCode.size()];
     for(int i = 0; i < MorseCode.size(); i++){
        moArr[i] = new MorseOrder(MorseCode.get(i));
     }
     Arrays.sort(moArr);
     treeMake(moArr, 0, moArr.length);

   }
   
   public BST<MorseOrder> getBST() {
      return morseBST;
   }

   
   public String translate(String s) {
      StringBuilder sb = new StringBuilder(); //build a string for better efficiency
      Scanner sc = new Scanner(s).useDelimiter(" "); //array of morse code strings that need to change to morse order objects
      
      while( sc.hasNext() ){
         try{
            MorseOrder toTranslate = new MorseOrder('&',sc.next()); //turn the morse code string into a MorseOrder object
            char found = morseBST.get(toTranslate).getCharacter(); //find it within the morse order bst which will have the corresponding character
            sb.append(found); //append the corresponding character into the StringBuilder 
         }catch(NoSuchElementException ex){
            sb.append(" ");
         }
      }
      
      return sb.toString();
   }
   
   
   //This method will take the sorted array and make a BST out of it by taking the middle and inserting it into the BST
   private void treeMake(MorseOrder[] arr ,int start, int end){
      if(start < end){
         morseBST.insert(arr[(start + end)/2]); //insert the middle element
         treeMake(arr, start, ((start+ end)/2 )); //now recursively go to the left half and insert the middle of the left half         
         treeMake(arr, ((start + end) / 2) + 1 , end ); //now recursively go to the right half and insert the middle of the right half
      }
      
      
      
   }

}
