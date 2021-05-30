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
public class ProductUser {
    String proid;
    String proname;
    String unprice;
    String uncost;

 

   public void ProductUser(String proid, String proname, String unprice, String uncost) {
        this.proid = proid;
        this.proname = proname;
        this.unprice = unprice;
        this.uncost = uncost;
    }
    public String getProid() {
        return proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public void setUnprice(String unprice) {
        this.unprice = unprice;
    }

    public void setUncost(String uncost) {
        this.uncost = uncost;
    }

    public String getUnprice() {
        return unprice;
    }

    public String getUncost() {
        return uncost;
    }
    
}
