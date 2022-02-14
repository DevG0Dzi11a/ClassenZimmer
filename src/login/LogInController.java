/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private void regAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/register/reg_options.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("ClassenZimmer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void forgotPassAction(ActionEvent event) {
    }
    
}
