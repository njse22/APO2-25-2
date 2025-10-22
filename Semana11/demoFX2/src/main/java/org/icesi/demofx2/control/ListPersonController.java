package org.icesi.demofx2.control;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.icesi.demofx2.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ListPersonController implements Initializable {

    @FXML
    private TableView<Person> tableViewPerson;

    @FXML
    private TableColumn<Person, String> tableColumnName;

    @FXML
    private TableColumn<Person, Integer> tableColumnAge;

    private PersonController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = PersonController.getInstance();
        tableViewPerson.setItems(controller.getPeople());
        tableColumnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        tableColumnAge.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));

    }

    public void onInfo(){
        tableViewPerson.setOnMouseClicked( (event) -> {

            Person p = tableViewPerson.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Person Information");
            alert.setContentText(p.toString());
            alert.showAndWait();


        });
    }

    public void onDelete(){
        tableViewPerson.setOnMouseClicked( (event) -> {

            Person p = tableViewPerson.getSelectionModel().getSelectedItem();
            if(p != null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("DELETE");
                alert.setContentText("La persona: " + p.getName() + " será eliminada");
                alert.showAndWait();
                controller.getPeople().remove(p);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("DELETE");
                alert.setContentText("No se ha seleccionado ninguna persona");
                alert.showAndWait();
            }

        });
    }
}
