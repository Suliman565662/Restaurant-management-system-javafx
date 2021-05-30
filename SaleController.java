/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rls;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.JOptionPane;

public class SaleController implements Initializable {

    @FXML
    private TextField itemnumber;

    @FXML
    private TextField itemname;

    @FXML
    private TextField itemprice;

    @FXML
    private TextField quantity;

    @FXML
    private TextField total;

    @FXML
    private Button salelist;

    @FXML
    private Button clear;

    @FXML
    private Button Remove;

    @FXML
    private Button upade;

    @FXML
    private Button addsale;
    
    Connection Connect = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    
      @FXML
    private TableView<SaleUser> tablesale;
    
     @FXML
    private TableColumn<SaleUser, Integer> Itemnumberta;

    @FXML
    private TableColumn<SaleUser, String> itemnameta;

    @FXML
    private TableColumn<SaleUser, String> itempriceta;

    @FXML
    private TableColumn<SaleUser, Integer> quantityta;

    @FXML
    private TableColumn<SaleUser, Integer> totalta;

    @FXML
    void RemoveC(ActionEvent event) {
             try {
            String number = itemnumber.getText();
            
            Connect = DBconnection.connect();
            Statement pst = Connect.createStatement();            
            pst.executeUpdate("DELETE FROM sale WHERE ITEMNUMBER='"+number+"'");
            refresh();
            
            JOptionPane.showMessageDialog(null, "Removed Successfully");
            
      } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
}

    }

    

    @FXML
    void addsaleC(ActionEvent event) {
               
        try {
            Connect = DBconnection.connect();
            String sql = "insert into  sale (ITEMNUMBER, ITEMNAME, ITEMPRICE, QUANTITY, TOTAL) values ( ?, ?, ?, ?, ?)";
            pst = Connect.prepareStatement(sql);
            pst.setString(1, itemnumber.getText());
            pst.setString(2, itemname.getText());
            pst.setString(3, itemprice.getText());
            pst.setString(4, quantity.getText());
            pst.setString(5, total.getText());
            
            pst.execute();
             JOptionPane.showMessageDialog(null, "The data has been inserted Successfully.");

           }catch(Exception error){
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE,null,error);
        
    }
    }
    @FXML
    void clearC(ActionEvent event) {
        itemnumber.clear();
	itemname.clear();
	itemprice.clear();
	quantity.clear();
	total.clear();

    }
    ObservableList<SaleUser> SaleUser;

    @FXML
    void salelistC(ActionEvent event) {
      SaleUser =  DBconnection.SaleUser();
      tablesale.setItems(SaleUser);
      

    }

    @FXML
    void updateC(ActionEvent event) {
         try {
            Connect = DBconnection.connect();

        String v1 = itemnumber.getText();
	String v2 = itemname.getText();
	String v3 = itemprice.getText();
	String v4 = quantity.getText();
	String v5 = total.getText();
        
        String sql = "update sale set ITEMNUMBER='"+v1+"', ITEMNAME='"+v2+"',ITEMPRICE='"+v3+"',QUANTITY='"+v4+"',TOTAL='"+v5+"' ";
        pst =Connect.prepareStatement(sql);
        pst.execute();      
        JOptionPane.showMessageDialog(null, "Updated");
        update();

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }

    }


    @Override
  public void initialize(URL url, ResourceBundle rb) {
    
  update();
 
      
    } 
  public void update(){
  Itemnumberta.setCellValueFactory(new PropertyValueFactory<SaleUser, Integer> ("itemum"));
  itemnameta.setCellValueFactory(new PropertyValueFactory<SaleUser, String> ("itemNa"));
  itempriceta.setCellValueFactory(new PropertyValueFactory<SaleUser, String> ("Itemprice"));
  quantityta.setCellValueFactory(new PropertyValueFactory<SaleUser, Integer> ("Quant") );
  totalta.setCellValueFactory(new PropertyValueFactory<SaleUser, Integer> ("Totalf") );
        
      SaleUser =  DBconnection.SaleUser();
      tablesale.setItems(SaleUser);
  }

    
    
}
