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
import java.sql.Statement;
import static java.time.zone.ZoneRulesProvider.refresh;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ItemreceiveController implements Initializable {

    @FXML
    private Button itemlist;

    @FXML
    private Button clearitem;

    @FXML
    private Button removeitem;

    @FXML
    private Button upadeitem;

    @FXML
    private Button additem;

    @FXML
    private TextField recnumber;

    @FXML
    private DatePicker Date;

    @FXML
    private TextField itemno;

    @FXML
    private TextField Dec;

    @FXML
    private TextField quan;

    @FXML
    private TextField buyingp;

    @FXML
    private TextField sallingp;

    @FXML
    private TextField totalp;

    Connection Connect = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    

    

    @FXML
    void additemC(ActionEvent event) {
                  
        try {
            Connect = DBconnection.connect();
            String sql = "insert into  item (RECEVINGNO, DATE, ITEMNO, DESCRIPTION, QUANTITY, BUYINGPRICE, SELLINGPRICE,TOTALPRICE) values ( ?, ?, ?, ?, ?,?,?,?)";
            pst = Connect.prepareStatement(sql);
            pst.setString(1, recnumber.getText());
            pst.setString(2, ((TextField)Date.getEditor()).getText());
            pst.setString(3, itemno.getText());
            pst.setString(4, Dec.getText());
            pst.setString(5, quan.getText());
            pst.setString(6, buyingp.getText());
            pst.setString(7, sallingp.getText());
            pst.setString(8, totalp.getText());
            
            
            pst.execute();
             JOptionPane.showMessageDialog(null, "The data has been inserted Successfully.");

           }catch(Exception error){
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE,null,error);
        
    }

    }

    @FXML
    void clearitemC(ActionEvent event) {
        recnumber.clear();
        itemno.clear();
        Dec.clear();
        quan.clear();
        buyingp.clear();
        sallingp.clear();
        totalp.clear();

    }

    @FXML
    void itemlistc(ActionEvent event) {
                
    Parent root3 = null;
        try {
            root3 = FXMLLoader.load(getClass().getResource("Itemlist.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                Scene scene = new Scene(root3);
                Stage stage = new Stage();
                stage.setTitle("Restaurant Management System");
                stage.setScene(scene);
                stage.show();
          

    }

    @FXML
    void removeitemC(ActionEvent event) {
        try {
            String reno = recnumber.getText();
            
            Connect = DBconnection.connect();
            Statement pst = Connect.createStatement();            
            pst.executeUpdate("DELETE FROM item WHERE RECEVINGNO='"+reno+"'");
            refresh();
            
            JOptionPane.showMessageDialog(null, "Removed Successfully");
            
      } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
}

    }

    @FXML
    void updateitemC(ActionEvent event) {
         try {
            Connect = DBconnection.connect();

        String v3 = recnumber.getText();
	String v4 = ((TextField)Date.getEditor()).getText();
	String v5 = itemno.getText();
	String v6 = Dec.getText();
	String v7 = quan.getText();
        String v8 = buyingp.getText();
        String v9 = sallingp.getText();
        String v10 = totalp.getText();
        
        
        String sql = "update item set RECEVINGNO='"+v3+"', DATE='"+v4+"',ITEMNO='"+v5+"',DESCRIPTION='"+v6+"',QUANTITY='"+v7+"',BUYINGPRICE='"+v8+"',SELLINGPRICE='"+v9+"',TOTALPRICE='"+v10+"' ";
        pst =Connect.prepareStatement(sql);
        pst.execute();      
        JOptionPane.showMessageDialog(null, "Updated");
       

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
