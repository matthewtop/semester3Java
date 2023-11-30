public class Example {
    private final int wiek;
    private final String imie;

    public Example(int wiek, String imie){
        this.wiek=wiek;
        this.imie=imie;
    }

    public int getWiek(){
        return wiek;
    }
    public String getImie(){
        return imie;
    }

    public static void main(String[] args) {
        Example uczen1 = new Example(21,"Mateusz");
        System.out.println("Wiek: "+ uczen1.getWiek());
        System.out.println("Imie: "+ uczen1.getImie());
    }
}
