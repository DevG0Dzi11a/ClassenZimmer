/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class RegisterController implements Initializable {
    String user ;

    @FXML
    private TextField uname;
    @FXML
    private TextField email;
    @FXML
    private MenuItem menuT;
    @FXML
    private MenuItem menuS;
    @FXML
    private PasswordField npass;
    @FXML
    private PasswordField cpass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmAction(ActionEvent event) throws IOException {
        if (!"".equals(uname.getText()) && !email.getText().equals("") && !npass.getText().equals("") && !cpass.getText().equals("")) {
            if(user.equals("teacher")){
                
            }

        } else {
            if (uname.getText().equals("")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Please enter an username");
                alert.setTitle("Alert!");
                alert.setHeaderText("Invalid username!");
                alert.show();
            } else if (email.getText().equals("")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Please enter an email");
                alert.setTitle("Alert!");
                alert.setHeaderText("Invalid email address!");
                alert.show();
            }else if (npass.getText().equals("")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Please enter a password");
                alert.setTitle("Alert!");
                alert.setHeaderText("Invalid password!");
                alert.show();
            }else if (cpass.getText().equals("")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Please confirm the password");
                alert.setTitle("Alert!");
                alert.setHeaderText("Invalid password!");
                alert.show();
            }
        }
    }

    @FXML
    private void teacherAction(ActionEvent event) {
        user = "teacher";
    }

    @FXML
    private void studentAction(ActionEvent event) {
        user = "student";
    }

    @FXML
    private void backAction(ActionEvent event) {
    }

}
