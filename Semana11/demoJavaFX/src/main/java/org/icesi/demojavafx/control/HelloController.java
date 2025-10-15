package org.icesi.demojavafx.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label labelInputName;
    @FXML
    private Label labelOutputName;
    @FXML
    private TextField textFieldInputText;

    private PersonController personController;

    @FXML
    public void onCreatePerson() {
        String name = textFieldInputText.getText();
        personController.createPerson(name);

        String listPeople = "";
        for (int i = 0; i < personController.getPeople().size(); i++) {
            listPeople += personController.getPeople().get(i).getName() + "\n";
        }

        labelOutputName.setText(listPeople);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        personController = new PersonController();

    }
}