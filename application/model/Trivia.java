package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trivia {

	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String answer;
	
	public void loadTrivia(String filePath) {
		File file = new File(filePath);
		
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		
		String[] line = lines.get((int)(Math.random() * lines.size())).split(",");
		
		this.question = line[0];
		this.option1 = line[1];
		this.option2 = line[2];
		this.option3 = line[3];
		this.answer = line[4];
		
		if (line.length > 5) {
			for (int i = 5; i < line.length; i++)
				this.answer += "," + line[i];
		}
		
		scanner.close();
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	public String getOption1() {
		return this.option1;
	}
	
	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption2() {
		return this.option2;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption3() {
		return this.option3;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return this.answer;
	}
}
