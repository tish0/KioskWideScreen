package urls;
/**
 * This is the Contrller class
 * @author    	Tihomir Penev
 * @version   	1.0.0 February 23, 2017
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import screenFramework.ScreenController;
import screenFramework.ScreensFramework;
import screenFramework.ScreenController;

public class UrlsController implements Initializable, screenFramework.ControlledScreen{
	
	ScreenController myController;
	
	@FXML
	private Button wb1,wb2,wb3,wb4,wb5,wb6,backButton,forwardButton,mainMenu;
	@FXML
	private WebView web;
	private TextField addressField;
	private String homeAddress = "http://www.algonquincollege.com";
	private WebEngine engine;
	private ArrayList<String> addresses = new ArrayList<String>();
	private int addressPointer = -1;
	private static String[] urls = new String[]{
			"http://www.algonquincollege.com",
			"http://www.algonquincollege.com/future-students/programs/",
			"http://www.algonquincollege.com/a-z/#news",
			"http://www.algonquincollege.com/about/",
			"http://www.algonquincollege.com/careers/career-opportunities/",
			"http://www.algonquincollege.com/future-students/"
	};
	
	public void setScreenParent(ScreenController screenParent) {
		 myController = screenParent;
		
	}
	
	
	private EventHandler<ActionEvent> go = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			String address = null;
			loadRandomAddress(urls[0]);}};

	private EventHandler<ActionEvent> go1 = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			String address = null;
			loadRandomAddress(urls[1]);}};
			
	private EventHandler<ActionEvent> go2 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String address = null;
					loadRandomAddress(urls[2]);}};
	private EventHandler<ActionEvent> go3 = new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							String address = null;
							loadRandomAddress(urls[3]);}};
	private EventHandler<ActionEvent> go4 = new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									String address = null;
									loadRandomAddress(urls[4]);}};
	private EventHandler<ActionEvent> go5 = new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent event) {
											String address = null;
											loadRandomAddress(urls[5]);}};

	private void loadRandomAddress(String address) {
		if(address == null)
			address = addressField.getText();
		address = extractAddress(address);
		System.out.println(address);
		engine.load("http://" + address);
		addressField.setText(engine.getLocation());

		removeObsoleteAddresses();
		addresses.add(address);
		resetButtons();
	}

	private void removeObsoleteAddresses() {
		addressPointer++;
		while (addresses.size() - 1 >= addressPointer) {
			addresses.remove(addresses.size() - 1);
		}
	}


	private EventHandler<ActionEvent> back = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {

			addressPointer--;
			if (addressPointer >= 0) {
				loadPointedAddress();
			} else {
				addressPointer = 0;
			}
			resetButtons();
		}
	};

	private EventHandler<ActionEvent> forward = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {

			addressPointer++;
			if (addressPointer <= addresses.size() - 1) {
				loadPointedAddress();
			} else {
				addressPointer = addresses.size() - 1;
			}
			resetButtons();
		}
	};

	private void loadPointedAddress() {
		System.out.println(addresses.get(addressPointer));
		engine.load("http://" + addresses.get(addressPointer));
		addressField.setText(engine.getLocation());
	}


	private void resetButtons() {
		System.out.println(addresses);
		System.out.println(addressPointer);

		if (addressPointer <= 0)
			backButton.setDisable(true);
		else
			backButton.setDisable(false);

		if (addressPointer >= addresses.size() - 1)
			forwardButton.setDisable(true);
		else
			forwardButton.setDisable(false);
	}

	private String extractAddress(String fullAddress) {
		String result = fullAddress;
		if (fullAddress.startsWith("http://") ) {
			result = fullAddress.substring("http://".length());
		}
		else if (fullAddress.startsWith("https://")) {
			result = fullAddress.substring("https://".length());
		} 
		return result;
	}
	@FXML
	public void OpenMainMenu(ActionEvent event) throws Exception {               
		 myController.setScreen(screenFramework.ScreensFramework.screen1ID);
}
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			wb1.setOnAction(go);
			wb2.setOnAction(go1);
			wb3.setOnAction(go2);
			wb4.setOnAction(go3);
			wb5.setOnAction(go4);
			wb6.setOnAction(go5);
			backButton.setOnAction(back);
			forwardButton.setOnAction(forward);
			engine = web.getEngine();
			engine.setJavaScriptEnabled(true);
			homeAddress = extractAddress(homeAddress);
			engine.load("http://" + homeAddress);
			
		}

		/* (non-Javadoc)
		 * @see screenFramework.ControlledScreen#setScreenParent(screenFramework.ScreenController)
		 */
		

}
