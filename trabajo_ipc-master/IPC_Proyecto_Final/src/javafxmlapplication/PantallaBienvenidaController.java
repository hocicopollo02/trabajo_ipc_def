/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Basket;
import model.User;
import seleccionPerfil.SeleccionPerfilController;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class PantallaBienvenidaController implements Initializable {

    @FXML
    private BorderPane panel;
    @FXML
    private Button agricultor_button;
    @FXML
    private Button cliente_button;
    
    /* Si esto es 0, acceso del cliente y si es 1 agricultor**/
    public int modo_acceso = 0;
    
    @FXML
    private TextField username_tf;
    @FXML
    private PasswordField password_tf;
    @FXML
    private Label error_label;
    @FXML
    private Button signUp_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        agricultor_button.setOnMouseClicked((a) -> {
        
            modo_acceso = 1;
            System.out.println(modo_acceso);
            agricultor_button.setStyle("-fx-background-color: lightgrey");
            agricultor_button.setStyle("-fx-text-fill: white");
            
        });
        
        cliente_button.setOnMouseClicked((a) -> {
        
            modo_acceso = 0;
            System.out.println(modo_acceso);
            cliente_button.setStyle("-fx-background-color: lightgrey");
            cliente_button.setStyle("-fx-text-fill: white");
            Basket cesta = null;
            
        });
        
        if(modo_acceso == 1) {
        
            cliente_button.setStyle("-fx-border-color: lightgrey");
            cliente_button.setStyle("-fx-text-fill: blue");
            
        } else {
            
            agricultor_button.setStyle("-fx-border-color: lightgrey");
            agricultor_button.setStyle("-fx-text-fill: blue");
            
        }
    }    

    private void seleccionarPerfil(ActionEvent event) throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/seleccionPerfil/seleccionPerfil.fxml"));
//        
        Parent root = cargar.load();
//        
//        SeleccionPerfilController controlador = cargar.getController();
//        
        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        
//        stage.setScene(scene);
//     
//        stage.show();
//        
//        stage.setOnCloseRequest(e -> {
//            try {
//                controlador.closeWindows();
//            } catch (IOException ex) {
//                Logger.getLogger(SeleccionPerfilController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        
//        perfilB.getScene().getWindow().hide();
        //BorderPane seleccion = (BorderPane) scene.getRoot().lookup("paneSelector");
        panel.setCenter(cargar.getRoot());
    }

    private void probador(ActionEvent event) throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/SignIn/SignIn.fxml"));

        Parent root = cargar.load();

        Scene scene = new Scene(root);

        panel.setCenter(cargar.getRoot());
    }

    @FXML
    private void seleccionar_sesion(MouseEvent event) {
        
    }

    @FXML
    private void irAMercado(ActionEvent event) throws IOException {
        
        if (User.checkNickName(username_tf.getText()) && User.checkPassword(password_tf.getText())) {
            Stage mercado = new Stage();
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/mercado/mercadoPantalla.fxml"));
            Parent root = miCargador.load();
            Scene scene = new Scene(root,510,315);
            mercado.setScene(scene);
        
            mercado.show();
        } else if (!User.checkNickName(username_tf.getText())) {
        
            error_label.setText("El username introducido no tiene entre 6 y 15 " +
"caracteres y contiene letras mayúsculas, minúsculas o " +
"los guiones ‘–‘ y ’_’");
            error_label.setVisible(true);
            
        } else if (!User.checkPassword(password_tf.getText())) {
        
            error_label.setText("La contraseña introducida no tiene entre 6 y 15 " +
"caracteres y contiene letras mayúsculas, minúsculas o " +
"los guiones ‘–‘ y ’_’");
            error_label.setVisible(true);
        }
    }

    @FXML
    private void irASignup(ActionEvent event) throws IOException{
        Stage signup = new Stage();
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/SignUp/SignUp.fxml"));
        Parent root = miCargador.load();
        Scene scene = new Scene(root,510,315);
        signup.setScene(scene);
        signup.show();
    }
    
}
