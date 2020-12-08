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

public class GameFunctions implements BackendGameInterface
{
   GameBoard game = new GameBoard();
     
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
}//End of class.