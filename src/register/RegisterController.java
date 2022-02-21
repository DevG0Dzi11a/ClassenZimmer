/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class RegisterController implements Initializable {

    String user = "";
    Alert alert = new Alert(AlertType.ERROR);

    @FXML
    private Button confirm;

    @FXML
    private PasswordField cpass;

    @FXML
    private Label cpassAlert;

    @FXML
    private TextField email;

    @FXML
    private Label emailAlert;

    @FXML
    private MenuItem menuS;

    @FXML
    private Label desAlert;

    @FXML
    private MenuItem menuT;

    @FXML
    private MenuButton menubtn;

    @FXML
    private PasswordField npass;

    @FXML
    private Label passAlert;

    @FXML
    private TextField uname;

    @FXML
    private Label unameAlert;

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
    private void confirmAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, Exception {
        if (!"".equals(uname.getText()) && !email.getText().equals("") && !npass.getText().equals("") && !cpass.getText().equals("") && !user.equals("")) {
            String mail = null;
            Class.forName("com.mysql.jdbc.Driver");//Connection for database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classenzimmer", "sabbir", "sabbir@142");
            String username = null;
            String usernameCheck = uname.getText();
            Statement ustm = connection.createStatement();
            String usql = "select * from login_info where username ='" + usernameCheck + "'";
            ResultSet urs = ustm.executeQuery(usql);
            if (urs.next()) {//check if username is already taken
                unameAlert.setTextFill(Color.RED);
                unameAlert.setText("*Username has already been taken!");
            } else {
                unameAlert.setText("");
                username = uname.getText();
                if (!email.getText().contains("@") && !email.getText().contains(".com")) {//checking valid email address
                    emailAlert.setTextFill(Color.RED);
                    emailAlert.setText("*Enter a valid email address");
                } else {
                    emailAlert.setText("");
                    String emailCheck = email.getText();
                    Statement estm = connection.createStatement();
                    String esql = "select * from login_info where email ='" + emailCheck + "'";
                    ResultSet ers = estm.executeQuery(esql);
                    if (ers.next()) {//check if email is already taken
                        emailAlert.setTextFill(Color.RED);
                        emailAlert.setText("*Email ID is already in use!");
                    } else {
                        emailAlert.setText("");
                        mail = email.getText();
                        if (npass.getText().equals(cpass.getText())) {// inserting the values in DB
                            String pwd = MD5(npass.getText());
                            String des = user;
                            String insert1 = "INSERT INTO login_info(username, email, password, des) VALUES('";
                            String insert2 = username + "','" + mail + "','" + pwd + "','" + des + "')";
                            String sql = insert1 + insert2;
                            Notifications.create()//push notification
                                    .title("Congratulations!")
                                    .text("Registration Successful!")
                                    .darkStyle()
                                    .showInformation();

                            Statement statement = connection.createStatement();
                            statement.executeUpdate(sql);
                            connection.close();
                            Parent root = FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
                            Scene scene = new Scene(root);
                            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            primaryStage.setTitle("ClassenZimmer");
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        } else {
                            cpassAlert.setTextFill(Color.RED);
                            cpassAlert.setText("*Password doesn't match!");
                        }
                    }
                }
            }

        } else {//if any field is empty
            if (uname.getText().equals("")) {
                unameAlert.setTextFill(Color.RED);
                unameAlert.setText("*Please enter a username!");
            }
            if (email.getText().equals("")) {
                emailAlert.setTextFill(Color.RED);
                emailAlert.setText("*Please enter an email!");
            }
            if (npass.getText().equals("")) {
                passAlert.setTextFill(Color.RED);
                passAlert.setText("*Please enter a new password!");
            }
            if (user.equals("")) {
                desAlert.setTextFill(Color.RED);
                desAlert.setText("*Please select your designation!");
            }
        }
    }

    @FXML
    private void teacherAction(ActionEvent event) {//Menu button selection
        menubtn.setTextFill(Color.BLUE);
        menubtn.setText("Teacher");
        user = "teacher";
    }

    @FXML
    private void studentAction(ActionEvent event) {//Menu button selection
        menubtn.setTextFill(Color.BLUE);
        menubtn.setText("Student");
        user = "student";
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/login/logIn.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("ClassenZimmer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void unameKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {//Enter key pressed
            if (!uname.getText().equals("")) {
                email.requestFocus();
            } else {
                unameAlert.setTextFill(Color.RED);
                unameAlert.setText("*Username cannot be empty!");
            }
        }
    }

    @FXML
    private void emailKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {//Enter key pressed
            if (!email.getText().equals("")) {
                npass.requestFocus();
            } else {
                emailAlert.setTextFill(Color.RED);
                emailAlert.setText("*Email cannot be empty!");
            }
        }
    }

    @FXML
    private void newpassKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {//Enter key pressed
            if (!npass.getText().equals("")) {
                cpass.requestFocus();
            } else {
                passAlert.setTextFill(Color.RED);
                passAlert.setText("*Password cannot be empty!");
            }
        }
    }

    @FXML
    private void conpassKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {//Enter key pressed
            if (!cpass.getText().equals("")) {
                confirm.fire();
            } else {
                cpassAlert.setTextFill(Color.RED);
                cpassAlert.setText("*Enter the password again!");
            }
        }
    }

}
