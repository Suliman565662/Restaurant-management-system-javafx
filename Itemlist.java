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
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 93780
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Itemlist implements Initializable {

    @FXML
    private TableView<UserItem> itemlist;

    @FXML
    private TableColumn<UserItem, String> Recnota;

    @FXML
    private TableColumn<UserItem, String> dateta;

    @FXML
    private TableColumn<UserItem, String> itemnota;

    @FXML
    private TableColumn<UserItem, String> descripta;

    @FXML
    private TableColumn<UserItem, String> quantityta;

    @FXML
    private TableColumn<UserItem, String> buyingta;

    @FXML
    private TableColumn<UserItem, String> sellingta;

    @FXML
    private TableColumn<UserItem, String> totaltaa;

    @FXML
    private Button showlist;
    Connection Connect = null;

     ObservableList<UserItem> UserItem;
    @FXML
    void show(ActionEvent event) {
      UserItem =  DBconnection.UserItem();
      itemlist.setItems(UserItem);
        

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Recnota.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("recevno"));
         dateta.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("date"));
         itemnota.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("itemn"));
         descripta.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("decrip"));
         quantityta.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("quani"));
         buyingta.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("buyingP"));
         sellingta.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("sellingP"));
         totaltaa.setCellValueFactory(new PropertyValueFactory<UserItem, String> ("totalp"));
    }    
    
    
}
