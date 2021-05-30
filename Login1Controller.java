/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rls;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class Login1Controller implements Initializable{

    
    @FXML
    private TextField username;

    @FXML
    private TextField PasswordLogin;

    @FXML
    private Button LoginButtion;

    @FXML
    private Hyperlink Regestration;
    
    
    Connection Connect = null;
    PreparedStatement pst = null;
    ResultSet rsts = null;
     
   
    
    @FXML
    Connection Loginc(ActionEvent event) throws SQLException {
        
        try {
            Connect = DBconnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "select * from rs where NAME = ? and PASSWORD = ?";
        pst = Connect.prepareStatement(sql);
        pst.setString(1, username.getText());
        pst.setString(2, PasswordLogin.getText());
        rsts = pst.executeQuery();
        
        if(rsts.next() == true){
            try {
                
                JOptionPane.showMessageDialog(null, "You have successfully SIGNED IN");
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException error) {
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE, null, error);
            }
        }else{
            JOptionPane.showMessageDialog(null, "You have entered Invalid Username or Password");
        }
        return Connect;

    }
    

    @FXML
    void Regestrationc(ActionEvent event)  {
        Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Regestration.fxml"));
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
 public void initialize(URL location, ResourceBundle resources) {
       
    }

}

    


