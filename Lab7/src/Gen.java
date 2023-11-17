class GenMain{
    public static void main(String[] args) {
        Gen<Integer> integerGen = new Gen<>(999);
        integerGen.showType();

        Gen<Character> characterGen = new Gen<>('X');
        characterGen.showType();

        Gen<Double> doubleGen = new Gen<>(3.14);
        doubleGen.showType();
    }
}
public class Gen<T>{
     T object;

     Gen(T o){
         object=o;
     }

     T getObject(){
         return object;
     }
     void showType(){
         System.out.println("Naleze do klasy: "+ object.getClass().getName());
     }
}


