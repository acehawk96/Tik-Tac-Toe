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
/**
   This program is a Tick Tac Toe Game created for
   Computer Science 2 class Final Project at CCM.
   ---
   Final Project.
   ---
   10 Dec 2020  
*/
public class GameFunctions implements BackendGameInterface
{
   GameBoard game = new GameBoard();
     
   /**
      symbol method returns either X or O to Button tile array.
      @param String c : count Integer after conversion to String.
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