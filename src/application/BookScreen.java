package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import welcomeScreen.WelcomeScreenController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import screenFramework.ScreenController;
import screenFramework.ScreensFramework;
import database.MysqlConnect;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;



public class BookScreen implements Initializable, screenFramework.ControlledScreen{

	ScreenController myController;
	Connection conn = null;
	ResultSet rs = null;
	@FXML
	private ToggleButton tb1;

	Calendar today = Calendar.getInstance();
	@FXML
	private Text day1;

	@FXML
	private GridPane showGrid; 
	@FXML
	private Label reg;
	@FXML
	private Label car;
	@FXML
	private Label Please;

	@FXML
	private Button hour11;
	@FXML
	private Button hour40;
	@FXML
	private Button btnNext;
	@FXML
	private Button back;
	@FXML
	private MenuButton pp;
	@FXML
	private ToggleGroup h;
	@FXML
	private ListView<String> listview;
	@FXML
	public void showCoordinators(MouseEvent event) throws SQLException {

		showGrid.setVisible(true);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = MysqlConnect.ConnecrDb();
			System.out.println("Connection form Java FX success!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select*from Staff");
			while(rs.next()) {
				String name = rs.getString("name");
				ObservableList <String> list = FXCollections.observableArrayList(name);
				listview.getItems().addAll(list);

				//pp.setText(name);
				System.out.println(name);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@FXML
	public void OpenSecondPage(ActionEvent event) throws Exception {               


		myController.setScreen(screenFramework.ScreensFramework.screen3ID);


	}
	@FXML
	public void openWelcome(ActionEvent event) throws Exception {               
		myController.setScreen(screenFramework.ScreensFramework.screen1ID);
	}	



	public void setScreenParent(ScreenController screenParent) {
		myController = screenParent;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conn = MysqlConnect.ConnecrDb();

	}
}
