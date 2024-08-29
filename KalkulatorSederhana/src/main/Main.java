package main;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	
	
	
	Button tambah, kurang, kali, bagi;
	GridPane Gp;
	Label judul, input1Lbl, input2Lbl, output; 
	TextField input1, input2, outputField;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Kalkulator Sederhana");
		initalize(primaryStage);
		
		
	}

	private void initalize(Stage primaryStage) {
		// method utk inisialisasi 
		HBox buttonSet = new HBox();
		tambah = new Button("+");
		kurang = new Button("-");
		kali = new Button ("x");
		bagi = new Button ("/");
		
		Gp = new GridPane();
		
		judul = new Label("Kalkulator");
		input1Lbl = new Label("Input angka 1");
		input2Lbl = new Label("Input angka 2");
		output = new Label ("Hasil");
		input1 = new TextField();
		input2 = new TextField();
		outputField = new TextField();
		Gp.add(judul, 0, 0);
		Gp.add(input1Lbl, 0, 1);
		Gp.add(input2Lbl, 0, 2);
		Gp.add(input1, 1, 1);
		Gp.add(input2, 1, 2);
		Gp.add(buttonSet,1 ,4);
		Gp.add(output, 0,6);
		Gp.add(outputField, 1,6);
		Gp.setHgap(10);
		Gp.setVgap(10);
		
		
		Gp.setPadding(new Insets(10,10,10,20));
		Scene mainScene;
		mainScene = new Scene(Gp,300,200);
		
		
		mainScene.addEventHandler(KeyEvent.KEY_PRESSED, this::keyHandler);
		
		buttonSet.getChildren().addAll(tambah, kurang, kali, bagi);
		
		buttonSet.setSpacing(10);
		setEventHandler();
		setMouseAction();
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	public void setEventHandler() {
		tambah.setOnAction(this);
		kurang.setOnAction(this);
		kali.setOnAction(this);
		bagi.setOnAction(this);
		
	}
	
	public void keyHandler(KeyEvent event) {
		String keyText = event.getText();
		if (!keyText.isEmpty()) {
			if (keyText.equals("=") && event.isShiftDown()) {
				try {
					Double result = Double.parseDouble(input1.getText()) + Double.parseDouble(input2.getText());
					outputField.setText(result.toString());
				} catch (Exception e2) {
					// TODO: handle exception
					outputField.setText("Error");
				}
			} else {
				if (keyText.equals("-")) {
					try {
						Double result = Double.parseDouble(input1.getText()) - Double.parseDouble(input2.getText());
						outputField.setText(result.toString());
					} catch (Exception e2) {
						// TODO: handle exception
						outputField.setText("Error");
					}
					
			}else if ( keyText.equals("8") && event.isShiftDown() ) {
				try {
					Double result = Double.parseDouble(input1.getText()) * Double.parseDouble(input2.getText());
					outputField.setText(result.toString());
				} catch (Exception e2) {
					// TODO: handle exception
					outputField.setText("Error");
				}
			} else if (keyText.equals("/")) {
				try {
					Double result = Double.parseDouble(input1.getText()) / Double.parseDouble(input2.getText());
					outputField.setText(result.toString());
				} catch (Exception e2) {
					// TODO: handle exception
					outputField.setText("Error");
				}
			}
		} 
			}
		
			
	}
	
	
	public void setMouseAction() {
		tambah.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tambah.setStyle("-fx-background-color: #ffff46");
			}
			
		});
		
		tambah.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tambah.setStyle(" ");
			}
			
		});
		
		tambah.setOnAction(e -> {
			try {
				Double result = Double.parseDouble(input1.getText()) + Double.parseDouble(input2.getText());
				outputField.setText(result.toString());
			} catch (Exception e2) {
				// TODO: handle exception
				outputField.setText("Error");
			}
		});
		
		kurang.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				kurang.setStyle("-fx-background-color: #ff46ff");
			}
			
		});
		
		kurang.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				kurang.setStyle(" ");
			}
			
		});
		
		kurang.setOnAction(e -> {
			try {
				Double result = Double.parseDouble(input1.getText()) - Double.parseDouble(input2.getText());
				outputField.setText(result.toString());
			} catch (Exception e2) {
				// TODO: handle exception
				outputField.setText("Error");
			}
		});
		
		kali.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				kali.setStyle("-fx-background-color: #56ccff");
			}
			
		});
		
		kali.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				kali.setStyle("");
			}
			
		});
		
		kali.setOnAction(e -> {
			try {
				Double result = Double.parseDouble(input1.getText()) * Double.parseDouble(input2.getText());
				outputField.setText(result.toString());
			} catch (Exception e2) {
				// TODO: handle exception
				outputField.setText("Error");
			}
		});
		
		bagi.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				bagi.setStyle("-fx-background-color: #46ff46");
			}
			
		});
		
		bagi.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				bagi.setStyle("");
			}
			
		});
		
		bagi.setOnAction(e -> {
			try {
				Double result = Double.parseDouble(input1.getText()) / Double.parseDouble(input2.getText());
				outputField.setText(result.toString());
			} catch (Exception e2) {
				// TODO: handle exception
				outputField.setText("Error");
			}
		});
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}