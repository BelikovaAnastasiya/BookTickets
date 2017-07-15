package classes.logic.bean;


import java.io.Serializable;

public class User implements Serializable{
    private int idUser;
    private int isAdmin;
    private String login;
    private String password;
    private String mail;
    private String name;
    private String surname;
    private String numberCreditCard;
    private String phone;
    private int sizeBenefit;

    public User() {
    }

    public User(int idUser, int isAdmin, String login, String mail,
                String password, String name, String numberCreditCard, String surname, String phone, int sizeBenefit) {
        this.idUser = idUser;
        this.isAdmin = isAdmin;
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.numberCreditCard = numberCreditCard;
        this.surname = surname;
        this.phone = phone;
        this.sizeBenefit = sizeBenefit;
    }

    public User(int isAdmin, String password, String login,
                String mail, String name, String surname, String numberCreditCard, String phone, int sizeBenefit) {
        this.isAdmin = isAdmin;
        this.password = password;
        this.login = login;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.numberCreditCard = numberCreditCard;
        this.phone = phone;
        this.sizeBenefit = sizeBenefit;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberCreditCard(String numberCreditCard) {
        this.numberCreditCard = numberCreditCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSizeBenefit() {
        return sizeBenefit;
    }

    public void setSizeBenefit(int sizeBenefit) {
        this.sizeBenefit = sizeBenefit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (isAdmin != user.isAdmin) return false;
        if (sizeBenefit != user.sizeBenefit) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (numberCreditCard != null ? !numberCreditCard.equals(user.numberCreditCard) : user.numberCreditCard != null)
            return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + isAdmin;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (numberCreditCard != null ? numberCreditCard.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + sizeBenefit;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", isAdmin=" + isAdmin +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", numberCreditCard='" + numberCreditCard + '\'' +
                ", phone='" + phone + '\'' +
                ", sizeBenefit=" + sizeBenefit +
                '}';
    }
}
