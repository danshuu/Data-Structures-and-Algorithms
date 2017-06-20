import java.util.*;
import java.io.*;
import java.lang.*;
//Johnnie Baba
//CPE 103-07
//Assignment 5
public class SpellChecker {
   private HashTableSC<String> spellTable;

   public class MyStats{
      public int occurs;
      public List<Integer> list = new ArrayList<Integer>();
      public String word;
      public boolean isWord;

      public MyStats(String word, boolean isWord, int line){
         this.word = word;
         this.isWord = isWord;
         occurs = 1;
         list.add(line);
      }
      public int getOccurrences(){
         return occurs;
      }

      public List<Integer>getLineNumbers(){
         return list;
      }

      public boolean isWord(){
         return isWord;
      }

   }

   public SpellChecker()throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      spellTable = new HashTableSC<String>(267119);
      while(s.hasNext()){
         spellTable.add(s.next());
      }
   }

   public SpellChecker(String fileName)throws FileNotFoundException{
      Scanner s = new Scanner(new File(fileName));
      spellTable = new HashTableSC<String>(267119);
      while(s.hasNext()){
         spellTable.add(s.next());
      }
   }

   public boolean isWord(String s){
      if(spellTable.contains(s) || spellTable.contains(s.toLowerCase())){
         return true;
      }
      return false;
   }

   public HashTableSC<String> getDictionary(){
      return spellTable;
   }

   @SuppressWarnings("unchecked")
   public HashMap<String,SpellChecker.MyStats> processFile(String fileName) throws FileNotFoundException{
      Scanner s = new Scanner(fileName);
      HashMap hasher = new HashMap();
      int ln = 0;
      while(s.hasNextLine()){
         String str = s.nextLine();
         Scanner sc = new Scanner(str).useDelimiter("[^\\w-']");
         ln++;
         if(hasher.get(str) != null){
            MyStats ms = ((MyStats)hasher.get(str));
            ms.occurs++;
            ms.list.add(ln);
         }
         else{
            hasher.put(str, new MyStats(str, this.isWord(str), ln));
         }
      }
      return hasher;

   }


}
