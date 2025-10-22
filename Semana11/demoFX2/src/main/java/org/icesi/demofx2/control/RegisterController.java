package org.icesi.demofx2.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.icesi.demofx2.HelloApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField nameText;

    @FXML
    private TextField ageText;

    private PersonController controller;

    @FXML
    protected void onRegisterPerson(){
        String name = nameText.getText();
        int age = Integer.parseInt(ageText.getText());

        controller.registerPerson(name, age);
        HelloApplication.openWindow("list-person-view.fxml");
        System.out.println("RegisterController::onRegister >>" + controller);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = PersonController.getInstance();

    }
}