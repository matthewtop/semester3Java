import java.io.Serializable;

public class Zebra implements Serializable {
    private static final long serialUID = 1L;
    private transient String name = "George";
    private static String birthPlace = "Africa";
    private transient Integer age;
    private java.util.List<Zebra> friends = new java.util.ArrayList<>();
    private Object tail = null;
    { age = 10;}
    public Zebra() {
        this.name = "Sophia";
    }

    public static void main(String[] args) {
        Zebra zebra = new Zebra();
    }
}
