import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HashTableDriver {

	@SuppressWarnings("hiding")
	public static void main(String[] args) throws IOException {
		

		
		generateSimpleList();
		
		generateHashTable();
			
		}
	
	public static void generateSimpleList() throws IOException{
		getFile fileStuff = new getFile();
		
		BufferedReader reader;

		SimpleList SList = new SimpleList();
		FileWriter writer = new FileWriter(new File("SimpleList.txt"));
		
		long duration = 0;
		
		try{
			
			Instant start = Instant.now();
			
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileStuff.file)));
			while(reader.ready()){
				
				
				String temp[] = reader.readLine().split(" ");
				
				for(int v =0; v< temp.length; v++){
					
					temp[v] = temp[v].toLowerCase();
					
				}
				

				
				for(int i=0; i< temp.length; i++){
					int index = SList.find(temp[i]);

					
					if(index > 0){ //True if word already in SimpleList.
						Entry current = SList.getEntry(index);
						current.incrementCount();

						
					}
					else{
						SList.add(new Entry(temp[i]));
					}
				}
				
			}
			
			Instant end = Instant.now();
			
			duration = Duration.between(start, end).getSeconds();
			
			System.out.println("Simple List runtime: " +
					duration + " seconds");
	
			
		
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		writer.write("Hash Table runtime: " +
		duration + " seconds");
		writer.write("\r\n");
		
		ArrayList<Entry> list = new ArrayList<Entry>();
		
		for(int x=0; x<SList.size(); x++){
			list.add(SList.getEntry(x));
		}
		
		Collections.sort(list);
		
		for(int y=0; y< list.size(); y++){
			writer.write(list.get(y).getWord() + " :" + list.get(y).getCount());
			writer.write("\r\n");
		}
		
		writer.close();

		
	}
	
	public static void generateHashTable() throws IOException{
		
		getFile fileStuff = new getFile();
		
		HashTable HTable = new HashTable();
		
		BufferedReader reader;
		
		long duration = 0;

		FileWriter writer = new FileWriter(new File("HashTableList.txt"));
		
		
		
		try{
			
			Instant start = Instant.now();
			
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileStuff.file)));
			while(reader.ready()){
				
				
				String temp[] = reader.readLine().split(" ");
				
				for(int v =0; v< temp.length; v++){
					
					temp[v] = temp[v].toLowerCase();
					
				}
				

				
				
				for(int x=0; x< temp.length; x++){
					HTable.Add(new Entry(temp[x]));
				}

			}
			
			Instant end = Instant.now();
	
			duration = Duration.between(start, end).getSeconds();
			
			System.out.println("Hash Table runtime: " +
					duration + " seconds");
			
		
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		writer.write("Hash Table runtime: " +
		duration + " seconds");
		writer.write("\r\n");

		ArrayList<Entry> list = new ArrayList<Entry>();
		
		for(int x=0; x< HTable.getCapacity(); x++){
			if(HTable.getEntry(x) != null){
				list.add(HTable.getEntry(x));
			}
		}
		
		Collections.sort(list);
		
		for(int y=0; y< list.size(); y++){
			writer.write(list.get(y).getWord() + " :" + list.get(y).getCount());
			writer.write("\r\n");
		}

		writer.close();
		
	}
	
}


	

