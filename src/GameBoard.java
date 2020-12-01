import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.Group;
/*
   
*/
public class GameBoard
{     
   //Varible. 
   int count = 0;

   /*
      Build Stage.
   */
   protected void playStage()
   { 
      //Create Objects.
      Stage secondaryStage = new Stage();
      BorderPane gameBorder = new BorderPane();
      GridPane centerGrid = new GridPane();
      GridPane bottomGrid = new GridPane();
      Button restartButton = new Button("Restart");
      Button endButton = new Button("End Game");
      HBox leftHbox = new HBox();
      HBox rightHbox = new HBox();
      Button button1 = new Button("Test 1");
      Button button2 = new Button("Test 2");
      Button button3 = new Button("Test 3");
      Button button4 = new Button("Test 4");
      Button button5 = new Button("Test 5");
      Button button6 = new Button("Test 6");
      Button button7 = new Button("Test 7");
      Button button8 = new Button("Test 8");
      Button button9 = new Button("Test 9");
      
      
      //Build Board.
      gameBorder.setCenter(centerGrid);
      gameBorder.setBottom(bottomGrid);
      gameBorder.setLeft(leftHbox);
      gameBorder.setRight(rightHbox);
      
      
      //Center Border Grid Layout (Use to add O's and X's later).
      centerGrid.add(button1, 0, 0);
      centerGrid.add(button2, 1, 0);
      centerGrid.add(button3, 2, 0);
      centerGrid.add(button4, 0, 1);
      centerGrid.add(button5, 1, 1);
      centerGrid.add(button6, 2, 1);
      centerGrid.add(button7, 0, 2);
      centerGrid.add(button8, 1, 2);
      centerGrid.add(button9, 2, 2);
      
      //Bottom Border Menu.
      bottomGrid.add(restartButton, 0, 0);
      bottomGrid.add(endButton, 1, 0);
      
      //Create scene 2.
      Scene scene2 = new Scene(gameBorder, 1000, 1000);
      
      //Set Sizing.
      leftHbox.setPrefSize(150,50);
      rightHbox.setPrefSize(150,50);
      
      //Set Alignment.
      centerGrid.setAlignment(Pos.CENTER);
      //Add CSS.
      button1.getStyleClass().addAll("gameButton");
      button2.getStyleClass().addAll("gameButton");
      button3.getStyleClass().addAll("gameButton");
      button4.getStyleClass().addAll("gameButton");
      button5.getStyleClass().addAll("gameButton");
      button6.getStyleClass().addAll("gameButton");
      button7.getStyleClass().addAll("gameButton");
      button8.getStyleClass().addAll("gameButton");
      button9.getStyleClass().addAll("gameButton");
      bottomGrid.getStyleClass().addAll("pane");
      scene2.getStylesheets().add("css/style.css");
      
      // Add the scene2 to the secondaryStage.
      secondaryStage.setScene(scene2);
      
      // Set secondaryStage title.
      secondaryStage.setTitle("Tic Tac Toe");
      
      //Debugging
      bottomGrid.setGridLinesVisible(true);
      
      // Show the window.
      secondaryStage.show();
      
      //endButton Actions.
      endButton.setOnAction(event -> secondaryStage.close());
      
      //button#'s actions to change from X to O.
      //button1
      button1.setOnAction(event -> 
      {  
         count++;
         button1.setText(symbol(Integer.toString(count)));
      });
      //button2
      button2.setOnAction(event -> 
      {  
         count++;
         button2.setText(symbol(Integer.toString(count)));
      });
      //button3
      button3.setOnAction(event -> 
      {  
         count++;
         button3.setText(symbol(Integer.toString(count)));
      });
      //button4
      button4.setOnAction(event -> 
      {  
         count++;
         button4.setText(symbol(Integer.toString(count)));
      });
      //button5
      button5.setOnAction(event -> 
      {  
         count++;
         button5.setText(symbol(Integer.toString(count)));
      });
      //button6
      button6.setOnAction(event -> 
      {  
         count++;
         button6.setText(symbol(Integer.toString(count)));
      });
      //button7
      button7.setOnAction(event -> 
      {  
         count++;
         button7.setText(symbol(Integer.toString(count)));
      });
      //button8
      button8.setOnAction(event -> 
      {  
         count++;
         button8.setText(symbol(Integer.toString(count)));
      });
      //button9
      button9.setOnAction(event -> 
      {  
         count++;
         button9.setText(symbol(Integer.toString(count)));
      });
   } 
   
   /*
   */
   public String symbol(String c)
   {  
      //Variables
      String sym = c;
      int turn = Integer.parseInt(sym);
      //Set to X.
      if (turn % 2 == 0)
      {
         sym = "X";     
      }
      //Set to O.
      else 
      {
         sym = "O"; 
      }
      return sym;
   }                    
}