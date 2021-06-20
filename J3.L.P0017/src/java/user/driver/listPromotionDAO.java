/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.driver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
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
public class listPromotionDAO implements Serializable {

    public boolean checkExistInListPromotion(String username) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "Select Username,DateAdded,PromotionID, Value\n"
                        + "from tblListPromotion\n"
                        + "where Username = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public int insertUserPromotion(listPromotionDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        Long milis = System.currentTimeMillis();
        int result = 0;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "INSERT into tblListPromotion values(? , ? , ? , ? )";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getUsername());
                Date date = new Date(milis);
                pst.setDate(2, date);
                pst.setString(3, dto.getPromotionId());
                pst.setFloat(4, dto.getValue());
                result = pst.executeUpdate();
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<listPromotionDTO> getListPromotion(String PromotionId) throws NamingException, SQLException {
        List<listPromotionDTO> listPromotion = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "Select Username,DateAdded,PromotionID,Value\n"
                        + "from tblListPromotion \n"
                        + "where PromotionId = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, PromotionId);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String dateAdded = rs.getString("DateAdded");
                    String promotionId = rs.getString("PromotionID");
                    Float Value = Float.parseFloat(rs.getString("Value"));
                    listPromotionDTO dto = new listPromotionDTO(username, dateAdded, promotionId, Value);
                    listPromotion.add(dto);
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
        return listPromotion;
    }

    public List<listPromotionDTO> getAllListPromotion() throws NamingException, SQLException {
        List<listPromotionDTO> listPromotion = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "Select Username,DateAdded,PromotionID,Value\n"
                        + "from tblListPromotion \n";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String dateAdded = rs.getString("DateAdded");
                    String promotionId = rs.getString("PromotionID");
                    Float Value = Float.parseFloat(rs.getString("Value"));
                    listPromotionDTO dto = new listPromotionDTO(username, dateAdded, promotionId, Value);
                    listPromotion.add(dto);
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
        return listPromotion;
    }

    public int updateUserPromotion(listPromotionDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "UPDATE tblListPromotion SET Value = ? WHERE Username = ? ;";
                pst = con.prepareStatement(sql);
                pst.setFloat(1, dto.getValue());
                pst.setString(2, dto.getUsername());
                result = pst.executeUpdate();
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public int deleteUserPromotion(listPromotionDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "Delete tblListPromotion WHERE Username = ? ;";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getUsername());
                result = pst.executeUpdate();
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

  
    public List<listPromotionDTO> viewHistoryPromotionDate(String Date) throws SQLException, NamingException {
        List<listPromotionDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "SELECT Username, DateAdded, PromotionID, Value\n"
                        + "FROM tblListPromotion\n"
                        + "where DateAdded between '2020-01-01' and ? ;";
                pst = con.prepareStatement(sql);
                pst.setString(1, Date);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String Username = rs.getString("Username");
                    String DateAdded = rs.getString("DateAdded");
                    String PromotionId = rs.getString("PromotionID");
                    Float Value = rs.getFloat("Value");
                    listPromotionDTO dto = new listPromotionDTO(Username, DateAdded, PromotionId, Value);
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
    
    public listPromotionDTO getUserPromotion(String Username) throws NamingException, SQLException {
        listPromotionDTO dto = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "Select Username,DateAdded,PromotionID,Value\n"
                        + "from tblListPromotion \n"
                        + "where Username = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, Username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("Username");
                    String dateAdded = rs.getString("DateAdded");
                    String promotionId = rs.getString("PromotionID");
                    Float Value = Float.parseFloat(rs.getString("Value"));
                    dto = new listPromotionDTO(username, dateAdded, promotionId, Value);
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
        return dto;
    }
    

}
