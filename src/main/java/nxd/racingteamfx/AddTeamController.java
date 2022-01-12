package nxd.racingteamfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.stream.Stream;

public class AddTeamController {

    @FXML
    private void teamToMainScene(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;

        Button clickedBtn = (Button) event.getSource();

        stage = (Stage) clickedBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        // Add CSS
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void saveNewTeam(ActionEvent actionEvent) {

    }

    public void toggleActiveState(MouseEvent event) {
        HBox box = (HBox) event.getSource();
        Stream stream = box.getStyleClass().stream().filter(s -> s.equals("answerActive"));
        if(stream.toArray().length == 0){
            box.getStyleClass().add("answerActive");
        }else {
            box.getStyleClass().remove("answerActive");
        }

    }
}
