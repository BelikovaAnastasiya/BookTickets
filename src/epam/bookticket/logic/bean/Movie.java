package epam.bookticket.logic.bean;

import java.io.Serializable;

public class Movie implements Serializable {
    private int idMovie;
    private String title;
    private int yearOfProduction;
    private String type;
    private String mainActors;

    public Movie() {
    }

    public Movie(int idMovie, String title, int yearOfProduction, String type, String mainActors) {
        this.idMovie = idMovie;
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.type = type;
        this.mainActors = mainActors;
    }

    public Movie(String title, int yearOfProduction, String type, String mainActors) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.type = type;
        this.mainActors = mainActors;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMainActors() {
        return mainActors;
    }

    public void setMainActors(String mainActors) {
        this.mainActors = mainActors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (idMovie != movie.idMovie) return false;
        if (yearOfProduction != movie.yearOfProduction) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (type != null ? !type.equals(movie.type) : movie.type != null) return false;
        return !(mainActors != null ? !mainActors.equals(movie.mainActors) : movie.mainActors != null);

    }

    @Override
    public int hashCode() {
        int result = idMovie;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + yearOfProduction;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (mainActors != null ? mainActors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idMovie=" + idMovie +
                ", title='" + title + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", type='" + type + '\'' +
                ", mainActors='" + mainActors + '\'' +
                '}';
    }
}
