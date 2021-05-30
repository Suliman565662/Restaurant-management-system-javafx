/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 93780
 */
public class RLS extends Application {
    
   public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login1.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Resturant Management System");
        stage.setScene(scene);
        stage.show();
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
