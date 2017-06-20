
public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {
   
   public MorseOrder(MorseCode original){
      super(original);
   }
   
   public MorseOrder(Character character, String code){
      super(character, code);
   }
   
   public int compareTo(MorseOrder other){
      return this.getCode().compareTo(other.getCode());
   }
}
