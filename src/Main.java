import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent; 
/*
*/
public class Main extends Application
{
   //Fields.
   private TextField playerOneField;
   private TextField playerTwoField;
   
   public static void main(String[] args)
   {  
      // Launch the application.
      launch(args);
   }   
   
   /*
   */
   @Override
   public void start(Stage primaryStage)
   {
      //Create Objects.
      BorderPane welcomeBorder = new BorderPane();
      GridPane playerGrid = new GridPane();
      Button startButton = new Button("Start");
      Label playerOne = new Label("Player One name: ");
      Label playerTwo = new Label("Player Two name: ");
      Label welcomeLabel = new Label("Welcome to Tic Tac Toe!");
      TextField playerOneField = new TextField();
      TextField playerTwoField = new TextField();
      VBox bottomVbox = new VBox(startButton);
      
      //Build Grid.
      playerGrid.add(playerOne, 0, 0);
      playerGrid.add(playerTwo, 0, 1);
      playerGrid.add(playerOneField, 1, 0);
      playerGrid.add(playerTwoField, 1, 1);
      
      //Build Board.
      welcomeBorder.setTop(welcomeLabel);
      welcomeBorder.setCenter(playerGrid);
      welcomeBorder.setBottom(bottomVbox);
      
      //Set Sizing.
      bottomVbox.setPrefSize(0,500);

      //Create scene 1.
      Scene scene1 = new Scene(welcomeBorder, 1000, 1000);
      
      //Add CSS.
      scene1.getStylesheets().add("css/style.css");
      
      // Add the scene1 to the primaryStage.
      primaryStage.setScene(scene1);
      
      // Set primaryStage title.
      primaryStage.setTitle("Tic Tac Toe");
      
      // Show the window.
      primaryStage.show();
      
      //Event Listener for startButton.
      startButton.setOnAction(event ->
      {
         //Open playStage then close primaryStage. 
         GameBoard startGame = new GameBoard();
         startGame.playStage();
         primaryStage.close();
      });

   }
}