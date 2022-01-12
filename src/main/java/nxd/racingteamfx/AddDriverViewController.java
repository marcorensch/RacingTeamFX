package nxd.racingteamfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.util.ArrayList;

public class AddDriverViewController {

    @FXML
    private Button mainViewButton;

    @FXML
    private TextField firstname, lastname, number;
    @FXML
    private ChoiceBox<Team>teamSelect;

    @FXML
    // Now add observability by wrapping it with ObservableList.
    public ObservableList<Team> teamsCollection = FXCollections.observableList(new ArrayList());

    @FXML
    private void driverToMainScene(ActionEvent event) throws Exception{
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

    @FXML
    protected void initialize() {
        System.out.println("Initialize for Driver called");
        ArrayList<Team> teams = DBTasks.getAllTeams();
        this.teamsCollection.addAll(teams);
        teamSelect.getItems().addAll(teamsCollection);
    }

    public void saveNewDriver(ActionEvent event) throws Exception {

        if(firstname.getText().isEmpty() || lastname.getText().isEmpty() || number.getText().isEmpty() || teamSelect.getValue() == null){
            Notifications.create().title("Missing Data").text("All fields are required!").darkStyle().position(Pos.TOP_RIGHT).showError();
            return;
        }

        String fn = firstname.getText();
        String ln = lastname.getText();
        int num = Integer.parseInt(number.getText());
        int team = teamSelect.getValue().getKey();



        System.out.println(fn + " " + ln + " " + num + " " + team);

        int response = DBTasks.addDriver(fn,ln,num,team);

        System.out.println(response);

        this.driverToMainScene(event);
    }
}
