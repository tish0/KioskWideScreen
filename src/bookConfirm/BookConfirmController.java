package bookConfirm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screenFramework.ScreenController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class BookConfirmController implements Initializable, screenFramework.ControlledScreen{
	
	ScreenController myController;
	
	@FXML
	private Button back;
	@FXML
	private Button Confirm;
	@FXML
	private ImageView thanks;
	// Event Listener on Button[#back].onAction
	@FXML
	public void openBookSecondPage(ActionEvent event) throws Exception {               

			 myController.setScreen(screenFramework.ScreensFramework.screen3ID);		
	}
	
	@FXML
	public void OpenThanks(ActionEvent event){
		myController.setScreen(screenFramework.ScreensFramework.screen6ID);
	}

	
	public void setScreenParent(ScreenController screenParent) {
		 myController = screenParent;
		
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
