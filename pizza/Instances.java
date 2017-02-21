package hashcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Instances {
	private ClassLoader loader;
	private String filename,data,classname,dataFirstLine,cwd,location,projectname;
	private URL classUrl;
	private String[] dataFirstLineCsv,dataFirstLineArray,dataArray;
	
	
	public Instances(){
		this.loader = Instances.class.getClassLoader();
		this.filename = "big.in";
		this.classname = "Instances.class";
		this.projectname = "hashcode";
		this.classUrl = loader.getResource(this.projectname + "/" + this.classname);
		this.cwd = classUrl.getPath().replace(this.classname, "").replace("bin", "src").replaceAll("//", "\\").replaceAll("%20", " ").substring(1);		
		this.location = this.cwd + this.filename;
		this.data = readFileContents();
		this.dataArray = this.data.split("\n");
		this.dataFirstLine = this.dataArray[0];
		this.dataFirstLineCsv = this.dataArray[0].split(",");
		this.dataFirstLineArray = this.dataArray[0].split("\\s");
	}	
	
	/*
	 * Simple FileReader Class 
	 */
	private final String readFileContents(){
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = null;
		try {
			reader = new BufferedReader(
			        new FileReader(this.location));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        char[] buf = new char[1024];
        int numRead=0;
        try {
			while((numRead=reader.read(buf)) != -1){
			    String readData = String.valueOf(buf, 0, numRead);
			    fileData.append(readData);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fileData.toString();
	}
	
	public String get(){
		return this.data;
	}
	
	public void set(String input){
		this.data = input;
	}
	
	public String getFirstLine(){
		return this.dataFirstLine;
	}
	
	public void getFirstLine(String input){
		this.dataFirstLine = input;
	}
	
	public String[] getFirstLineCSV(){
		return this.dataFirstLineCsv;
	}
	
	public void setFirstLineCSV(String[] input){
		this.dataFirstLineCsv = input;
	}
	
	public String[] getFirstLineArray(){
		return this.dataFirstLineArray;
	}
	
	public void setFirstLineArray(String[] input){
		this.dataFirstLineArray = input;
	}
}
