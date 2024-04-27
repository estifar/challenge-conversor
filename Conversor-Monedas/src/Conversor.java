public class Conversor {
    double ARS;
    double USD;
    double COP;
    double BRL;

    public Conversor() {
    }

    public Conversor(double ARS, double USD, double COP, double BRL) {
        this.ARS = ARS;
        this.USD = USD;
        this.COP = COP;
        this.BRL = BRL;
    }

    public double getARS() {
        return ARS;
    }

    public void setARS(double ARS) {
        this.ARS = ARS;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getCOP() {
        return COP;
    }

    public void setCOP(double COP) {
        this.COP = COP;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }
}


