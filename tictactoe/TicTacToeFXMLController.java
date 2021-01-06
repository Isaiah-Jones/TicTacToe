/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author I_jones2105
 */
public class TicTacToeFXMLController implements Initializable {
    
    private Label label;
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    
    int count = 0;
    String letter = null;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnPressedAction(ActionEvent event) {
        Button pressedButton = (Button) event.getTarget();
       

        /*Calculate whose turn it is, write the appropriate letter to the button*/
        if (count % 2 == 0) {
            letter = "X";
        } else {
            letter = "O";
        }
        

        /*Set the letter*/
        pressedButton.setText(letter);
        pressedButton.setFont(Font.font("System", FontWeight.BOLD, 48));

        /*Deactivate the button*/
        pressedButton.setDisable(true);

        /*Bump the count to switch players */
        count++;

        /*Show a dialog when game is over */
        if (checkForAWin()) {
            disableAllButtons();
            String title = "Game Over";
            String message = "Congrats! " + letter + " wins the game!";
            postMessage(title, message);
        } else if (count == 9) {
            String title = "Game Over";
            String message = "The game was a tie!";
            postMessage(title, message);
    }
    }
    @FXML
    private void menuExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void menuPlayAgainAction(ActionEvent event) {
        resetAllButtons();
        count = 0;
        letter = "";
    }

    @FXML
    private void menuAboutAction(ActionEvent event) {
        String title = "About Tic Tac Toe FX";
        String message = "This product is licensed by JoBro, Inc.";
            postMessage(title, message);
    }

    private boolean checkForAWin() {
         //row 1
        if (btn0.getText().equals(btn1.getText()) && btn1.getText().equals(btn2.getText()) && !btn0.getText().equals("")) {
            highlightTheWin(btn0, btn1, btn2);
            return true;
        }
        //row 2
        if (btn3.getText().equals(btn4.getText()) && btn4.getText().equals(btn5.getText()) && !btn3.getText().equals("")) {
            highlightTheWin(btn3, btn4, btn5);
            return true;
        }
        //row 3
        if (btn6.getText().equals(btn7.getText()) && btn7.getText().equals(btn8.getText()) && !btn6.getText().equals("")) {
            highlightTheWin(btn6, btn7, btn8);
            return true;
        }
        //column 1
        if (btn0.getText().equals(btn3.getText()) && btn3.getText().equals(btn6.getText()) && !btn0.getText().equals("")) {
            highlightTheWin(btn0, btn3, btn6);
            return true;
        }
        //column 2
        if (btn1.getText().equals(btn4.getText()) && btn4.getText().equals(btn7.getText()) && !btn1.getText().equals("")) {
            highlightTheWin(btn1, btn4, btn7);
            return true;
        }
        //column 3
        if (btn2.getText().equals(btn5.getText()) && btn5.getText().equals(btn8.getText()) && !btn2.getText().equals("")) {
            highlightTheWin(btn2, btn5, btn8);
            return true;
        }
        //diagonal 1
        if (btn0.getText().equals(btn4.getText()) && btn4.getText().equals(btn8.getText()) && !btn0.getText().equals("")) {
            highlightTheWin(btn0, btn4, btn8);
            return true;
        }
        //diagonal 2
        if (btn2.getText().equals(btn4.getText()) && btn4.getText().equals(btn6.getText()) && !btn2.getText().equals("")) {
            highlightTheWin(btn2, btn4, btn6);
            return true;
        }
        return false;
        }
    

    private void disableAllButtons() {
     btn0.setDisable(true);
     btn1.setDisable(true);
     btn2.setDisable(true);
     btn3.setDisable(true);
     btn4.setDisable(true);
     btn5.setDisable(true);
     btn6.setDisable(true);
     btn7.setDisable(true);
     btn8.setDisable(true);
}
    
    private void postMessage(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        //alert.setGraphic(new ImageView("images/icon.gif"));
        alert.showAndWait();
    }

    private void highlightTheWin(Button b1, Button b2, Button b3) {
        b1.setTextFill(Color.RED);
        b2.setTextFill(Color.RED);
        b3.setTextFill(Color.RED);
    
}

    private void resetAllButtons(){
        btn0.setDisable(false);
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        
        
        btn0.setTextFill(Color.BLACK);
        btn1.setTextFill(Color.BLACK);
        btn2.setTextFill(Color.BLACK);
        btn3.setTextFill(Color.BLACK);
        btn4.setTextFill(Color.BLACK);
        btn5.setTextFill(Color.BLACK);
        btn6.setTextFill(Color.BLACK);
        btn7.setTextFill(Color.BLACK);
        btn8.setTextFill(Color.BLACK);
    }
    
        public void start(Stage stage) throws Exception{
            Parent root =
                    FXMLLoader.load(getClass().getResource("TicTacToeFXML.fxml"));
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe");
            stage.getIcons().add(new Image("images/icon.gif"));
            stage.show();
        }
    
    
    }