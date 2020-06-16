package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  System.out.println(f.getAbsolutePath());
				}
			}
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
		 File[] files = new File("src//").listFiles();
		 addcopyright(files);	
		 }

	private static void addcopyright(File[] files) {
		// TODO Auto-generated method stub
		  for (File file : files) {
		        if (file.isDirectory()) {
		            System.out.println("Directory: " + file.getName());
		            addcopyright(file.listFiles()); // Calls same method again.
		        } else if(file.getName().contains(".java")) {
		            System.out.println("File: " + file.getName());
		            try {
		            	FileWriter fw = new FileWriter(file, true);
		            	 PrintWriter printWriter = new PrintWriter(fw);
		            	    printWriter.println("//Copyright © 2020 Max Fang");  //New line
		            	    printWriter.close();
		            } catch(IOException e) {
		            	e.printStackTrace();
		            }
		        }
		    }
	}
	
	
	
	
	
	
}

//Copyright © 2020 Max Fang
