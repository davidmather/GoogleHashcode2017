package hashcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class Hashcode {
	public static final Solutions Solution = new Solutions();
	public static final int BINSIZE = 13;
	//1000 1000 6 14
	//6 7 1 5
	public static void main(String[] args) throws IOException {

		 String originalInstanceData = new Instances().get();
		/*
		String[] Data = originalInstanceData.split("\r\n");
		String[] Output = new String[1000];
		
		for(int z = 0; z < 1000; z++){
			for(int i = 0; i < 1000; i ++){
				Output[z] = Output[z] + String.valueOf(Data[i].charAt(z));
			}
		}

		for(int j = 0; j < 1000; j++){
			for(int i = 0; i < 10; i ++){
				Output[j] = Output[j].replaceAll("MM", "M");
			}
			Output[j] = Output[j].replaceAll("null", "");
		}
		
		
		//calculate edge cases
		//store edge cases in String
		String edgeCases = "";
		System.out.println(Output[0]);
		for(int j = 0; j < 1000; j++){
			String[] DataTest = Output[j].split("M");
			for(int i = 0; i<DataTest.length; i = i + 1){
				if(DataTest[i].length()>13){
					edgeCases = edgeCases + String.valueOf(i) + " " + String.valueOf(j) + ",";
				}
			}
		}
		
		String[] edgeCaseArray = edgeCases.split(",");
		for(int i = 0; i < edgeCaseArray.length-1; i = i + 1){
			System.out.println(edgeCaseArray[i]);
		}
		*/
		
		Solution.setMode("Append");

	    ArrayList<String> EdgeCases = new ArrayList<String>();
		String Data = originalInstanceData.replaceAll("\r\n", "");
		for(int i = 0; i < 10; i ++){Data = Data.replaceAll("TT", "T");}
		String[] DataTest = Data.split("T");String temp = "";
		Data = originalInstanceData.replaceAll("\r\n", "");
		for(int i = 0, j = 0; i<DataTest.length; i = i + 1){
			if(DataTest[i].length()>13){
				temp = "T"+DataTest[i]+"T";
				EdgeCases.add("y:"+(Data.indexOf(DataTest[i])/1000) + ",x:"+(Data.indexOf(DataTest[i])%1000-1));
				EdgeCases.add("y:"+(Data.indexOf(DataTest[i])/1000) + ",x:"+(Data.indexOf(DataTest[i])%1000+temp.length()));
				
				Data = Data.replaceFirst(temp, temp.replaceAll("M", "@"));
			} j=j+1;
		}
		ArrayList<String> Matches = getMatches(Data);
		Matches.addAll(EdgeCases);
		Collections.sort(Matches);
		for(int i = 0; i < Matches.size(); i = i + 1){
			Solution.writeAnswer(Matches.get(i)+System.lineSeparator());
			if(i%10==0){
				System.gc();
			}
		}
		
		
		
		/*
		String[][] Data = convertToMultiDimensionalStringArray(originalInstanceData.split("\n"));
		
		
		System.out.println("Unsorted Data");
		for(int i = 0; i < Data.length; i = i + 1){
			System.out.println(Data[i][0] + "," + Data[i][1]);
		}
		
		Perfectsort.sortAscending(Data);
		
		System.out.println("Sorted Data");
		for(int i = 0; i < Data.length; i = i + 1){
			System.out.println(Data[i][0] + "," + Data[i][1]);
		}
		
		
		
		Binpack.packDescending(Data);
		System.out.println("Bin Packed");
		for(int i = 0; i < Data.length; i = i + 1){
			System.out.println(Data[i][0] + "," + Data[i][1]+ "," + Data[i][2]);
		}
		
		System.out.println("Number of bins used: "+ numberOfBins(Data));
				 * 
		 */
		
		//Solution.writeAnswer(Output);

	}

	public static ArrayList<String> getMatches(String Data){
		ArrayList<String> al = new ArrayList<String>();
		int index = Data.indexOf("M"), lastX = 0, lastY = 0;
		boolean placeholder;
		while (index >= 0) {
			placeholder = ((lastX+1) - index%1000) != 0;
			if(placeholder || ((index/1000)!= lastY)){
				al.add("y:" + String.valueOf(index/1000) + ",x:" + String.valueOf(index%1000));
			}
			
			lastY = index/1000;
			lastX = index%1000;
			index = Data.indexOf("M", index + 1);
		    if(lastX == 653 && lastY == 996){
		    	break;
		    }
		}
		return al;
	}
	

	
	public static int numberOfBins(String[][] multiDimensionalArray){
		int max  = Integer.MIN_VALUE;
		for (int i = 0; i < multiDimensionalArray.length; i++) {
		     if (Integer.parseInt(multiDimensionalArray[i][2]) > max) {
		         max = Integer.parseInt(multiDimensionalArray[i][2]);
		     }
		}
		return max;
	}
	
	public static int countOccurrences(String haystack, char needle)
	{
	    int count = 0;
	    for (int i=0; i < haystack.length(); i++)
	    {
	        if (haystack.charAt(i) == needle)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
	public static String[][] convertToMultiDimensionalStringArray(String[] array){
		int length = array.length;
		String[][] multiDimensionalArray = new String [length][3];
		for(int i = 0; i < array.length; i = i + 1){
			multiDimensionalArray[i][0] = array[i].replace("\n", "").replace("\r", "");
			multiDimensionalArray[i][1] = String.valueOf(i);
		}
		return multiDimensionalArray;		
	}
}
