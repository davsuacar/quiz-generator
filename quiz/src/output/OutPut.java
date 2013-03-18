package output;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Random;

import algorithm.ExamGenerator;
import beans.Answer;
import beans.Exam;
import beans.Question;

public class OutPut {

	private ExamGenerator exams;

	public OutPut(ExamGenerator exams) {
		super();
		this.exams = exams;
	}

	public ExamGenerator getExams() {
		return exams;
	}

	public void setExams(ExamGenerator exams) {
		this.exams = exams;
	}

	public void generateHTML() {

		try {
			FileWriter archivo = new FileWriter("reporte.html");

			PrintWriter escritura = new PrintWriter(archivo);

			// we write the main structure a HTML file

			escritura
					.println("<html lang='en'><head><meta charset='utf-8' /><!-- Always force latest IE rendering engine (even in intranet) & Chrome FrameRemove this if you use the .htaccess --><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' /><title>Exams</title><meta name='description' content='' /><meta name='author' content='DAVID' /><meta name='viewport' content='width=device-width; initial-scale=1.0' />		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references --><link rel='shortcut icon' href='/favicon.ico' /><link rel='apple-touch-icon' href='/apple-touch-icon.png' /></head>");
			escritura.println(" <body>");

			Integer i = 0;
			for (Exam e : this.exams.getExams()) {
				
				//TEACHER COPY

				escritura.println(" <div>");
				escritura.println(" <header>");

				escritura.println(" <h1><center>Exam</center></h1>");
				escritura.println(" <h6><center>Serial: " + i
						+ "</center></h6>");
				escritura.println(" </header>");
				escritura.println(" <div>");
				escritura.println(" <nav>");
				i++;
				for (Question aux : e.getQuestions()) {

					escritura.println("<h2>" + aux.getWording() + "</h2>");
					if (aux.getAnswers() != null) {
						for (Answer ans : aux.getAnswers()) {
							if(ans.isFalse()==false){
								escritura.println("<p><ins>" + ans.getSentence() + "</ins></p>");	
							}else{
							escritura.println("<p>" + ans.getSentence() + "</p>");
							}
						}
						
					}else{
						escritura.println("<br>");
						escritura.println("<br>");
						escritura.println("<br>");
						escritura.println("<br>");
						
						
						
					}
					escritura.println(" <hr>");

				}
				escritura.println(" </nav>");
				escritura.println(" </div>");
				escritura.println(" </div>");
				

			}//end exam

			escritura.println(" </body>");
			escritura.println("</html>");

			// to be sure we close the file
			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void generateHTML2() {

		try {
			FileWriter archivo = new FileWriter("reporte2.html");

			PrintWriter escritura = new PrintWriter(archivo);

			// escribimos un archivo de texto con la estructura de html

			escritura
					.println("<html lang='en'><head><meta charset='utf-8' /><!-- Always force latest IE rendering engine (even in intranet) & Chrome FrameRemove this if you use the .htaccess --><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' /><title>Exams</title><meta name='description' content='' /><meta name='author' content='DAVID' /><meta name='viewport' content='width=device-width; initial-scale=1.0' />		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references --><link rel='shortcut icon' href='/favicon.ico' /><link rel='apple-touch-icon' href='/apple-touch-icon.png' /></head>");
			escritura.println(" <body>");

			Integer i = 0;
			for (Exam e : this.exams.getExams()) {

				escritura.println(" <div>");
				escritura.println(" <header>");

				escritura.println(" <h1><center>Exam</center></h1>");
				escritura.println(" <h6><center>Serial: " + i
						+ "</center></h6>");
				escritura.println(" </header>");
				escritura.println(" <div>");
				escritura.println(" <nav>");
				i++;
				for (Question aux : e.getQuestions()) {

					escritura.println("<h2>" + aux.getWording() + "</h2>");
					if (aux.getAnswers() != null) {
						for (Answer ans : aux.getAnswers()) {
							escritura.println("<p>" + ans.getSentence() + "</p>");
						}
						escritura.println(" <hr>");
					}

				}
				escritura.println(" </nav>");
				escritura.println(" </div>");
				escritura.println(" </div>");

			}

			escritura.println(" </body>");
			escritura.println("</html>");

			// nos aseguramos de cerrar el archivo
			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
