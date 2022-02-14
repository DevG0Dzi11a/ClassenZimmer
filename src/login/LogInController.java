/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.io.IOException;
import java.net.URL;
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classenzimmer", "root", "");

            String username = unameText.getText();
            String password = pwdText.getText();

            Statement stm = con.createStatement();
            String sql = "select * from login_info where username ='" + username + "' and password='" + password + "'";
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Right uname pass");
                Parent root = FXMLLoader.load(getClass().getResource("/homePage/homepage.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setTitle("ClassenZimmer");
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                unameText.setText("");
                pwdText.setText("");

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
