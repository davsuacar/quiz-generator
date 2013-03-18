package input;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import beans.Answer;
import beans.Question;

public class Parser {

	private List<Question> questions;
	private File file;

	public Parser(String namefile) {

		questions = new ArrayList<Question>();
		file = new File(namefile);
		Document doc = createDocument();
		parserDocument(doc);

	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private void parserDocument(Document doc) {

		// To initilize the document as a tree
		doc.getDocumentElement().normalize();

		// This is our root element, in our document is <exam>
		System.out.println("Root element "
				+ doc.getDocumentElement().getNodeName());

		// We divide the documents in different questions
		NodeList nd = doc.getElementsByTagName("question");
		System.out.println("Starting to extract information");

		// We start to analyze each <question>
		for (int i = 0; i < nd.getLength(); i++) {

			// Each node is a <question> tag
			Node n = nd.item(i);
			Element node = (Element) n;

			// We differentiate between multiple-choice questions and problem
			// questions
			if (n.getNodeType() == Node.ELEMENT_NODE
					&& node.getAttribute("type").equals("multiple-choice")) {

				System.out.println("Getting into multiple-choice");

				// To obtain the WORDING of the question
				NodeList wording = node.getElementsByTagName("wording");

				// We obtain the father node
				Element father = (Element) wording.item(0);

				// We obtain the children nodes, in this case we only have 1
				// child.
				NodeList children = father.getChildNodes();
				String sentence = children.item(0).getNodeValue();
				System.out.println(sentence);

				// To obtain the MULTIPLE-CHOICES
				NodeList answer = node.getElementsByTagName("answer");

				// CHOICE 1

				// We obtain the father node
				Element father2 = (Element) answer.item(0);

				// We obtain the children nodes, in this case we only have 1
				// child.
				NodeList children2 = father2.getChildNodes();
				String sentence2 = children2.item(0).getNodeValue();
				System.out.println(sentence2);

				Answer answer1 = null;
				if (father2.getAttribute("value").equals("false")) {
					answer1 = new Answer(sentence2, true);
				} else {
					answer1 = new Answer(sentence2, false);
				}


				// CHOICE 2

				// We obtain the father node
				Element father3 = (Element) answer.item(1);

				// We obtain the children nodes, in this case we only have 1
				// child.
				NodeList children3 = father3.getChildNodes();
				String sentence3 = children3.item(0).getNodeValue();
				System.out.println(sentence3);

				Answer answer2 = null;
				if (father3.getAttribute("value").equals("false")) {
					answer2 = new Answer(sentence3, true);
				} else {
					answer2 = new Answer(sentence3, false);
				}
				
				// CHOICE 3

				// We obtain the father node
				Element father4 = (Element) answer.item(2);

				// We obtain the children nodes, in this case we only have 1
				// child.
				NodeList children4 = father4.getChildNodes();
				String sentence4 = children4.item(0).getNodeValue();
				System.out.println(sentence4);

				Answer answer3 = null;
				if (father4.getAttribute("value").equals("false")) {
					answer3 = new Answer(sentence4, true);
				} else {
					answer3 = new Answer(sentence4, false);
				}
				
				// CHOICE 4

				// We obtain the father node
				Element father5 = (Element) answer.item(3);

				// We obtain the children nodes, in this case we only have 1
				// child.
				NodeList children5 = father5.getChildNodes();
				String sentence5 = children5.item(0).getNodeValue();
				System.out.println(sentence5);
				
				Answer answer4 = null;
				if (father5.getAttribute("value").equals("false")) {
					answer4 = new Answer(sentence5, true);
				} else {
					answer4 = new Answer(sentence5, false);
				}
				

				// TO CREATE THE ATTRIBUTE "QUESTIONS"

				 List<Answer> answers = new ArrayList<Answer>();
				 answers.add(answer1);
				 answers.add(answer2);
				 answers.add(answer3);
				 answers.add(answer4);
				
				 this.questions.add(new Question(sentence, answers));

			}

			if (n.getNodeType() == Node.ELEMENT_NODE
					&& node.getAttribute("type").equals("problem")) {

				System.out.println("Getting into problem");

				NodeList wording = node.getElementsByTagName("wording");
				Element father = (Element) wording.item(0);
				NodeList children = father.getChildNodes();
				String sentence6 = children.item(0).getNodeValue();
				System.out.println(sentence6);
				this.questions.add(new Question(sentence6));

			}

		}

	}

	private Document createDocument() {
		Document doc = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return doc;

	}

}
