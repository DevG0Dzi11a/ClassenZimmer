/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class LogInController implements Initializable {

    @FXML
    private ImageView image_logo;
    @FXML
    private TextField unameText;
    @FXML
    private Button loginbtn;
    @FXML
    private PasswordField pwdText;
    @FXML
    private Button regbtn;
    @FXML
    private Button forgotpassbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logInAction(ActionEvent event) {
    }

    @FXML
    private void regAction(ActionEvent event) {
    }

    @FXML
    private void forgotPassAction(ActionEvent event) {
    }
    
}
