/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seleccionPerfil;

import SignIn.SignInController;
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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxmlapplication.PantallaBienvenidaController;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class SeleccionPerfilController implements Initializable {

    private Label tituloL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IrASignIn(ActionEvent event) throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/SignIn/SignIn.fxml"));
        
        Parent root = cargar.load();
        
        SignInController controlador = cargar.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("");
        
        stage.show();
        
//        stage.setOnCloseRequest(e -> {
//            try {
//                controlador.closeWindows();
//            } catch (IOException ex) {
//                Logger.getLogger(SeleccionPerfilController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        
       
        tituloL.getScene().getWindow().hide();
    }

    public void closeWindows() throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/javafxmlapplication/pantallaBienvenida.fxml"));
        
        Parent root = cargar.load();
        
        PantallaBienvenidaController controlador = cargar.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("");
        
        stage.show();
            
        tituloL.getScene().getWindow().hide();
    }
    
}
