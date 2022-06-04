package peaksoft;

public class Countries {

    private int id;
    private String country;
    private String president;
    private String population;

    public Countries(int id, String country, String president, String population) {
        this.id = id;
        this.country = country;
        this.president = president;
        this.population = population;
    }

    public Countries() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "\n " + id +
                ",  " + country  +
                ", president : " + president +
                ", population - " + population;
    }
}
