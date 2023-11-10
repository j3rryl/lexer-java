package com.example;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PrimaryController {

    // @FXML
    // private void switchToSecondary() throws IOException {
    //     App.setRoot("secondary");
    // }

    @FXML
    Button tokenizeButton; 
       
    @FXML
    TextArea codeInput;  

    @FXML
    TextArea resultOutput;  
    
    @FXML
    private void initialize() {
        // Set up event handler for the tokenizeButton
        tokenizeButton.setOnAction(event -> tokenizeCode());
    }

    private void tokenizeCode() {
        String inputCode = codeInput.getText();
        Lexer lexer = new Lexer();
        ArrayList<String> tokens = lexer.tokenizeCode(inputCode);

        resultOutput.clear();
        for (String token : tokens) {
            resultOutput.appendText(token + "\n");
        }
    }
       
}
