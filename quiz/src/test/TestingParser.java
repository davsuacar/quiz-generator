package test;

import java.io.IOException;

import input.Parser;

import javax.swing.JOptionPane;

import output.OutPut;
import algorithm.ExamGenerator;
import beans.Exam;

public class TestingParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Parser test = new Parser("C:\\XML_EntryFile.xml");
		ExamGenerator test2 = new ExamGenerator(new Exam(test.getQuestions()), 6);
		OutPut out = new OutPut(test2);

		out.generateHTML();
		out.generateHTML2();

		try{
			
            Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe "+"C:\\Users\\Salva\\Workspace\\ACSE\\reporte.html");
            Process p2 = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe "+"C:\\Users\\Salva\\Workspace\\ACSE\\reporte2.html");

		} catch(IOException e1){
			System.out.print(e1.toString());
		} 
	}

}
