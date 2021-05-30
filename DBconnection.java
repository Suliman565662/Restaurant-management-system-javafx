/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


/**
 *
 * @author 93780
 */
public class DBconnection {
    public static Connection connect() throws ClassNotFoundException {
        Connection Connect = null;
        
        try{
            
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/restaurant management system";
             String Username = "root";
             String password = "";
             
             Connect = DriverManager.getConnection(url, Username, password);
             System.out.println("connected");

        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        return Connect;
    }

      public static ObservableList<SaleUser> SaleUser(){
          ObservableList<SaleUser> list = FXCollections.observableArrayList();
          try{
      
           Connection conn = connect();
           
           PreparedStatement pst = conn.prepareStatement("select * from sale");
           
           ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               SaleUser sale = new SaleUser();
              int number = rs.getInt("ITEMNUMBER");
              String name = rs.getString("ITEMNAME");
              String price = rs.getString("ITEMPRICE");
              int Quantit = rs.getInt("QUANTITY");
              int total = rs.getInt("TOTAL");
              sale.setItemum(number);
              sale.setItemNa(name);
              sale.setItemprice(price);
              sale.setQuant(Quantit);
              sale.setTotalf(total);
              
              
              
             list.add(sale);
               
           }
          }catch(Exception ex){
              
          }
           return list;
             
      
      }
       public static ObservableList<ProductUser> ProductUser(){
          ObservableList<ProductUser> list1 = FXCollections.observableArrayList();
          try{
      
           Connection conn = connect();
           
           PreparedStatement pst1 = conn.prepareStatement("select * from product");
           
           ResultSet rs1 = pst1.executeQuery();
           
           while(rs1.next()){
              ProductUser product1 = new ProductUser();
              String id = rs1.getString("PRODUCTID");
              String prname = rs1.getString("PRODUCTNAME");
              String uprice = rs1.getString("UNITPRICE");
              String ucost = rs1.getString("UNITCOST");
              
              product1.setProid(id);
              product1.setProname(prname);
              product1.setUnprice(uprice);
              product1.setUncost(ucost);
              
              
              
             list1.add(product1);
               
           }
          }catch(Exception ex){
              
          }
           return list1;
       }
       public static ObservableList<UserItem> UserItem(){
       ObservableList<UserItem> list2 = FXCollections.observableArrayList();
          try{
      
           Connection conn = connect();
           
           PreparedStatement pst2 = conn.prepareStatement("select * from item");
           
           ResultSet rs2 = pst2.executeQuery();
           while(rs2.next()){
               UserItem useri = new UserItem();
               String re = rs2.getString("RECEVINGNO");
               String da = rs2.getString("DATE");
               String ite = rs2.getString("ITEMNO");
               String des = rs2.getString("DESCRIPTION");
               String Qu = rs2.getString("QUANTITY");
               String bup = rs2.getString("BUYINGPRICE");
               String sellp = rs2.getString("SELLINGPRICE");
               String to = rs2.getString("TOTALPRICE");
               
               useri.setRecevno(re);
               useri.setDate(da);
               useri.setItemn(ite);
               useri.setDecrip(des);
               useri.setQuani(Qu);
               useri.setBuyingP(bup);
               useri.setSellingP(sellp);
               useri.setTotalp(to);
           }
       
       } catch (Exception ex) {
           
       }
        return list2;
       }
}