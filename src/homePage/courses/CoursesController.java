/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homePage.courses;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class CoursesController implements Initializable {

    private GridPane gridpane;
    @FXML
    private AnchorPane newclass;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> taskColumn;
    @FXML
    private TableColumn<?, ?> dueDateColumn;
    @FXML
    private Label courseName;
    @FXML
    private Label assignedBy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/homePage/courses/courses.fxml"));
            AnchorPane view = loader.load();

            gridpane.add(view, 1, 1);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
