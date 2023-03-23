package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Trivia;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TrickController implements EventHandler<ActionEvent>, Initializable {

	@FXML Text question;
	@FXML Button option1;
	@FXML Button option2;
	@FXML Button option3;
	@FXML Text answer;
	@FXML Button home;
	
	Trivia trivia = new Trivia();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		trivia.loadTrivia("src/data/trivia.csv");
		
		question.setText(trivia.getQuestion());
		option1.setText(trivia.getOption1());
		option2.setText(trivia.getOption2());
		option3.setText(trivia.getOption3());		
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button source = (Button)event.getSource();
		String id = source.getId();
		
		if (id.equals("option1") || id.equals("option2") || id.equals("option3")) {	
			if (trivia.getAnswer().contains(source.getText().replaceAll("AD",""))) {
				answer.setText(trivia.getAnswer());
				answer.setFill(Color.GREEN);
			} else {
				answer.setText(trivia.getAnswer());
				answer.setFill(Color.RED);
			}
			
			return;
		}
		
		if (id.equals("home")) {
			try {
				AnchorPane pane = (AnchorPane) new FXMLLoader(Main.class.getResource("view/Main.fxml")).load();
				Scene scene = new Scene(pane,500,500);
				
				Main.stage.setScene(scene);
			} catch (IOException error) {
				error.printStackTrace();
			}
		}
	}
}