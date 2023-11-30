abstract class Bohater {
    public abstract void transform();
}
class Wojownik extends Bohater{
    @Override
    public void transform() {
        System.out.println("Jestem wojownikiem i walcze w zwarciu");
    }
}
class Mag extends Bohater{
    @Override
    public void transform() {
        System.out.println("Jestem magiem i swoimi czarami lecze wojownikow");
    }
}
public class Main{
    public static void main(String[] args) {
        Wojownik wojownik=new Wojownik();
        Mag mag=new Mag();

        wojownik.transform();
        mag.transform();

    }
}
