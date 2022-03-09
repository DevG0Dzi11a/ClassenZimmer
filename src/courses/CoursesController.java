/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import homePage.AddClassController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Sabbir
 */
public class CoursesController implements Initializable {

    @FXML
    private HBox hbox;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private GridPane gridpane;

    /**
     * Initializes the controller class.
     */
    private int column = 0, row = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            for (int i = 0; i < 20; i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/homePage/addClass.fxml"));
                AddClassController addclass = loader.getController();
                AnchorPane view = loader.load();
                if(column == 3)
                {
                    column = 0;
                    row++;
                }
                gridpane.add(view, column++, row);
                
                gridpane.setMaxWidth(Region.USE_PREF_SIZE);
                gridpane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridpane.setMinWidth(Region.USE_COMPUTED_SIZE);
                
                gridpane.setMaxHeight(Region.USE_PREF_SIZE);
                gridpane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridpane.setMinHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(view, new Insets(50));
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
