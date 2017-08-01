package epam.bookticket.logic.bean;

import java.io.Serializable;

public class Reservation implements Serializable {
    private int idReservation;
    private String date;
    private double price;
    private String numberOfTheChair;
    private int countTickets;
    private String cinemaTitle;
    private boolean isPaid;
    private String movieTitle;
    private String loginUser;

    public Reservation() {
    }

    public Reservation(int idReservation, String date, double price, String numberOfTheChair,
                       int countTickets, String cinemaTitle, boolean isPaid, String movieTitle,
                       String loginUser) {
        this.idReservation = idReservation;
        this.date = date;
        this.price = price;
        this.numberOfTheChair = numberOfTheChair;
        this.countTickets = countTickets;
        this.cinemaTitle = cinemaTitle;
        this.isPaid = isPaid;
        this.movieTitle = movieTitle;
        this.loginUser = loginUser;
    }

    public Reservation(String date, double price, String numberOfTheChair,
                       int countTickets, String cinemaTitle, boolean isPaid,
                       String movieTitle, String loginUser) {
        this.date = date;
        this.price = price;
        this.numberOfTheChair = numberOfTheChair;
        this.countTickets = countTickets;
        this.cinemaTitle = cinemaTitle;
        this.isPaid = isPaid;
        this.movieTitle = movieTitle;
        this.loginUser = loginUser;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNumberOfTheChair() {
        return numberOfTheChair;
    }

    public void setNumberOfTheChair(String numberOfTheChair) {
        this.numberOfTheChair = numberOfTheChair;
    }

    public int getCountTickets() {
        return countTickets;
    }

    public void setCountTickets(int countTickets) {
        this.countTickets = countTickets;
    }

    public String getCinemaTitle() {
        return cinemaTitle;
    }

    public void setCinemaTitle(String cinemaTitle) {
        this.cinemaTitle = cinemaTitle;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (idReservation != that.idReservation) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (countTickets != that.countTickets) return false;
        if (isPaid != that.isPaid) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (numberOfTheChair != null ? !numberOfTheChair.equals(that.numberOfTheChair) : that.numberOfTheChair != null)
            return false;
        if (cinemaTitle != null ? !cinemaTitle.equals(that.cinemaTitle) : that.cinemaTitle != null) return false;
        if (movieTitle != null ? !movieTitle.equals(that.movieTitle) : that.movieTitle != null) return false;
        if (loginUser != null ? !loginUser.equals(that.loginUser) : that.loginUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idReservation;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (numberOfTheChair != null ? numberOfTheChair.hashCode() : 0);
        result = 31 * result + countTickets;
        result = 31 * result + (cinemaTitle != null ? cinemaTitle.hashCode() : 0);
        result = 31 * result + (isPaid ? 1 : 0);
        result = 31 * result + (movieTitle != null ? movieTitle.hashCode() : 0);
        result = 31 * result + (loginUser != null ? loginUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", date=" + date +
                ", price=" + price +
                ", numberOfTheChair='" + numberOfTheChair + '\'' +
                ", countTickets=" + countTickets +
                ", cinemaTitle='" + cinemaTitle + '\'' +
                ", isPaid=" + isPaid +
                ", movieTitle='" + movieTitle + '\'' +
                ", loginUser='" + loginUser + '\'' +
                '}';
    }
}
