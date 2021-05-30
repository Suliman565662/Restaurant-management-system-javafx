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

public class ProductController implements Initializable {

    @FXML
    private TextField productid;

    @FXML
    private TextField Productname;

    @FXML
    private TextField Unitprice;

    @FXML
    private TextField unitcost;

    @FXML
    private Button productlist;

    @FXML
    private Button productclear;

    @FXML
    private Button productRemove;
    
    @FXML
    private Button productupade;
    @FXML
    private TableView<ProductUser> productta;

    @FXML
    private TableColumn<ProductUser, String> productidta;

    @FXML
    private TableColumn<ProductUser, String> productnameta;

    @FXML
    private TableColumn<ProductUser, String> unitpriceta;

    @FXML
    private TableColumn<ProductUser, String> unitcpstta;

    @FXML
    private Button productadd;
    Connection Connect = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    @FXML
    void productaddc(ActionEvent event) {
        try {
            Connect = DBconnection.connect();
            String sql = "insert into  product (PRODUCTID, PRODUCTNAME, UNITPRICE, UNITCOST) values ( ?, ?, ?, ?)";
            pst = Connect.prepareStatement(sql);
            pst.setString(1, productid.getText());
            pst.setString(2, Productname.getText());
            pst.setString(3, Unitprice.getText());
            pst.setString(4, unitcost.getText());
           
            pst.execute();
             JOptionPane.showMessageDialog(null, "The data has been inserted Successfully.");

           }catch(Exception error){
                Logger.getLogger(Login1Controller.class.getName()).log(Level.SEVERE,null,error);
        
    }
    }
   

    @FXML
    void productclearC(ActionEvent event) {
        productid.clear();
        Productname.clear();
        Unitprice.clear();
        unitcost.clear();

    }
    ObservableList<ProductUser> ProductUser;

    @FXML
    void productlistC(ActionEvent event) {
      ProductUser =  DBconnection.ProductUser();
      productta.setItems(ProductUser);

    }

    @FXML
    void productremoveC(ActionEvent event) {
           try {
            String ID = productid.getText();
            
            Connect = DBconnection.connect();
            Statement pst = Connect.createStatement();            
            pst.executeUpdate("DELETE FROM product WHERE PRODUCTID='"+ID+"'");
            refresh();
            
            JOptionPane.showMessageDialog(null, "Removed Successfully");
            
      } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

    }
    }
    @FXML
    void productupdateC(ActionEvent event) {
        try {
            Connect = DBconnection.connect();

        String v2 = productid.getText();
	String v3 = Productname.getText();
	String v4 = Unitprice.getText();
	String v5 = unitcost.getText();
	
        
        String sql = "update product set PRODUCTID='"+v2+"', PRODUCTNAME='"+v3+"',UNITPRICE='"+v4+"',UNITCOST='"+v5+"' ";
        pst =Connect.prepareStatement(sql);
        pst.execute();      
        JOptionPane.showMessageDialog(null, "Updated");
        updatepro();

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }

    }


    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        updatepro();
    }
    public void updatepro(){
  productidta.setCellValueFactory(new PropertyValueFactory<ProductUser, String> ("proid"));
  productnameta.setCellValueFactory(new PropertyValueFactory<ProductUser, String> ("proname"));
  unitpriceta.setCellValueFactory(new PropertyValueFactory<ProductUser, String> ("unprice"));
  unitcpstta.setCellValueFactory(new PropertyValueFactory<ProductUser, String> ("uncost") );

      ProductUser =  DBconnection.ProductUser();
      productta.setItems(ProductUser);
    }

   
}
