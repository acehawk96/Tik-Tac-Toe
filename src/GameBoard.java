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
import java.io.*; 
import java.util.*; 
/*
   
*/
public class GameBoard
{     
   //Varible and fields. 
   int count = 0;
   int counter = 0;
   String symbol;

   //GameTiles[][] tiles;

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
      
      /*    Testing  (put into a method maybe?)   */
      //Make tiles.
      Button[][] tiles = new Button[3][3];
      //Build tiles with loop (3 * 3).
      for(int row = 0; row < tiles.length; row++) 
      {  
         for (int col = 0; col < tiles[row].length; col++) 
         {
            tiles[row][col] = new Button("tile [" + row + "][" + col + "]");
            //Add CSS as tiles are made (Time Saver!).
            tiles[row][col].getStyleClass().addAll("gameButton");
            //console test for 9 Button objects made.
            System.out.println(tiles[row][col] + "\t");
         }
         System.out.println("------End of Row------ ");
      }
      System.out.println("-----Completed creating 9 Buttons with for loop!----- ");
      
      /*more testing.
      for(Button t : tiles)
      {
         System.out.println(Arrays.toString(tiles));
      }
      */
      
      //Build Board.
      gameBorder.setCenter(centerGrid);
      gameBorder.setBottom(bottomGrid);
      gameBorder.setLeft(leftHbox);
      gameBorder.setRight(rightHbox);
      
      /*
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
      */
      
      //Center Border Grid Layout (Use to add O's and X's later).
      centerGrid.add(tiles[0][0], 0, 0);
      centerGrid.add(tiles[1][0], 1, 0);
      centerGrid.add(tiles[2][0], 2, 0);
      centerGrid.add(tiles[0][1], 0, 1);
      centerGrid.add(tiles[1][1], 1, 1);
      centerGrid.add(tiles[2][1], 2, 1);
      centerGrid.add(tiles[0][2], 0, 2);
      centerGrid.add(tiles[1][2], 1, 2);
      centerGrid.add(tiles[2][2], 2, 2);
      
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
      /*                   
      button2.getStyleClass().addAll("gameButton");
      button3.getStyleClass().addAll("gameButton");
      button4.getStyleClass().addAll("gameButton");
      button5.getStyleClass().addAll("gameButton");      delete buttons
      button6.getStyleClass().addAll("gameButton");
      button7.getStyleClass().addAll("gameButton");
      button8.getStyleClass().addAll("gameButton");
      button9.getStyleClass().addAll("gameButton");
      */
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
      
      /*button#'s actions to change from X to O.
      (Some how this defies the law of physics with passing an int and recieving a string "x" or "o").*/
         //button1
         tiles[0][0].setOnAction(event ->                                        /*<<<<---------------fix tabbing*/
         {  
            count++;
            counter++;
            //track number of moves.                                                
            System.out.println("Number of moves iterated: " + counter);
            tiles[0][0].setText(symbol(Integer.toString(count)));
         });
         //button2
         tiles[1][0].setOnAction(event -> 
         {                                                                       /*<<<<---------------fix tabbing*/
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[1][0].setText(symbol(Integer.toString(count)));
         });
         //button3
         tiles[2][0].setOnAction(event -> 
         {  
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[2][0].setText(symbol(Integer.toString(count)));
         });
         //button4
         tiles[0][1].setOnAction(event -> 
         {                                                                                   /*<<<<---------------fix tabbing*/
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[0][1].setText(symbol(Integer.toString(count)));
         });
         //button5
         tiles[1][1].setOnAction(event -> 
         {  
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[1][1].setText(symbol(Integer.toString(count)));
         });
         //button6
         tiles[2][1].setOnAction(event -> 
         {  
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);                               /*<<<<---------------fix tabbing*/
            tiles[2][1].setText(symbol(Integer.toString(count)));
         });
         //button7
         tiles[0][2].setOnAction(event -> 
         {  
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[0][2].setText(symbol(Integer.toString(count)));
         });
         //button8
         tiles[1][2].setOnAction(event -> 
         {  
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[1][2].setText(symbol(Integer.toString(count)));
         });
         //button9
         tiles[2][2].setOnAction(event -> 
         {  
            count++;
            counter++;
            //track number of moves.
            System.out.println("Number of moves iterated: " + counter);
            tiles[2][2].setText(symbol(Integer.toString(count)));
         });                                                                                 /*<<<<---------------fix tabbing*/
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
      {  //maybe an image obj.
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