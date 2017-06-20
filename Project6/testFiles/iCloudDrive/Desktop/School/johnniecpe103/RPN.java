//Johnnie Baba
//CPE 103-07
//Description: this program will evaluate reverse polish notation (RPN) equations, convert infix equations to
//RPN equations, and evaluate infix equations

import java.util.Scanner;
public class RPN {
   
   
   public static double evaluateInfix(String infix){
      String expression = RPN.toRPN(infix);  //use the toRPN method to get an RPN expression
      return RPN.evaluateRPN(expression);
      
   }
   //Evaluates the given infix expression.
   
   public static double evaluateRPN(String expression){
      SimpleLinkedStack<Double> rpnStack = new SimpleLinkedStack<Double>(); 
      Scanner scan = new Scanner(expression);
      for(int i = 0; scan.hasNext(); i++){  //as long as there is something to scan
         if(scan.hasNextDouble()){
            rpnStack.push(Double.parseDouble(scan.next()));  //push the string input
         }else{
            switch(scan.next()){                            //switch cases to check for the operation
            case "+":
               double second = rpnStack.pop();
               double first = rpnStack.pop();
               double result = first + second;
               rpnStack.push(result);
               break;
            case "-":
               second = rpnStack.pop();
               first = rpnStack.pop();
               result = first - second;
               rpnStack.push(result);
               break;
            case "*":
               second = rpnStack.pop();
               first = rpnStack.pop();
               result = first * second;
               rpnStack.push(result);
               break; 
            case "/":
               second = rpnStack.pop();
               first = rpnStack.pop();
               result = first / second;
               rpnStack.push(result);
               break;
            default:
               break;  
            }
         }
         
      }
    
      
      return rpnStack.pop();
      
   }
   //Evaluates the given RPN expression.
   
   public static String toRPN(String infix){
      SimpleLinkedStack<String> opStack = new SimpleLinkedStack<String>(); 
      Scanner scan = new Scanner(infix);
      String rpn = "";
      for(int i = 0; scan.hasNext(); i++){  //as long as there is something to scan
         if(scan.hasNextDouble() || scan.hasNextInt()){
            rpn+= scan.next() + " ";  //push the string input
         }else{
            String next = scan.next();
            if(next.equals("*") || next.equals("/") ){ //if the string is the multiply or divide
               
               if(opStack.size() == 0){
                  opStack.push(next);
               }else if(opStack.peek().equals( "+") || opStack.peek().equals( "-") || opStack.peek().equals("(")){ //if the top of the stack has lower precedence
                  opStack.push(next);
               }else{  //if the top of the stack is also multiplication or division
                  rpn += opStack.pop() + " ";                  
                  opStack.push(next);
               }  
            }
            else if(next.equals("+") || next.equals("-") ){ //if the string is addition or subtraction
               
               if(opStack.size() == 0){ //if the stack is empty push it
                  opStack.push(next);
               }else if(opStack.peek().equals("(")){ //if the top is an opening parenthesis push it
                  opStack.push(next);
               }else{
                  while(opStack.size() > 0 && !opStack.peek().equals("(")){  //if there are any elements
                     if(!opStack.peek().equals("(")){ //if the top is a p
                        rpn += opStack.pop() + " ";   //pop all of the operators and append them
                     }
                  }
                  opStack.push(next);

               }
                     
            }else if(next.equals("(")){ //if there is an opening parenthesis
               opStack.push(next);
            }else if(next.equals(")")){ //if there is a closing parenthesis
               while(opStack.size() > 0 && !opStack.peek().equals("(")){ //while the top of the stack isn't an opening parenthesis
                  rpn += opStack.pop() + " "; //pop every operator and append it to the rpn expression
               }
               opStack.pop(); //this will pop the top of the stack which should be the "("
            }else{ //if there are only numbers
               rpn +=next + " ";
            }
         }  
      } 
      
      while(opStack.size() > 0){ //while there are still operators in the stack
         if(opStack.size() == 1){
            rpn+=opStack.pop();
         }else{
            rpn += opStack.pop() + " ";
         }
         
      }
      if(rpn.charAt(rpn.length() - 1) == ' '){
         return rpn.substring(0, rpn.length()-1);
      }
      
      return rpn;
     
   }
   //Converts the given infix expression to reverse polish notation.

   
}
