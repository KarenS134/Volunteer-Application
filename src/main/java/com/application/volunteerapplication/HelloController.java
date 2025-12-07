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

/**
 * UML DIAGRAM:
 * -----------------------------
 * HelloController
 * -----------------------------
 * - myTextField : TextField
 * - messageLabel : Label
 * - messageSubmit : Label
 * - positions : ComboBox<String>
 * -----------------------------
 * # onHelloButtonClick(Event event) :void
 * + initialize(URL location, ResourceBundle resources) : void, throws IOException
 * # onMapButtonClick(Event event) : void, throws IOException
 * # onEventButtonClick(Event event) : void, throws IOException
 * # onSubmitButtonClick(Event event) : void, throws IOException
 * + validateInputOnEnter(ActionEvent event) : void,
 */

public class HelloController implements Initializable{




    @FXML
    private Label welcomeText;

    /*When clicking the Application button it will open up a new window for the user to start a new application*/
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

    /*This is where there is an Array where the user will be able to pick from their options of positions that are possible*/
    @Override
    public void initialize(URL location, ResourceBundle resources){
        String [] items = {"Organizer", "Chaperone","Animal Caretaker","Cleaner"};
        positions.getItems().addAll(items);
    }

    /*When in the Home scene the map buttons will open up a new window for the user to see the map of this National Park (Note: Note not a real national park)*/
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

    /*In the Home scene there is also a button to see the local events you can do in the national park so this here will open up the scene in a new window where users are able to see the many events hosted*/
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

    /*In the Volunteer Application scene when the user is ready to hit submit they will be shown a congratulation screen in where they have successfully submitted their form*/
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

    /**Instance Variables**/

    @FXML
    private TextField myTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private Label messageSubmit;

    /*In the Volunteer Application scene there is a combobox where the user is able to select their prefered postion in which they want to apply to*/
    @FXML
    private ComboBox<String> positions;

    /**Implementing Email.java class into the textfield so that when users input their email wrong it will give an invalid error and if it is valid it will give a success message**/
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
