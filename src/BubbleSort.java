/*Gilberto Placidon
 * CS 2013
 */



public class BubbleSort<T extends Comparable<T>>{ 
	long swapCount =0;
	long comparisonCount =0;
	
	T[] list;
	
	public BubbleSort(T[] a){
		this.list = a;
	}
	
	//Bubble Sort Algorithm 
	public T[] sort(){ 
		
		for(int i=1; i < list.length -1; i++){
			
			for(int j=0; j < list.length -2; j++){
				
				comparisonCount++;
				
				if((list[j]).compareTo((list[j+1])) < 0){					

					swap(list, j, j+1);
					
					swapCount++;

				}
			}
		}

		
		return list;
	}
	
	public void swap(T[] list, int sourceIndex, int destIndex){
		T temp = list[destIndex];
		list[destIndex] = list[sourceIndex];
		list[sourceIndex] = temp;
	}


	
	
}
