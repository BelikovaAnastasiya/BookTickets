package epam.bookticket.logic.bean;


import java.io.Serializable;

public class Review implements Serializable{
    private int idReview;
    private int rating;
    private String textReview;
    private String loginUser;
    private String movieTitle;

    public Review() {
    }

    public Review(int idReview, int rating, String loginUser, String textReview, String movieTitle) {
        this.idReview = idReview;
        this.rating = rating;
        this.loginUser = loginUser;
        this.textReview = textReview;
        this.movieTitle = movieTitle;
    }

    public Review(int rating, String textReview, String loginUser, String movieTitle) {
        this.rating = rating;
        this.textReview = textReview;
        this.loginUser = loginUser;
        this.movieTitle = movieTitle;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String textReview) {
        this.textReview = textReview;
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

        Review review = (Review) o;

        if (idReview != review.idReview) return false;
        if (rating != review.rating) return false;
        if (textReview != null ? !textReview.equals(review.textReview) : review.textReview != null) return false;
        if (loginUser != null ? !loginUser.equals(review.loginUser) : review.loginUser != null) return false;
        if (movieTitle != null ? !movieTitle.equals(review.movieTitle) : review.movieTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReview;
        result = 31 * result + rating;
        result = 31 * result + (textReview != null ? textReview.hashCode() : 0);
        result = 31 * result + (loginUser != null ? loginUser.hashCode() : 0);
        result = 31 * result + (movieTitle != null ? movieTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "idReview=" + idReview +
                ", rating=" + rating +
                ", textReview='" + textReview + '\'' +
                ", loginUser='" + loginUser + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
