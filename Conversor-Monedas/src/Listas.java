import java.util.List;

public class Listas {
    private List<Coin> coin;

    public Coin getCoin() {
        return (Coin) coin;
    }

    public void setCoin(List<Coin> coin) {
        this.coin = (List<Coin>) coin;
    }

    public Listas(List<Coin> coin) {
        this.coin = coin;
    }

    public Listas() {
    }
}
