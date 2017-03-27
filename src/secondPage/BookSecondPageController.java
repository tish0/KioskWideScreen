package secondPage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import screenFramework.ScreenController;

public class BookSecondPageController  implements Initializable, screenFramework.ControlledScreen{
	
	ScreenController myController;
	@FXML
	private Button back;
	@FXML
	private Button bookNow;
	@FXML
	private MenuButton pp;
	@FXML
	private TextField reason;
	@FXML
	public void openBookScreen(ActionEvent event) throws Exception {               
		
			 myController.setScreen(screenFramework.ScreensFramework.screen2ID);
	}
	@FXML
	public void openConfirm(ActionEvent event) throws Exception {               
		 myController.setScreen(screenFramework.ScreensFramework.screen4ID);
			
	}
	@FXML
	public void getReason(ActionEvent event) throws Exception {               
		reason.setText("Reason one");
	}
	
	public void setScreenParent(ScreenController screenParent) {
		 myController = screenParent;
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
