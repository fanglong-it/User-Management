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
public class userDTO implements Serializable {

    private String username;
    private String password;
    private String photoCode;
    private String name;
    private String email;
    private String phoneNumber;
    private int role;
    private String status;

    public userDTO() {
    }

    public userDTO(String username, String password, String name, int role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public userDTO(String username, String password, String photoCode, String name, String email, String phoneNumber, int role, String status) {
        this.username = username;
        this.password = password;
        this.photoCode = photoCode;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoCode() {
        return photoCode;
    }

    public void setPhotoCode(String photoCode) {
        this.photoCode = photoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
