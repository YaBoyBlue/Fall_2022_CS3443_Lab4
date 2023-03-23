package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TreatController implements EventHandler<ActionEvent>, Initializable {

	@FXML ImageView image;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String filePath = "src/data/treats/image" + ((int)(Math.random() * 8) + 1) + ".jpeg";
		
		try {
			FileInputStream stream = new FileInputStream(filePath);
			Image img = new Image(stream);
			
			image.setImage(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Button source = (Button)event.getSource();
		String id = source.getId();
		
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
