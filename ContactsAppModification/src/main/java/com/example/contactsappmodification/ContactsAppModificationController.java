package com.example.contactsappmodification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ContactsAppModificationController {
    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();

    private Contact contactSelected;

    @FXML
    private ListView<Contact> contactsListView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField pathImageTextField;

    @FXML
    void addContactButtonPressed(ActionEvent event) {
        Contact newContact = new Contact();
        newContact.setFirstName(firstNameTextField.getText().trim());
        newContact.setLastName(lastNameTextField.getText().trim());
        newContact.setEmail(emailTextField.getText().trim());
        newContact.setPhoneNumber(phoneNumberTextField.getText().trim());
        newContact.setPathToImage(pathImageTextField.getText().trim());

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int n = contacts.size();
        char value = newContact.getLastName().toLowerCase().charAt(0);

        int i;
        for (i = n - 1; (i >= 0 && alphabet.indexOf(contacts.get(i).getLastName().toLowerCase().charAt(0)) > alphabet.indexOf(value)); i--)
            if (alphabet.indexOf(contacts.get(i).getLastName().toLowerCase().charAt(0)) > alphabet.indexOf(value)) {

            } else {
                contacts.add(i + 1, contacts.get(i));
            }


        contacts.add(i + 1, newContact);
    }

    @FXML
    void deleteContactButtonPressed(ActionEvent event) {
        contacts.remove(contactSelected);
    }

    @FXML
    void updateContactButtonPressed(ActionEvent event) {
        contactSelected.setFirstName(firstNameTextField.getText().trim());
        contactSelected.setLastName(lastNameTextField.getText().trim());
        contactSelected.setEmail(emailTextField.getText().trim());
        contactSelected.setPhoneNumber(phoneNumberTextField.getText().trim());
        contactSelected.setPathToImage(pathImageTextField.getText().trim());
    }

    public void initialize() {

        ImageView imageView = new ImageView();

        contacts.add(new Contact("Jasur", "Sadiev", "jasursadiev2002@gmail.com", "0700298507", "https://media-exp1.licdn.com/dms/image/C4D03AQEWlGGmHLuM4Q/profile-displayphoto-shrink_800_800/0/1648549183753?e=2147483647&v=beta&t=NOMqTkhq4SsDARIDiehBwzkS3JzjB7DGAdB_L-jxHyo"));
        contactsListView.setItems(contacts);
        Image icon = new Image(contacts.get(0).getPathToImage());
        Image[] listOfImages = new Image[contacts.size()];
        int i = 0;
        for (Contact contact : contacts) {
            listOfImages[i] = new Image(contact.getPathToImage());
            i++;
        }

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        contactsListView.setCellFactory(param -> new ListCell<>() {
            public void updateItem(Contact name, boolean empty) {
                super.updateItem(name, empty);
                if (empty || name == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    imageView.setImage(new Image(name.getPathToImage()));
                    setText(name.getLastName());
                    setGraphic(imageView);
                }
            }
        });

        contactsListView.getSelectionModel().selectedItemProperty().addListener((arg0, oldValue, newValue) -> {
            contactSelected = newValue;
            firstNameTextField.setText(newValue.getFirstName());
            lastNameTextField.setText(newValue.getLastName());
            emailTextField.setText(newValue.getEmail());
            phoneNumberTextField.setText(newValue.getPhoneNumber());
            pathImageTextField.setText(newValue.getPathToImage());
        });
    }

}