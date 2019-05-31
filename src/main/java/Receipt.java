import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private String type;
    private int number;
    private List<Vat> vats =new ArrayList<>();

    public Receipt(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Vat> getVats() {
        return vats;
    }

    public void setVats(List<Vat> vats) {
        this.vats = vats;
    }
}
