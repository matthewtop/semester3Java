public class OddCounter {
    public static void main(String[] args) {
        int wynik=0;
        for(int i = 1; i<100; i++){
            if(i%2==1){
                wynik+=i;
            }
        }
        System.out.println("Suma liczb nieparzystych z przedzialu <1;99> wynosi "+wynik);
    }
}
