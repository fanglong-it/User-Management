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
public class promotionDTO implements Serializable{
    private String promotionId;
    private String Name;

    public promotionDTO(String promotionId, String Name) {
        this.promotionId = promotionId;
        this.Name = Name;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

   
}
