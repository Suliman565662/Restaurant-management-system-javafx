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
public class UserItem {
    String recevno;
    String date;
    String itemn;
    String decrip;
    String quani;
    String buyingP;
    String sellingP;
    String totalp;

    public void UserItem(String recevno, String date, String itemn, String decrip, String quani, String buyingP, String sellingP, String totalp) {
        this.recevno = recevno;
        this.date = date;
        this.itemn = itemn;
        this.decrip = decrip;
        this.quani = quani;
        this.buyingP = buyingP;
        this.sellingP = sellingP;
        this.totalp = totalp;
    }


    public void setRecevno(String recevno) {
        this.recevno = recevno;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItemn(String itemn) {
        this.itemn = itemn;
    }

    public void setDecrip(String decrip) {
        this.decrip = decrip;
    }

    public void setQuani(String quani) {
        this.quani = quani;
    }

    public void setBuyingP(String buyingP) {
        this.buyingP = buyingP;
    }

    public void setSellingP(String sellingP) {
        this.sellingP = sellingP;
    }

    public void setTotalp(String totalp) {
        this.totalp = totalp;
    }

    public String getRecevno() {
        return recevno;
    }

    public String getDate() {
        return date;
    }

    public String getItemn() {
        return itemn;
    }

    public String getDecrip() {
        return decrip;
    }

    public String getQuani() {
        return quani;
    }

    public String getBuyingP() {
        return buyingP;
    }

    public String getSellingP() {
        return sellingP;
    }

    public String getTotalp() {
        return totalp;
    }
    
    
    
}
