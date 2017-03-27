/**
 * 
 */
package screenFramework;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screenFramework.ScreenController;
import screenFramework.ScreensFramework;

/**
 * @author Tihomir Penev
 *
 */
public class ScreensFramework extends Application {
	
//		private static Stage primaryStage;
//		public static void resizeScreen(){
//			primaryStage.sizeToScene(); primaryStage.centerOnScreen(); 
//			}
		public static String screen1ID = "main";
	    public static String screen1File = "/welcomeScreen/WelcomeScreen.fxml";
	    public static String screen2ID = "screen2";
	    public static String screen2File = "/application/BookScreen.fxml";
	    public static String screen3ID = "screen3";
	    public static String screen3File = "/secondPage/BookSecondPage.fxml";
	    public static String screen4ID = "screen4";
	    public static String screen4File = "/bookConfirm/BookConfirm.fxml";
	    public static String screen5ID = "screen5";
	    public static String screen5File = "/urls/Urls.fxml";
	    public static String screen6ID = "screen6";
	    public static String screen6File = "/finish/Finish.fxml";
	
	    
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		
		
		 ScreenController mainContainer = new ScreenController();
	        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
	        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
	        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
	        mainContainer.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
	        mainContainer.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
	        mainContainer.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);
	        
	        mainContainer.setScreen(ScreensFramework.screen1ID);
	        
	        Group root = new Group();
	        root.getChildren().addAll(mainContainer);
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setFullScreen(true);
	        primaryStage.show();
	    }

	    /**
	     * The main() method is ignored in correctly deployed JavaFX application.
	     * main() serves only as fallback in case the application can not be
	     * launched through deployment artifacts, e.g., in IDEs with limited FX
	     * support. NetBeans ignores main().
	     *
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        launch(args);
	    }
	}
