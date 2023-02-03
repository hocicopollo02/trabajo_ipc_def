/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mercado;

import javafxmlapplication.*;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import seleccionPerfil.SeleccionPerfilController;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class MercadoController implements Initializable {

    @FXML
    private BorderPane panel;
    @FXML
    private Button agricultor_button;
    @FXML
    private Button cliente_button;
    
    /* Si esto es 0, acceso del cliente y si es 1 agricultor**/
    public int modo_acceso = 0;

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
    
}
