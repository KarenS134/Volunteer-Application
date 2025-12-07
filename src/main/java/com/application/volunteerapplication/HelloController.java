package com.application.volunteerapplication;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;


public class HelloController implements Initializable{




    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(Event event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("application.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.sizeToScene();
        stage.setTitle("National Park Application");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private ComboBox<String> positions;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        String [] items = {"Organizer", "Chaperone","Animal Caretaker","Cleaner"};
        positions.getItems().addAll(items);
    }

    @FXML
    protected void onMapButtonClick(Event event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Map.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.sizeToScene();
        stage.setTitle("National Park Map");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void onEventButtonClick(Event event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Events.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.sizeToScene();
        stage.setTitle("National Park Events!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSubmitButtonClick(Event event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Submit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.sizeToScene();
        stage.setTitle("Congrats!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField myTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private Label messageSubmit;

    @FXML
    public void validateInputOnEnter(ActionEvent event) {
        String userInput = myTextField.getText();

        if (Email.isValidEmail(userInput)) {
            messageLabel.setText("Email is valid!");
            messageLabel.setStyle("-fx-text-fill: green");
            System.out.println("Console Message: email is valid");
        } else {
            messageLabel.setText("Input is NOT a valid email!");
            messageLabel.setStyle("-fx-text-fill: red;");
            System.out.println("Console Message: email is INVALID");
        }
    }




}
