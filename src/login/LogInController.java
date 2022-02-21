/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import javafx.scene.input.KeyCode;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

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

    public static String MD5(String s) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

    @FXML
    private void logInAction(ActionEvent event) {
        if (!unameText.getText().equals("") && !pwdText.getText().equals("")) {
            try {
                String mail = null;
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classenzimmer", "root", "");

                String username = unameText.getText();
                String password = MD5(pwdText.getText());
                Statement stm = connection.createStatement();
                String sql = "select * from login_info where email ='" + username + "' and password='" + password + "'";
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    Notifications.create()
                            .title("User Verified")
                            .text("Login Successful!")
                            .darkStyle()
                            .showInformation();
                    Parent root = FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
                    Scene scene = new Scene(root);
                    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    primaryStage.setTitle("ClassenZimmer");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setHeaderText("Warning!");
                    alert.setContentText("Wrong username or password!");
                    alert.show();
                }
                connection.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            if (unameText.getText().contains("")) {
                alert.setHeaderText("Information");
                alert.setContentText("Email field is empty\nDon't have and account?\nClick on Register");
                alert.show();
            } else if (pwdText.getText().contains("")) {
                alert.setHeaderText("Information");
                alert.setContentText("Password field is empty\nDon't have and account?\nClick on Register");
                alert.show();
            }
        }

    }

    @FXML
    private void regAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/register/register.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("ClassenZimmer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void forgotPassAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/passForgot/enterMail.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("ClassenZimmer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    private void unameKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            if (!unameText.getText().equals("")) {
                pwdText.requestFocus();
            }
        }
    }

    @FXML
    private void passKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            if (!pwdText.getText().equals("")) {
                loginbtn.fire();
            }
        }
    }

}
