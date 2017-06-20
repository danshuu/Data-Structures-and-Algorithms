
public class BSC {
   
   
   
   
   public static boolean isBalanced(String s){
      SimpleArrayStack<Character> balanStr = new SimpleArrayStack<Character>();
      
      for(int i = 0; i< s.length(); i++){
         switch(s.charAt(i)){
         case '(':
            char openSymbolOne = s.charAt(i);
            balanStr.push(openSymbolOne);
            break;
         case'[':
            char openSymbolTwo = s.charAt(i);
            balanStr.push(openSymbolTwo);
            break;
         case'{':
            char openSymbolThree = s.charAt(i);
            balanStr.push(openSymbolThree);
            break;
         case'<':
            char openSymbolFour = s.charAt(i);
            balanStr.push(openSymbolFour);
            break;
         case')':
            if(balanStr.size()!= 0){
               if(balanStr.pop() != '('){
                  return false;
               }
            }else{
               return false;
            }
            break;
         case']':
            if(balanStr.size()!= 0){
               if(balanStr.pop() != '['){
                  return false;
               }
            }else{
                  return false;
               }
            break;
         case'}':
            if(balanStr.size()!= 0){
               if(balanStr.pop() != '{'){
                  return false;
               }
            }else{
               return false;
            }               
            break;
         case'>':
            if(balanStr.size()!= 0){
               if(balanStr.pop() != '<'){
                  return false;
               }
            }else{
               return false;
            }
            break;
         default:
            break;
         }
            
      }
     
         
      if(balanStr.size() == 0){
         return true;
      }else{
         return false;
      }
   }

}
