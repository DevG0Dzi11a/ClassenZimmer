/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homePage;

import java.net.URL;
import java.util.ResourceBundle;
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
public class AddClassController implements Initializable {

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

    public String getCourseName() {
        return courseName.getText();
    }

    public void setCourseName(String courseName) {
        this.courseName.setText(courseName);
    }

    public String getAssignedBy() {
        return assignedBy.getText();
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy.setText(assignedBy);
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }
    
    private String classcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
