package epam.bookticket.logic.bean;

import java.io.Serializable;

public class Benefit implements Serializable {

    private int idBenefit;
    private String typeBenefit;
    private int sizeBenefit;

    public Benefit(){}

    public Benefit(int idBenefit, String typeBenefit, int sizeBenefit) {
        this.idBenefit = idBenefit;
        this.typeBenefit = typeBenefit;
        this.sizeBenefit = sizeBenefit;
    }

    public Benefit(String typeBenefit, int sizeBenefit) {
        this.typeBenefit = typeBenefit;
        this.sizeBenefit = sizeBenefit;
    }

    public int getIdBenefit() {
        return idBenefit;
    }

    public void setIdBenefit(int idBenefit) {
        this.idBenefit = idBenefit;
    }

    public String getTypeBenefit() {
        return typeBenefit;
    }

    public void setTypeBenefit(String typeBenefit) {
        this.typeBenefit = typeBenefit;
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

        Benefit benefit = (Benefit) o;

        if (idBenefit != benefit.idBenefit) return false;
        if (sizeBenefit != benefit.sizeBenefit) return false;
        return !(typeBenefit != null ? !typeBenefit.equals(benefit.typeBenefit) : benefit.typeBenefit != null);

    }

    @Override
    public int hashCode() {
        int result = idBenefit;
        result = 31 * result + (typeBenefit != null ? typeBenefit.hashCode() : 0);
        result = 31 * result + sizeBenefit;
        return result;
    }

    @Override
    public String toString() {
        return "Benefit{" +
                "idBenefit=" + idBenefit +
                ", typeBenefit='" + typeBenefit + '\'' +
                ", sizeBenefit=" + sizeBenefit +
                '}';
    }
}
