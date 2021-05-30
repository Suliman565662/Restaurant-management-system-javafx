/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rls;



/**
 *
 * @author 93780
 */
public class SaleUser {

    int itemum;
    String itemNa;
    String Itemprice;
    int Quant;

    int Totalf;



    public void SaleUser(int itemum, String itemNa, String Itemprice, int Quant, int Totalf) {
        this.itemum = itemum;
        this.itemNa = itemNa;
        this.Itemprice = Itemprice;
        this.Quant = Quant;
        this.Totalf = Totalf;
    }

    public int getItemum() {
        return itemum;
    }

    public String getItemNa() {
        return itemNa;
    }

    public String getItemprice() {
        return Itemprice;
    }

    public int getQuant() {
        return Quant;
    }

    public int getTotalf() {
        return Totalf;
    }

    public void setItemum(int itemum) {
        this.itemum = itemum;
    }

    public void setItemNa(String itemNa) {
        this.itemNa = itemNa;
    }

    public void setItemprice(String Itemprice) {
        this.Itemprice = Itemprice;
    }

    public void setQuant(int Quant) {
        this.Quant = Quant;
    }

    public void setTotalf(int Totalf) {
        this.Totalf = Totalf;
    }

    

   
    

}
