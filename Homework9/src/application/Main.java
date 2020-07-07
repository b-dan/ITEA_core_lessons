package application;

import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Main extends Application {



	@Override
	public void start(Stage primaryStage){
		setCustomView(primaryStage);
	}    

	public void setCustomView(Stage primaryStage) {
		primaryStage.setTitle("Dota2 Pudge");
		primaryStage.setResizable(false);
		Image ico = new Image("file:images/dota.png");
		primaryStage.getIcons().add(ico);
		Pane pane = new Pane();
		GridPane root = new GridPane();
		GridPane buttonRoot = new GridPane();
		
		Button save = new Button("Save");
		Button load = new Button("Load");
		Button ru = new Button("RU");
		Button en = new Button("EN");
		Button de = new Button("DE");

		Image imageDe = new Image("file:images/pudge3.png");
		Image imageRu = new Image("file:images/pudge2.png");
		Image imageEn = new Image("file:images/pudge1.png");
		
		ImageView imageView = new ImageView(imageEn);
		imageView.setFitHeight(350);
		imageView.setFitWidth(350);
		imageView.setPreserveRatio(true);
		imageView.setLayoutX(25);
		imageView.setLayoutY(25);
		pane.getChildren().add(imageView);
		
		Label label1 = new Label("Так много мяса, так мало времени");
		Label label2 = new Label("Вы поглядите, сколько сочного мяса вокруг!");
		Label label3 = new Label("Дело в шляпе");
		
		//root.setVisible(true);
		//root.setGridLinesVisible(true);
		root.add(label1, 0, 15);
		root.add(label2, 0, 16);
		root.add(label3, 0, 17);
		root.setAlignment(Pos.BOTTOM_LEFT);
		root.setVgap(20);
		root.setHgap(30);
		root.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
		
		buttonRoot.setAlignment(Pos.TOP_RIGHT);
		buttonRoot.setVgap(20);
		buttonRoot.setHgap(30);
		buttonRoot.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
		buttonRoot.add(save, 12, 0);
		buttonRoot.add(load, 12, 1);
		buttonRoot.add(ru, 12, 2);
		buttonRoot.add(en, 12, 3);
		buttonRoot.add(de, 12, 4);
		pane.getChildren().add(root);
		pane.getChildren().add(buttonRoot);
		

		Scene scene = new Scene(pane, 450, 455);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Locale ruLocale = new Locale("ru", "RU");
		ResourceBundle ruMessage = ResourceBundle.getBundle("lang", ruLocale);
		Locale enLocale = new Locale("en", "EN");
		ResourceBundle enMessage = ResourceBundle.getBundle("lang", enLocale);
		Locale deLocale = new Locale("de","DE");
		ResourceBundle deMessage = ResourceBundle.getBundle("lang",deLocale);
		
		ru.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				imageView.setImage(imageRu);
				label1.setText(ruMessage.getString("first"));
				label2.setText(ruMessage.getString("second"));
				label3.setText(ruMessage.getString("third"));
				

			}
		});
		en.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				imageView.setImage(imageEn);
				
				 label1.setText(enMessage.getString("first"));
				 label2.setText(enMessage.getString("second"));
				 label3.setText(enMessage.getString("third"));
				
			}
		});
		
		
		de.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				imageView.setImage(imageDe);
				
				 label1.setText(deMessage.getString("first"));
				 label2.setText(deMessage.getString("second"));
				 label3.setText(deMessage.getString("third"));
				 
				
			}
		});
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					File file = new File("Save.txt");
					if(!file.exists())
						file.createNewFile();
					
						PrintWriter pw = new PrintWriter(file);
						pw.println(label1.getText());
						pw.println(label2.getText());
						pw.println(label3.getText());
						pw.println(imageView.getImage().impl_getUrl());
						pw.close();
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				
			}
		});
		
		load.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("Save.txt"));
						label1.setText(br.readLine());
						label2.setText(br.readLine());
						label3.setText(br.readLine());
						String a = "file:images/pudge1.png";
						String b = "file:images/pudge2.png";
						String c = "file:images/pudge3.png";
						String d = br.readLine();
						if(d.equals(a)) {
							imageView.setImage(imageEn);
						}
						else if(d.equals(b)) {
							imageView.setImage(imageRu);
						}
						else{
							imageView.setImage(imageDe);
						}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
