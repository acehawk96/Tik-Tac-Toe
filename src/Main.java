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
import javax.swing.JOptionPane; 
import javafx.geometry.Insets;
/**
   This program is a Tick Tac Toe Game created for
   Computer Science 2 class Final Project at CCM.
   ---
   I did not include a try catch statement for getting the 
   user's names because I used Label objects so whether they
   type letters, numbers, or symbols, their input will always
   be outputted. 
   ---
   Final Project.
   ---
   10 Dec 2020  
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
   
   /**
      start method starts javaFX GUI.
      @param Stage primaryStage : Appliction class's Stage Reference Variable. 
   */
   @Override
   public void start(Stage primaryStage)
   {
      //Create Objects.
      BorderPane welcomeBorder = new BorderPane();
      GridPane playerGrid = new GridPane();
      Button startButton = new Button("Start");
      Button enterButton = new Button("Enter");
      Label playerOne = new Label("Player One name: ");
      Label playerTwo = new Label("Player Two name: ");
      Label welcomeLabel = new Label("Welcome to Tic Tac Toe!");
      TextField playerOneField = new TextField("player 1");
      TextField playerTwoField = new TextField("player 2");
      VBox topVbox = new VBox(welcomeLabel);
      
      //Build Grid.
      playerGrid.add(playerOne, 0, 0);
      playerGrid.add(playerTwo, 0, 1);
      playerGrid.add(playerOneField, 1, 0);
      playerGrid.add(playerTwoField, 1, 1);
      playerGrid.add(enterButton, 1, 3);
      playerGrid.add(startButton, 1, 4);
      
      //Build Board.
      welcomeBorder.setTop(topVbox);
      welcomeBorder.setCenter(playerGrid);
      
      //Set Sizing and Postion.
      playerGrid.setVgap(20);
      topVbox.setAlignment(Pos.CENTER);

      //Create scene 1.
      Scene scene1 = new Scene(welcomeBorder, 1000, 500);
      
      //Add CSS.
      scene1.getStylesheets().add("css/style.css");
      playerGrid.getStyleClass().addAll("centerAlign");
      welcomeBorder.getStyleClass().addAll("centerAlign");
      enterButton.getStyleClass().addAll("centerAlign");
      
      //Add the scene1 to the primaryStage.
      primaryStage.setScene(scene1);
      
      //Set primaryStage title.
      primaryStage.setTitle("Tic Tac Toe");
      
      //Show the window.
      primaryStage.show();
      
      //Event Listener for enterButton.
      enterButton.setOnAction(event ->
      {
         //Display names. 
         JOptionPane.showMessageDialog(null, "Welcome "
                                             + playerOneField.getText() +" & "
                                                + playerTwoField.getText() + "!");
      });

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

/*
   //TESTING DATA//
   
   *Entering names for playerOne and playerTwo, then selecting enter button:
      -open JoptionPane greeting.
   
   *Selecting start button:
      -open secondary stage with GameBoard class.  
*/