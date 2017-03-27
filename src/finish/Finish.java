/**
 * 
 */
package finish;

import java.net.URL;
import java.util.ResourceBundle;
import welcomeScreen.WelcomeScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import screenFramework.ScreenController;

/**
 * @author Tihomir Penev
 *
 */
public class Finish implements Initializable, screenFramework.ControlledScreen{
	
	ScreenController myController;
	@FXML
	public Button finish;
	public void setScreenParent(ScreenController screenParent) {
		 myController = screenParent;
		 
	}

	@FXML
    private void goWelcome(ActionEvent event){
       myController.setScreen(screenFramework.ScreensFramework.screen1ID);
      
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
