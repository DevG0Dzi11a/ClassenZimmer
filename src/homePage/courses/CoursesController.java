/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homePage.courses;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class CoursesController implements Initializable {

    @FXML
    private Label assignedBy;

    @FXML
    private Label courseName;

    @FXML
    private TableColumn<?, ?> dueDateColumn;

    @FXML
    private AnchorPane newclass;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> taskColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Label getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String value) {
        this.assignedBy.setText(value);
    }

    public Label getCourseName() {
        return courseName;
    }

    public void setCourseName(String value) {
        this.courseName.setText(value);
    }
    
    
}
