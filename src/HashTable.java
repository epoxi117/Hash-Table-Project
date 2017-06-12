import java.util.Arrays;
import java.util.Comparator;

public class HashTable {

    private Entry[] entries;
	
	private int Capacity = 11;
    
    private int size; //# of elements in HashTable
    
    private double LoadFactor;
    
    
    public HashTable(){
    	this.entries = new Entry[Capacity];
    	this.size = 0;
    	
    	for(int i=0; i< Capacity; i++){
    		entries[i] = null;
    	}
    	
    	
    	LoadFactor = ((double) size / (double) Capacity);
    }
    

	protected void Add(Entry current){
		
		
		int index = current.uniqueID % Capacity;
    	
    	
    	
    	if(this.size < 1){
    		entries[index] = current;
        	this.size++;
    		
    	}
    	
    	else{
    		
    			//increment count
    			if(entries[index] != null && current.getWord().equals(entries[index].getWord())){
	   				entries[index].incrementCount();
    				
    				
    			}
    			//collision
    			else if(entries[index] != null && !current.getWord().equals(entries[index].getWord())){

    				
    				boolean flag = false;
    				int newIndex = index;
    				
    				
    				//linear probing
    				while(!flag){
    					newIndex++;
    					newIndex = newIndex % Capacity;

    					if(entries[newIndex] != null && current.getWord().equals(entries[newIndex].getWord())){

    		   				entries[newIndex].incrementCount();
    		   				flag = true;
    					}
    					
    					else{
    						flag = true;
    	    				entries[newIndex] = current;
    	    		    	this.size++;
    					}
    				}
    				

    				
    				
    			}
    			   		
    		
    		//add unique word
    		else{
        		entries[index] = current;
            	this.size++;
    		}
    		
    	}
    	

    	
    	LoadFactor = ((double) this.size / (double) this.Capacity);
    	
    	if(LoadFactor >= 0.5){
    		resize();
    		
    		LoadFactor = ((double) size / (double) Capacity);
        	}
		

	}
	
	private void resize(){
		Entry[] newList = new Entry[getNextPrime(entries.length * 2)];
		
		int BiggerSize = newList.length;
		
		//keep saved copy of entries
		Entry[] tempEntries = entries;
		
		
		//entries now empty and resized for newList.
		//Capacity is also updated for newList.
		//reset size for newList.
		entries = newList;
		Capacity = BiggerSize;
		size =0;
		
		for(int i =0; i< tempEntries.length; i++){
			
			if(tempEntries[i] != null){

				//check for collisions while rehashing.
				
				//Add is required in order to check for duplicates while adding.
				Add(tempEntries[i]);
	               
			}
			
		}
		
	}
	
	//helper method for returning prime number.
	private boolean isPrime(int number){
		if(number % 2 == 0){
			return false;
		}
		
		for(int i=3; i*i <= number; i+=2){
			
			if(number % i == 0){
				return false;
			}
		}
		
		return true;
		
	}
	
	//returns prime number
	private int getNextPrime(int minNumberToCheck){
		for(int i= minNumberToCheck; true; i++){
			if (isPrime(i)){
				return i;
			}
		}
	}
	
	
	public int getSize() {
        return this.Capacity;
    }
	
	public Entry getEntry(int index){
		return this.entries[index];
	}
	
	public int getCapacity(){
		return this.Capacity;
	}
	
	@Override
	public String toString() {
		return "TempHashTable [entries=" + Arrays.toString(entries) + ", Capacity=" + Capacity + ", size=" + size
				+ ", LoadFactor=" + LoadFactor + "]";
	}

    
    
	
}
