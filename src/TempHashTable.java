import java.util.Arrays;

public class TempHashTable {

    private Entry[] entries;
	
	private int Capacity = 10;
    
    private int size; //# of elements in HashTable
    
    private double LoadFactor;
    
    
//    public int index;
    
    public TempHashTable(){
    	this.entries = new Entry[Capacity];
    	this.size = 0;
    	
    	for(int i=0; i< Capacity; i++){
    		entries[i] = null;
    	}
    	
    	
    	LoadFactor = ((double) size / (double) Capacity);
    }

	public void add(Entry e){
		
    	if(LoadFactor >= 0.4){
		resize();
		
		LoadFactor = ((double) size / (double) Capacity);
    	}
		
		if(size < 1){
			this.entries[e.uniqueID % Capacity] = e;
		}
		
		else{
			//check for collision
			
			int hashcode = e.uniqueID;
			int index = hashcode % Capacity;
			String word = e.getWord();
			
			if(entries[index] != null && word.equals(entries[index].getWord())){//hashcode and words match. increment
				
				entries[index].incrementCount();
			}
			
			else if(entries[index] !=null && !word.equals(entries[index].getWord())){ //collision

				//probing

				int collisionCount =0;
				while(entries[index] != null)
				{
					index = quadraticProbing(index, collisionCount);
					collisionCount++;

				}
				
				entries[index] = e; //added in new index
			}
			
			else{
				this.entries[e.uniqueID % Capacity] = e;
			}
		}
		
		this.size++;
    	LoadFactor = ((double) size / (double) Capacity);
		
		

	}
	
	 public int quadraticProbing(int index, int count){
		 
		 int newIndex = (index + (int) Math.pow(count, 2)) % Capacity;
		 
		 newIndex = Math.abs(newIndex);
		 
		 return newIndex;
	 }
	
	
	
	public void resize(){
       
		Entry[] newList = new Entry[entries.length * 2 + 1];
		
		
    	if(size > 0){
    		for (int i = 0 ; i < Capacity ; i++) {

    			if(entries[i] != null){
    				
    				int newIndex = entries[i].uniqueID % newList.length; //Rehashing
    	               newList[newIndex] = this.entries[i];
    	               newList[newIndex].uniqueID = newList[newIndex].uniqueID % newList.length;
    			}
    				
 
            }
    	}
    	

        this.entries = newList;
        this.Capacity = newList.length;
	}
	
	public int getSize() {
        return this.Capacity;
    }
	
	public Entry getEntry(int index){
		return entries[index];
	}
	
	@Override
	public String toString() {
		return "TempHashTable [entries=" + Arrays.toString(entries) + ", Capacity=" + Capacity + ", size=" + size
				+ ", LoadFactor=" + LoadFactor + "]";
	}

    
    
	
}
