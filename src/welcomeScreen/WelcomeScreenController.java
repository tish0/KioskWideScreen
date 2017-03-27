package welcomeScreen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import screenFramework.ScreenController;
import screenFramework.ScreensFramework;
import screenFramework.ScreenController;
import screenFramework.ControlledScreen;

public class WelcomeScreenController implements Initializable, screenFramework.ControlledScreen {
	
	ScreenController myController;
	
	@FXML
	public Button btnTouchtoStart;
	@FXML
	public Button btnMeeting;
	@FXML
	public Button btnQuickLinks;
	
	
	@FXML
	public void TouchtoStart(ActionEvent event){
		try{
			btnMeeting.setVisible(true);
			btnQuickLinks.setVisible(true);
			btnTouchtoStart.setVisible(false);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@FXML
	public void Back(ActionEvent event){
		try{
			if(btnMeeting.isVisible()){
				btnMeeting.setVisible(false);
				btnQuickLinks.setVisible(false);
				btnTouchtoStart.setVisible(true);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public void setScreenParent(ScreenController screenParent) {
		 myController = screenParent;
		 
	}
	
		@FXML
	    private void BookMeeting(ActionEvent event){
	       myController.setScreen(screenFramework.ScreensFramework.screen2ID);
	       btnMeeting.setVisible(false);
			btnQuickLinks.setVisible(false);
			btnTouchtoStart.setVisible(true);
	    }
	    
	    @FXML
	    private void QuickLinks(ActionEvent event){
	       myController.setScreen(screenFramework.ScreensFramework.screen5ID);
	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
