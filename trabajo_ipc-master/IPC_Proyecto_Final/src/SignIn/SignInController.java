/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SignIn;

import SignUp.SignUpController;
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
import javafx.stage.Stage;
import seleccionPerfil.SeleccionPerfilController;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class SignInController implements Initializable {

    @FXML
    private Button noTengoB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IrASignUp(ActionEvent event) throws IOException {
        
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/SignUp/SignUp.fxml"));
        
        Parent root = cargar.load();
        
        SignUpController controlador = cargar.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("");
        
        stage.show();
        
        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindows();
            } catch (IOException ex) {
                Logger.getLogger(SeleccionPerfilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
       
        noTengoB.getScene().getWindow().hide();
    }

//    public void closeWindows() throws IOException {
//        FXMLLoader cargar = new FXMLLoader(getClass().getResource("/seleccionPerfil/seleccionPerfil.fxml"));
//        
//        Parent root = cargar.load();
//        
//        SeleccionPerfilController controlador = cargar.getController();
//        
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        
//        stage.setScene(scene);
//        
////        stage.setFullScreen(true);
////        stage.setFullScreenExitHint("");
//        
//        stage.show();
//        
////        stage.setOnCloseRequest(e -> controlador.closeWindows());
//        
//       
//        noTengoB.getScene().getWindow().hide();

//    }
    
}
