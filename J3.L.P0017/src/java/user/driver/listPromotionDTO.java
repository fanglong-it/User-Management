/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.driver;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class listPromotionDTO implements Serializable{
    private String username;
    private String dateAdded;
    private String promotionId;
    private Float value;

    public listPromotionDTO() {
    }
    
    

    public listPromotionDTO(String username, String dateAdded, String promotionId) {
        this.username = username;
        this.dateAdded = dateAdded;
        this.promotionId = promotionId;
    }

    public listPromotionDTO(String username, String dateAdded, String promotionId, Float value) {
        this.username = username;
        this.dateAdded = dateAdded;
        this.promotionId = promotionId;
        this.value = value;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
    
    
    
    
    
}
