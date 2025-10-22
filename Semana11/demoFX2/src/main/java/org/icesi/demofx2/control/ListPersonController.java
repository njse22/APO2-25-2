package org.icesi.demofx2.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.icesi.demofx2.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ListPersonController implements Initializable {

    @FXML
    private TextArea listTextArea;

    private PersonController controller;

    public void listPeople(){
        String msj = "";
        for (Person p: controller.getPeople()){
            msj += p + "\n";
        }
        listTextArea.setText(msj);
        System.out.println("ListPersonController::listPeople >>>" + controller);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = PersonController.getInstance();
        listPeople();
    }
}
