package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public Label instructLbl;
    public TextField textfieldGetPlayerMove = new TextField();
    public Label yourGuessLbl;
    public Button btnResult = new Button();
    public Label lblPrintResult = new Label();
    @FXML
    private Label welcomeText;

    @FXML
//    protected void onHelloButtonClick() {
//        lblPrintResult.setText("Welcome to JavaFX Application!");
//    }
    public void onResultButtonClick(ActionEvent actionEvent) {
        String input = textfieldGetPlayerMove.getText();

        int random =(int) ((Math.random() * 9) + 1);

        if (input.equals("Higher") && random > 5)
            lblPrintResult.setText("You Win!\tComputer's number: " + random);

        else if (input.equals("Lower") && random <5 )
            lblPrintResult.setText("You Win!\tComputer's number: " + random);

        else if (input.equals("Higher") && random < 5)
            lblPrintResult.setText("You Lose.\tComputer's number: " + random);

        else if (input.equals("Lower") && random > 5)
            lblPrintResult.setText("You Lose.\tComputer's number: " + random);

        else if (input.equals("Higher") && random == 5)
            lblPrintResult.setText("Draw.\tComputer's number: " + random);

        else if (input.equals("Lower") && random == 5)
            lblPrintResult.setText("Draw.\tComputer's number: " + random);

        else lblPrintResult.setText("Invalid Response. Please enter Higher or Lower.");


    }

    public void onAnswerTyped(ActionEvent actionEvent) {
//
//        String input = textfieldGetPlayerMove.getText();
//        System.out.println(input);
        btnResult.setDisable(false);
    }
}