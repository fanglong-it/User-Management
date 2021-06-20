/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.util;

import java.util.List;
import user.driver.listPromotionDTO;

/**
 *
 * @author Admin
 */
public class util {
    
    public boolean checkListExist(List<listPromotionDTO> list, String Username){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().equals(Username)){
                return true;
            }
        }
        return false;
    }
}
