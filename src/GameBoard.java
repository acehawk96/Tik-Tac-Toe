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
import javafx.scene.text.*;
import java.io.*; 
import java.util.*; 
/**
   This program is a Tick Tac Toe Game created for
   Computer Science 2 class Final Project at CCM.
   ---
   Final Project.
   ---
   10 Dec 2020  
*/
public class GameBoard
{     
   //Fields.
   protected int tileNum = 0; //numbers the tiles text.
   protected String symbol; //Holds symbol's X or O at a given time.
   protected boolean winner = false;
   protected boolean playerOne = false;
   protected boolean playerTwo = false; 
   protected int count = 0; //tracks number of moves(possibly corruption from passing). 
   protected int counter = 0; //tracks number of moves. no corruption.
   protected int row = 0; //row count in for loop.
   protected int col = 0; //column count in for loop.
   //Objects.
   protected Button[][] tiles = new Button[3][3]; //3 * 3 two sided array(Game's board tiles). 
   Text alert = new Text(""); //Text for game notification.

   /**
      playStage method creates secondary stage 
      (the game's board).
   */
   protected void playStage()
   {  
      //Variables
      winner = false; //change when playStage method call itself.
      tileNum = 0;
      
      //Set text. 
      this.alert.setText("Waiting for a Win...");
      
      //Create Objects.
      Stage secondaryStage = new Stage();
      BorderPane gameBorder = new BorderPane();
      GridPane centerGrid = new GridPane();
      GridPane bottomGrid = new GridPane();
      Button restartButton = new Button("Restart");
      Button endButton = new Button("End");
      HBox leftHbox = new HBox();
      HBox rightHbox = new HBox();
      GameFunctions function = new GameFunctions();
      
      //Build tiles with loop (3 * 3) add CSS to tiles.
      for(row = 0; row < tiles.length; row++) 
      {  
         for (col = 0; col < tiles[row].length; col++) 
         {  
            tileNum++;
            tiles[row][col] = new Button("" + tileNum);
            //Add CSS as tiles are made (Time Saver!).
            tiles[row][col].getStyleClass().addAll("gameButton");
            //console test for 9 Button objects made.
            System.out.println(tiles[row][col] + "\t");
         }
         System.out.println("-------------------- End of Row ---------------- ");
      }
      System.out.println("---------- Completed creating 9 Buttons with for loop! ----- ");
      
      //console test for checking winner variable.
      System.out.println("Is there a winner? "+ winner);
      
      //Build Board.
      gameBorder.setTop(alert);
      gameBorder.setCenter(centerGrid);
      gameBorder.setBottom(bottomGrid);
      gameBorder.setLeft(leftHbox);
      gameBorder.setRight(rightHbox);
      
      //Center Border Grid Layout (Use to add O's and X's later).
      centerGrid.add(tiles[0][0], 0, 0);
      centerGrid.add(tiles[1][0], 0, 1);
      centerGrid.add(tiles[2][0], 0, 2);
      centerGrid.add(tiles[0][1], 1, 0);
      centerGrid.add(tiles[1][1], 1, 1);
      centerGrid.add(tiles[2][1], 1, 2);
      centerGrid.add(tiles[0][2], 2, 0);
      centerGrid.add(tiles[1][2], 2, 1);
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
      gameBorder.setAlignment(alert, Pos.CENTER);
      
      //Add CSS.
      bottomGrid.getStyleClass().addAll("pane");
      scene2.getStylesheets().add("css/style.css");
      gameBorder.getStyleClass().addAll("centerAlign");
      alert.getStyleClass().addAll("centerAlign");
      
      //Add the scene2 to the secondaryStage.
      secondaryStage.setScene(scene2);
      
      //Set secondaryStage title.
      secondaryStage.setTitle("Tic Tac Toe");
      
      //Debugging
      bottomGrid.setGridLinesVisible(true);
      
      //Show the window.
      secondaryStage.show();
      
      //endButton Actions.
      endButton.setOnAction(event -> secondaryStage.close());
      
      //resetButton Actions.
      restartButton.setOnAction(event -> 
      {  
         //Open and close secondaryStage(Reset).
         playStage();
         secondaryStage.close();
      });

      
      /*  
         button#'s actions to change from X to O.  
      */
      
      //button1.
      tiles[0][0].setOnAction(event ->                                      
      {  
         count++;
         counter++;
         //track number of moves.                                                
         System.out.println("Number of moves iterated: " + counter);
         tiles[0][0].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();   
      });
      //button2.
      tiles[1][0].setOnAction(event -> 
      {                                                                       
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[1][0].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });
      //button3.
      tiles[2][0].setOnAction(event -> 
      {  
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[2][0].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });
      //button4.
      tiles[0][1].setOnAction(event -> 
      {                                                                                 
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[0][1].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });
      //button5.
      tiles[1][1].setOnAction(event -> 
      {  
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[1][1].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();         
      });
      //button6.
      tiles[2][1].setOnAction(event -> 
      {  
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);                            
         tiles[2][1].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });
      //button7.
      tiles[0][2].setOnAction(event -> 
      {  
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[0][2].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });
      //button8.
      tiles[1][2].setOnAction(event -> 
      {  
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[1][2].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });
      //button9.
      tiles[2][2].setOnAction(event -> 
      {  
         count++;
         counter++;
         //track number of moves.
         System.out.println("Number of moves iterated: " + counter);
         tiles[2][2].setText(function.symbol(Integer.toString(count)));
         //Check for win in matching rows or colunms.
         checkWin();
      });                                                                        
   }//End of playStage method.
     
   /**
      checkWin method iterates tiles arrays rows/columns/diagonals
      for a match in either X's or O's to determine win condition.
   */
   public void checkWin()
   {  
      //Check rows for matching win.
      for(this.row = 0; this.row < 3; this.row++)
      {
         if(this.tiles[this.row][0].getText() == this.tiles[this.row][1].getText() && this.tiles[this.row][0].getText() == this.tiles[row][2].getText())
         {
            System.out.println("--- Winner Found (rows)! ---");
            winner = true;
         }
      }
      //Check columns for matching win.
      for(this.col = 0; this.col < 3; this.col++)
      {
         if(this.tiles[0][this.col].getText() == this.tiles[1][this.col].getText() && this.tiles[0][this.col].getText() == this.tiles[2][this.col].getText())
         {
            System.out.println("--- Winner Found(columns)! ---");
            winner = true;
         }
      }
      //Check for win in matching Diagonally.
      if(this.tiles[1][1].getText() == this.tiles[0][0].getText() && this.tiles[1][1].getText() == this.tiles[2][2].getText())
      {
         System.out.println("--- Winner Found(diagonally)! ---");
         winner = true;
      }
      else if(this.tiles[1][1].getText() == this.tiles[0][2].getText() && this.tiles[1][1].getText() == this.tiles[2][0].getText())
      {
         System.out.println("--- Winner Found (diagonally)! ---");
         winner = true;
      }
      //Notify user of Win.
      if(winner == true)
      {  
         //For Debugging.
         System.out.println("--- Winner was set to true. Now in if statement. ---");
         //Set Text alert.
         winnerAlert(alert);
      }
   }//End of checkWin method.
   
   /**
      winnerAlert method sets Text alert to notify user of winner.
      @param Text alert : Text object's Reference variable alert.
   */
   public void winnerAlert(Text alert)
   {
      this.alert.setText("Winner Found!!!");
   }
}//End of Class.