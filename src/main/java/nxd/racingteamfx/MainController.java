package nxd.racingteamfx;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainController {

    @FXML
    private Button addDriverButton, addTeamButton;

    @FXML
    // Now add observability by wrapping it with ObservableList.
    public ObservableList<Driver> driversCollection = FXCollections.observableList(new ArrayList());

    @FXML
    private void sceneSwitcher(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;

        if(event.getSource()==addDriverButton) {
            stage = (Stage) addDriverButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("add-driver-view.fxml"));
            Scene scene = new Scene(root);
            // Add CSS
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if(event.getSource()==addTeamButton){
            stage = (Stage) addTeamButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("add-team-view.fxml"));
            Scene scene = new Scene(root);
            // Add CSS
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }else{
            System.out.println("SceneSwitcher in MainController called from ");
            System.out.println(event.getSource().toString());
        }

    }

    @FXML
    protected void initialize() {
        System.out.println("Initialize called");
        ArrayList<Driver> drivers = DBTasks.getAllDrivers();
        this.driversCollection.addAll(drivers);
    }

    public void mouseClickedEvent(MouseEvent event) {
        System.out.println("clicked! " + event.getClickCount());

        if (event.getClickCount() == 2) {
            Node node = ((Node) event.getTarget()).getParent();
            TableRow row;
            if (node instanceof TableRow) {
                row = (TableRow) node;
            } else {
                // clicking on text part
                row = (TableRow) node.getParent();
            }
            Driver d = (Driver) row.getItem();
            System.out.println(d.getLastname());
            System.out.println(d.getId());
        }
    }
}