/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

import SignIn.SignInController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 *
 * @author svalero
 */
public class SignUpController implements Initializable {


 
    //properties to control valid fieds values. 
    private BooleanProperty validPassword;
    private BooleanProperty validEmail;
    private BooleanProperty equalPasswords;  

    //private BooleanBinding validFields;
    
    //When to strings are equal, compareTo returns zero
    private final int EQUALS = 0;  
    @FXML
    private TextField eemail;
    @FXML
    private PasswordField contraseña1;
    @FXML
    private PasswordField contraseña2;
    @FXML
    private Label lIncorrectEmail;
    @FXML
    private Label lIncorrectPassword;
    @FXML
    private Label lIncorrectPassword2;
    @FXML
    private Button botonAceptar;
    @FXML
    private ImageView bCancel;
    
   
    

    /**
     * Updates the boolProp to false.Changes to red the background of the edit. 
     * Makes the error label visible and sends the focus to the edit. 
     * @param errorLabel label added to alert the user
     * @param textField edit text added to allow user to introduce the value
     * @param boolProp property which stores if the value is correct or not
     */
    private void manageError(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.FALSE);
        showErrorMessage(errorLabel,textField);
        textField.requestFocus();
 
    }
    /**
     * Updates the boolProp to true. Changes the background 
     * of the edit to the default value. Makes the error label invisible. 
     * @param errorLabel label added to alert the user
     * @param textField edit text added to allow user to introduce the value
     * @param boolProp property which stores if the value is correct or not
     */
    private void manageCorrect(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.TRUE);
        hideErrorMessage(errorLabel,textField);
        
    }
    /**
     * Changes to red the background of the edit and
     * makes the error label visible
     * @param errorLabel
     * @param textField 
     */
    private void showErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(true);
        textField.styleProperty().setValue("-fx-background-color: #FCE5E0");    
    }
    /**
     * Changes the background of the edit to the default value
     * and makes the error label invisible.
     * @param errorLabel
     * @param textField 
     */
    private void hideErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(false);
        textField.styleProperty().setValue("");
    }

    private void checkEditEmail(){
    if(!Utils.checkEmail(eemail.textProperty().getValueSafe()))
    //Incorrect email
    manageError(lIncorrectEmail, eemail,validEmail );
    else
    manageCorrect(lIncorrectEmail, eemail,validEmail );
    }
    private void checkPassword(){
    if(!Utils.checkPassword(contraseña1.textProperty().getValueSafe()))
    //Incorrect email
    manageError(lIncorrectPassword, contraseña1,validPassword );
    else
    manageCorrect(lIncorrectPassword, contraseña1,validPassword);
    }
    private void checkEqualsPassword(){
        if(contraseña1.getText().equals(contraseña2.getText()) == false){
            
            equalPasswords.setValue(Boolean.FALSE);
            contraseña1.textProperty().setValue("");
            contraseña2.textProperty().setValue("");
            contraseña1.requestFocus();
            manageError(lIncorrectPassword2, contraseña2, equalPasswords);
        }else{
            manageCorrect(lIncorrectPassword2,contraseña2,equalPasswords); 
        }
    }
    
    

    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        validEmail = new SimpleBooleanProperty();
        validPassword = new SimpleBooleanProperty();   
        equalPasswords = new SimpleBooleanProperty();
        
        validPassword.setValue(Boolean.FALSE);
        validEmail.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
        
        eemail.focusedProperty().addListener((observable, oldValue, newValue)->{
        if(!newValue){ //focus lost.
            checkEditEmail();
        }
        });
        
        contraseña1.focusedProperty().addListener((observable, oldValue, newValue)->{
        if(!newValue){ //focus lost.
            checkPassword();
        }
        });
        
        contraseña2.focusedProperty().addListener((observable, oldValue, newValue)->{
        if(!newValue){ //focus lost.
            checkEqualsPassword();
        }
        });
           
                
        BooleanBinding validFields = Bindings.and(validEmail, validPassword)
                 .and(equalPasswords);
                
//        bCancel.setOnAction( (event)->{
//            bCancel.getScene().getWindow().hide();
//        });
    } 

    @FXML
    private void handleBAcceptOnAction(ActionEvent event) {
        contraseña1.textProperty().setValue("");
        contraseña2.textProperty().setValue("");
        eemail.textProperty().setValue("");
        
        validEmail.setValue(Boolean.FALSE);
        validPassword.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

    public void closeWindows() throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/SignIn/SignIn.fxml"));
        
        Parent root = cargar.load();
        
        SignInController controlador = cargar.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
        
//        stage.setOnCloseRequest(e -> controlador.closeWindows());
        
       
        contraseña1.getScene().getWindow().hide();
    }
   
    
}