/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzstructure;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author max
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField numberTextField;
    @FXML
    private Button calculateButton;
    @FXML
    private TextArea textArea;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberTextField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                numberTextField.setText(oldValue);
            }
        });
    }    

    @FXML
    private void calculateSeries(ActionEvent event) {
        if (numberTextField.getText().equals("")) {
            textArea.setText("Please introduce a number");
        } else {
            int n = Integer.parseInt(numberTextField.getText());
            textArea.setText(n + "");
            while (n > 1) {
                textArea.appendText(" -> ");
                int q = n / 8;
                int r = n % 8;
                switch (r) {
                    case 1:
                        n = 6 * q + 1;
                        break;
                    case 3:
                        n = 6 * 2 * q + 5;
                        break;
                    case 7:
                        n = 6 * (2 * q + 1) + 5;
                        break;
                    case 5:
                        n = 2 * q + 1;
                        break;
                    default:
                        n = n / 2;
                        break;
                }
                textArea.appendText(n + "");
            }
        }
    }
    
}
