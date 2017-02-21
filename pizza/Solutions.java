package hashcode;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Solutions {
	
	private ClassLoader loader;
	private String filename,classname,cwd,location,projectname;
	private URL classUrl;
	private boolean append = false;
	
	public Solutions(){
		this.loader = Instances.class.getClassLoader();
		this.filename = "sol_instances.txt";
		this.classname = "Solutions.class";
		this.projectname = "hashcode";
		this.classUrl = loader.getResource(this.projectname + "/" + this.classname);
		this.cwd = classUrl.getPath().replace(this.classname, "").replace("bin", "src").replaceAll("//", "\\").replaceAll("%20", " ").substring(1);		
		this.location = this.cwd + this.filename;
		this.append = false;
	}
	
	/*
	 * Simple FileWriter Class 
	 */
	public void writeAnswer(String text){
		try {
			FileWriter fstream = new FileWriter(this.location,this.append); 
		    fstream.write(text);
		    fstream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean getMode(){
		return this.append;
	}
	
	public void setMode(String Mode){
		switch(Mode){
			case "Append":
				this.append = true;
				break;
			case "Write":
				this.append = false;
				break;
		}
	}
	
	public void setRelativeFileLocation(String inputLocation){
		this.location = this.cwd + inputLocation;
	}
	
	public void setAbsoluteFileLocation(String inputLocation){
		this.location = inputLocation;
	}
	
	public String getLocation(){
		return this.location;
	}
}
