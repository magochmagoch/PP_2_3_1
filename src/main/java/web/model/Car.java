package web.model;

public class Car {
    private String firm;
    private String model;
    private int series;

    public Car() {

    }

    public Car(String firm, String model, int series) {
        this.firm = firm;
        this.model = model;
        this.series = series;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return firm + " " + model + " " + series;
    }
}
