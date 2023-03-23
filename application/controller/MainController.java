package application.controller;

import java.io.IOException;

import application.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements EventHandler<ActionEvent>{
	
	@FXML Button trick;
	@FXML Button treat;
	
	@Override
	public void handle(ActionEvent event) {
		String source = ((Button)event.getSource()).getId();
		String fxml = "";
		
		if (source.equals("trick"))
			fxml = "Trick.fxml";
		if (source.equals("treat"))
			fxml = "Treat.fxml";
		
		try {
			AnchorPane pane = (AnchorPane) new FXMLLoader(Main.class.getResource("view/" + fxml)).load();
			Scene scene = new Scene(pane,500,500);
			
			Main.stage.setScene(scene);
		} catch (IOException error) {
			error.printStackTrace();
		}	
	}
}