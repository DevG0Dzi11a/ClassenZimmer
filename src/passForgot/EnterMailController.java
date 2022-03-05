/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passForgot;

import com.email.durgesh.Email;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class EnterMailController implements Initializable {

    @FXML
    private TextField emailText;
    @FXML
    private Button resetbtn;

    @FXML
    private Label enterEmailAlert;
    @FXML
    private PasswordField newpass;
    @FXML
    private PasswordField conpass;
    @FXML
    private PasswordField otpText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String OTPGenerator() {
        int n = 10;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @FXML
    private void resetAction(ActionEvent event) throws MessagingException, UnsupportedEncodingException, SQLException, ClassNotFoundException, IOException {

        Class.forName("com.mysql.jdbc.Driver");//Connection for database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classenzimmer", "sabbir", "sabbir@142");
        String emailCheck = emailText.getText();
        Statement estm = connection.createStatement();
        String esql = "select * from login_info where email ='" + emailCheck + "'";// check if the email is rregistered
        ResultSet ers = estm.executeQuery(esql);
        if (ers.next()) {//registered
            String otp = OTPGenerator();
            System.out.println(otp);
            Email sendMail = new Email("pubgbanc@gmail.com", "mshossain");
            sendMail.setFrom("pubgbanc@gmail.com", "ClassenZimmer");
            sendMail.setSubject("ClassenZimmer-Password Reset");
            sendMail.setText("This is your OTP. Use this to reset Password" + "\n" + "OTP: " + otp);
            sendMail.addRecipient(emailCheck);
            sendMail.send();
            String sql = "UPDATE login_info SET password = '', otp = '"+otp+"'"+" WHERE email = '"+emailCheck+"';";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
            Notifications.create()//push notification
                    .title("Email Sent")
                    .text("Email has successfully been sent")
                    .darkStyle()
                    .showConfirm();
            Parent root = FXMLLoader.load(getClass().getResource("/passForgot/resetPass.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("ClassenZimmer");
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {//not registered
            enterEmailAlert.setTextFill(Color.RED);
            enterEmailAlert.setText("Account not found! It seems there is no account asociated with this email. Please Register first.");
        }
    }

    @FXML
    private void sendKeyPressed(KeyEvent event) {//hen enter key is pressed
        if (KeyCode.ENTER == event.getCode()) {
            resetbtn.fire();
        }
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
    private void passKeyPressed(KeyEvent event) {
    }

}
