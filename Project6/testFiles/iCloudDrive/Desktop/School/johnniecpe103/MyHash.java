//Johnnie Baba
//CPE 103-07
//Lab 09
public class MyHash implements Hashable<String>{
   
   public MyHash(){
      
   }
   
   public int hash(String s){
      int myHashValue = 0;
      int leg = s.length();
      for (int i = 0; i < leg; i++) {
         myHashValue = myHashValue * (21 ^ (s.charAt(i)%3))  + s.charAt(i);
      }
      return myHashValue;
   }

}
