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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
