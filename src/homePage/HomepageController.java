package homePage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HomepageController implements Initializable {

    @FXML
    private ImageView Menu;
    @FXML
    private ImageView Menuback;
    @FXML
    private AnchorPane slider;
    @FXML
    private ImageView Profileslide;
    @FXML
    private ImageView Profileslideback;
    @FXML
    private AnchorPane slider1;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider.setTranslateX(-298);
        Menu.setOnMouseClicked((MouseEvent event) -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-298);

            slide.setOnFinished(e -> {
                Menu.setVisible(false);
                Menuback.setVisible(true);

            });

        });
        Menuback.setOnMouseClicked((MouseEvent event) -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-298);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished(e -> {
                Menu.setVisible(true);
                Menuback.setVisible(false);

            });

        });
             
        slider1.setTranslateX(-300);
        Profileslide.setOnMouseClicked((MouseEvent event) -> {
            TranslateTransition slide1 = new TranslateTransition();
            slide1.setDuration(Duration.seconds(0.4));
            slide1.setNode(slider1);

            slide1.setToX(-100);
            slide1.play();

             slider1.setTranslateX(-300);

            slide1.setOnFinished(e -> {
                Profileslide.setVisible(false);
                Profileslideback.setVisible(true);

            });

        });
        Profileslideback.setOnMouseClicked((MouseEvent event) -> {
            TranslateTransition slide1 = new TranslateTransition();
            slide1.setDuration(Duration.seconds(0.4));
            slide1.setNode(slider1);

            slide1.setToX(-300);
            slide1.play();

            slider1.setTranslateX(-100);

            slide1.setOnFinished(e -> {
                Profileslide.setVisible(true);
                Profileslideback.setVisible(false);

            });

        });

    }

}
