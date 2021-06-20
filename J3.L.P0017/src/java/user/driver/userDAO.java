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
public class userDAO implements Serializable {

    public userDTO checkLogin(String Username, String Password) throws SQLException, NamingException {
        userDTO user = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "SELECT Username, Password, PhotoCode, Name, Email, PhoneNumber, Role, Status  \n"
                        + "FROM tblUser \n"
                        + "WHERE Username = ? AND Password = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, Username);
                pst.setString(2, Password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("Username");
                    String password = "********";
                    String photoCode = rs.getString("PhotoCode");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    int role = Integer.parseInt(rs.getString("Role"));
                    String status = rs.getString("Status");
                    user = new userDTO(username, password, photoCode, name, email, phoneNumber, role, status);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return user;
    }

    public String checkRole(String username) throws SQLException, NamingException {
        String result = "";
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "Select Role \n"
                        + "From tblUser \n"
                        + "Where Username = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if(rs.next()) {
                    result = rs.getString("Role");
                    return result;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                rs.close();
            }
        }
        return result;
    }

    public List<userDTO> getListUser() throws SQLException, NamingException {
        List<userDTO> listUser = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "Select Username, Password, PhotoCode, Name, Email, PhoneNumber, Role, Status\n"
                        + "from tblUser";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = "********";
                    String photoCode = rs.getString("PhotoCode");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    int role = Integer.parseInt(rs.getString("Role"));
                    String status = rs.getString("Status");
                    userDTO user = new userDTO(username, password, photoCode, name, email, phoneNumber, role, status);
                    listUser.add(user);
                }

            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return listUser;
    }

    public List<userDTO> getListUserByRole(String Role) throws SQLException, NamingException {
        List<userDTO> listUser = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "SELECT Username, Password, PhotoCode, Name, Email, PhoneNumber, Role, Status\n"
                        + "FROM tblUser \n"
                        + "WHERE Role like ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, Role);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = "********";
                    String photoCode = rs.getString("PhotoCode");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    int role = Integer.parseInt(rs.getString("Role"));
                    String status = rs.getString("Status");
                    userDTO user = new userDTO(username, password, photoCode, name, email, phoneNumber, role, status);
                    listUser.add(user);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return listUser;
    }

    public List<userDTO> getListUserByName(String Username) throws SQLException, NamingException {
        List<userDTO> listUser = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "SELECT Username, Password, PhotoCode, Name, Email, PhoneNumber, Role, Status\n"
                        + "FROM tblUser \n"
                        + "WHERE Name like ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + Username + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = "********";
                    String photoCode = rs.getString("PhotoCode");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    int role = Integer.parseInt(rs.getString("Role"));
                    String status = rs.getString("Status");
                    userDTO user = new userDTO(username, password, photoCode, name, email, phoneNumber, role, status);
                    listUser.add(user);
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return listUser;
    }

    public int deleteStatus(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "UPDATE tblUser\n"
                        + "SET Status = ? \n"
                        + "WHERE Username = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, "InActive");
                pst.setString(2, username);
                if (pst.executeUpdate() > 0) {
                    result = 1;
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
        return result;
    }

    public userDTO getUserInfo(String Username) throws SQLException, NamingException {
        userDTO user = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "SELECT Username, Password, PhotoCode, Name, Email, PhoneNumber, Role, Status \n"
                        + "FROM tblUser \n"
                        + "WHERE Username = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, Username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String photoCode = rs.getString("PhotoCode");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    int role = Integer.parseInt(rs.getString("Role"));
                    String status = rs.getString("Status");
                    user = new userDTO(username, password, photoCode, name, email, phoneNumber, role, status);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return user;
    }

    public int updateUserInfo(userDTO user) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "UPDATE tblUser\n"
                        + "SET Password = ? , PhotoCode = ? ,Name = ? ,Email = ? ,"
                        + "PhoneNumber = ? ,Role = ? ,Status = ? \n"
                        + "WHERE Username = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, user.getPassword());
                pst.setString(2, user.getPhotoCode());
                pst.setString(3, user.getName());
                pst.setString(4, user.getEmail());
                pst.setString(5, user.getPhoneNumber());
                pst.setInt(6, user.getRole());
                pst.setString(7, user.getStatus());
                pst.setString(8, user.getUsername());
                if(pst.executeUpdate() > 0){
                    result = 1;
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
        return result;
    }
    
    public int insertUser(userDTO user) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = connectDB.makeConnect();
            if (con != null) {
                String sql = "insert into tblUser values(?, ?, ?, ?, ?, ?, ?, ?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getPhotoCode());
                pst.setString(4, user.getName());
                pst.setString(5, user.getEmail());
                pst.setString(6, user.getPhoneNumber());
                pst.setInt(7, user.getRole());
                pst.setString(8, user.getStatus());
                if(pst.executeUpdate() > 0){
                    result = 1;
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
        return result;
    }
    
    public boolean checkExist(String Username) throws SQLException, NamingException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = connectDB.makeConnect();
            if (cn != null) {
                String sql = "SELECT Username, Password, PhotoCode, Name, Email, PhoneNumber, Role, Status\n"
                        + "FROM tblUser \n"
                        + "WHERE Username like ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, Username);
                rs = pst.executeQuery();
                if(rs.next()){
                    return true;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

}
