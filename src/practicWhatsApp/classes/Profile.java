package practicWhatsApp.classes;

import practicWhatsApp.enam.Photo;
import practicWhatsApp.enam.Status;

import java.util.List;

public class Profile {
    private int id;
    private String phoneNumber;
    private String userName;
    private String password;
    private Status status;
    private String photo;
    private List<Profile> massage;
    private String contName;
    private String contNumber;

    public Profile() {

    }


    public Profile(int id, String phoneNumber, String userName, String password, Status status, String photo, List<Profile> massage, String contName, String contNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.photo = photo;
        this.massage = massage;
        this.contName = contName;
        this.contNumber = contNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getPhoto(Photo atWork) {
        return null;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Profile> getMassage() {
        return massage;
    }

    public void setMassage(List<Profile> massage) {
        this.massage = massage;
    }

    public String getPhoto() {
        return photo;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    @Override
    public String toString() {
        return "\n  Profile: " + "\n    id: " + id + "\n    Phone number: " + phoneNumber + "\n    User name: " + userName + "\n    Password: " + password + "\n    Status: " + status + "\n    Photo: " + photo + "\n    Massage: " + massage + "\n";
    }
}
