/*This program creates a Friendbook where you can create, delete, select to view, and display all friends.
 *Creator: Vivian Yang
 * Date: September 1, 2022
 */
package com.example.friendbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FriendController {//Fields for items in our scene
    public Button btnCreate;//Create friend button
    public Label instructCreText;
    public Label lblFName;
    public TextField txtfieldName;//get friend's name
    public Label lblFTrait;
    public TextField txfieldTrait;//gets friend's traits
    public ListView<Friend> friendsList = new ListView<>();//Displays all friend
    public Label lblFAge;
    public TextField txfieldAge;//get friend's age
    public Label lblNameDis;
    public Label lblTraitsDis;
    public Label displayName;//displays name (display friend)
    public Label displayTraits;//displays traits (display friend)
    public Label lblAgeDis;
    public Label displayAge;//displays age (display age)
    public Button btnDelete;//Delete friend button

    @FXML
    public void onCreateButtonClicked(ActionEvent actionEvent) {//Creates "friend" object
        String name = txtfieldName.getText();//name
        String trait = txfieldTrait.getText();//trait
        int age = Integer.parseInt(txfieldAge.getText());//age
        Friend temp = new Friend(name, trait, age);//friend template
        friendsList.getItems().add(temp);//adds friend to our list
        txtfieldName.clear();
        txfieldTrait.clear();
        txfieldAge.clear();
        btnDelete.setDisable(true);//disable the delete button under Display All tab
    }

    public void displayFriend(MouseEvent mouseEvent) {//View friend's information when their name in list is clicked on
        Friend temp;
        temp = friendsList.getSelectionModel().getSelectedItem();
        displayName.setText(temp.name);
        displayTraits.setText(temp.trait);
        displayAge.setText(Integer.toString(temp.getAge()));
        btnDelete.setDisable(false);//enables Delete Friend button
    }

    public void onDeleteButtonClicked(ActionEvent actionEvent) {//Deletes selected "friend" object
        final int selectedFrnd = friendsList.getSelectionModel().getSelectedIndex();
        friendsList.getItems().remove(selectedFrnd);
    }
}