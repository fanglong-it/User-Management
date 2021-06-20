/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.driver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import user.connect.connectDB;

/**
 *
 * @author Admin
 */
public class promotionDAO implements Serializable {

    public List<promotionDTO> getAllPromotion() throws SQLException, NamingException {
        List<promotionDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "Select PromotionID, Name\n"
                        + "from tblPromotion";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    String promotionId = rs.getString("PromotionID");
                    String Name = rs.getString("Name");
                    promotionDTO dto = new promotionDTO(promotionId, Name);
                    list.add(dto);
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

}
