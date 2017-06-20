
public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {
   
   public CharacterOrder(MorseCode original){
      super(original);
   }
   
   public CharacterOrder(Character character, String code){
      super(character, code);
   }
   
   public int compareTo(CharacterOrder other){
      return this.getCharacter().compareTo(other.getCharacter());
   }

}
