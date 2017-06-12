import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class testClass {

	public static void main(String[] args) throws IOException {
			
		
		HashTable tempTable = new HashTable();
		
		tempTable.Add(new Entry("dude"));
		tempTable.Add(new Entry("halo"));
//		tempTable.Add(new Entry("woew"));
//		tempTable.Add(new Entry("mouse"));
		tempTable.Add(new Entry("test"));
//		tempTable.Add(new Entry("car"));
		tempTable.Add(new Entry("amazing"));
		tempTable.Add(new Entry("amazing"));
		tempTable.Add(new Entry("spongebob"));
		
		
		ArrayList list = new ArrayList();
		
		for(int i =0; i< tempTable.getCapacity(); i++){
			if(tempTable.getEntry(i) != null){
				list.add(tempTable.getEntry(i).getWord());
			}
		}
		

		Collections.sort(list);

		

		
//		System.out.println(tempTable);
		

	}
	
	


}
