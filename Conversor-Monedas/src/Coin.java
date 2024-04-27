public class Coin {
    String name;
    double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Coin() {
    }

    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }
}
