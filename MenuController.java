package rls;

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

public class MenuController implements Initializable{

    @FXML
    private Button Salebtn;

    @FXML
    private Button Itemrecebutn;

    @FXML
    private Button Productbtn;

    @FXML
    void Itemrecebuton(ActionEvent event) {
         Parent root2 = null;
            try {
                root2 = FXMLLoader.load(getClass().getResource("Itemreceive.fxml"));
            } catch (IOException error) {
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE,null,error);
            }
                Scene scene = new Scene(root2);
                Stage stage = new Stage();
               stage.setTitle("Restaurant Management System");
                stage.setScene(scene);
                stage.show();

    }

    @FXML
    void Productbton(ActionEvent event) {
        Parent root1 = null;
            try {
                root1 = FXMLLoader.load(getClass().getResource("Product.fxml"));
            } catch (IOException error) {
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE,null,error);
            }
                Scene scene = new Scene(root1);
                Stage stage = new Stage();
               stage.setTitle("Restaurant Management System");
                stage.setScene(scene);
                stage.show();

    }

    @FXML
    void Salebton(ActionEvent event) {
         Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Sale.fxml"));
            } catch (IOException error) {
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE,null,error);
            }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
               stage.setTitle("Restaurant Management System");
                stage.setScene(scene);
                stage.show();
          

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
 
