
//Johnnie Baba
//CPE 103-07
//Assignment 5
public class HashTableSC<T> implements HashTable<T>, HashMetrics {
   private int size;
   private int tableSize;
   private long collisions;
   private int maxCollisions;
   private Object[] hashTable;
   private double loadFactor;
   
   
   private class Node {
      public Node next;
      public T e;
      public Node(T e) {
         this.next = null;
         this.e = e;
      }
   }
   
   public HashTableSC(int tableSize){
      hashTable = new Object[PrimeTools.nextPrime(tableSize)];
      this.tableSize = PrimeTools.nextPrime(tableSize);
     
   }
   
   
   
   public boolean contains(T element){
      int index = Math.abs(element.hashCode() % tableSize());
      if(hashTable[index] != null){
         @SuppressWarnings("unchecked")
         Node n = (Node)hashTable[index]; //might have  a run time exception because of casting from generic to generic
         while(n!= null){
            
            if(n.e.equals(element)){
               return true;
            }
            n = n.next;
         }
      }      
      
      return false;
   }
   
   
   public boolean add(T element){
      Node newNode = new Node(element);
      int index = Math.abs(element.hashCode() % tableSize());
      int tempMax = 0;
      if(hashTable[index] != null){
         @SuppressWarnings("unchecked")
         Node n = (Node)hashTable[index];
         collisions++;
         tempMax++;
         while(n.next!= null){
            collisions++;
            tempMax++;
            if(n.e.equals(element)){
               if(tempMax > maxCollisions()){
                  this.maxCollisions = tempMax;
               }
               return false;  //will it get here?
            }
            n = n.next;   
         }
         if(n.e.equals(element)){
            if(tempMax > maxCollisions()){

               this.maxCollisions = tempMax;
            }
            return false;  //will it get here?
         }
         if(tempMax > maxCollisions()){
            
            this.maxCollisions = tempMax;
         }
         n.next = newNode;
         size++;
      }else{
         hashTable[index] = newNode;
         size++;
      }
      

      
      return true;
   }
   
   @SuppressWarnings("unchecked")
   public boolean remove(T element){
      int index = Math.abs(element.hashCode() % tableSize());
      Node prev= new Node(null);
      if(hashTable[index] != null){
         Node n = (Node)hashTable[index];
         if(element.equals(((Node)hashTable[index]).e)){
            hashTable[index] = n.next;
            size--;
            return true;
         }
         while(n!= null){
            if(n.e.equals(element)){
               n = n.next;
               prev.next = n;
               size--;
               return true;
            }
            prev = n;
            n = n.next;
         }
      }
      return false;
   }
   
   public boolean isEmpty(){
      if(size == 0){
         return true;
      }
      
      return false;
   }
   
   public double loadFactor(){
      double sizer = size;
      return sizer/ tableSize;
   }
   
   
   
   public int tableSize(){
      return tableSize;
   }
   
   public int size(){
      return size;
   }
   
   public long collisions(){
      return collisions;
   }
   
   public int maxCollisions(){
      return maxCollisions;
   }
   
  
   
}
