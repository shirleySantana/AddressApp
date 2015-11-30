package ch.makery.address.view;

import ch.makery.address.control.MainApp;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Animation.Status;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class LoginController {
	@FXML
	private Label lblUsr;

	@FXML
	private Label lblPwd;

	@FXML
	private TextField txtUsr;

	@FXML
	private PasswordField txtPwd;

	@FXML
	private Button login;

	@FXML
	private Label lblTitle;

	@FXML
	private ImageView icon;

	@FXML
	private Rectangle rect;

	boolean color =false;
	SequentialTransition str;
	private MainApp mainApp;


//    rect.setArcHeight(10);
//    rect.setArcWidth(10);

//    root.getChildren().add(rect);

	public LoginController(){

	}

	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}

	@FXML
	private void handleLogin() throws InterruptedException{

		if(txtUsr.getText().toString().equals("Admin") && txtPwd.getText().toString().equals("12345")){
			color = true;
			initTransition(color);
			//System.out.println();
			str.setOnFinished(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					mainApp.initRootLayout();
					mainApp.showPersonOverview();
				}
			});
		}else{
			initTransition(color);
		}

	}
	@FXML
	private void initTransition(Boolean color){
		RotateTransition rottr
        	= new RotateTransition(Duration.millis(1000), rect);
		rottr.setByAngle(180);
		rottr.setCycleCount(2);
		rottr.setAutoReverse(true);
		
		FillTransition fltr;
		if(color){
			fltr = new FillTransition(Duration.millis(1000),
	                rect, Color.GRAY, Color.GREEN);
			 
		}else{
			fltr = new FillTransition(Duration.millis(1000),
	                rect, Color.GRAY, Color.RED);
		}
		fltr.setCycleCount(1);
        fltr.setAutoReverse(false);

        str = new SequentialTransition();
        str.getChildren().addAll(rottr,fltr);

        str.play();


	}
}
