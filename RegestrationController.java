package rls;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class RegestrationController {

    @FXML
    private TextField user;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Email;

    @FXML
    private TextField Phone;

    @FXML
    private Button Signup;

    @FXML
    private Button Back;
    
    Connection Connect = null;
    PreparedStatement pst;

    @FXML
    void SignupCR(ActionEvent event) {
        
        try{
            
        
        Connect = DBconnection.connect();
        String sql = "insert into rs (NAME, EMAIL, PASSWORD, PHONE) values (?, ?, ?, ?)";
        pst = Connect.prepareStatement(sql);
        pst.setString(1, user.getText());
        pst.setString(2, Email.getText());
        pst.setString(3, Password.getText());
        pst.setString(4, Phone.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Inserted");
       
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null, Ex);
        }
    }
    
 public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    }