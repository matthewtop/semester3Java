import java.util.*;
public class Komparator {
    public static void main(String[] args) {
        TreeMap<String, String> carTreeMap = new TreeMap<>(new Porownywarka());

        carTreeMap.put("X", "Porsche");
        carTreeMap.put("Y","Lamborghini");
        carTreeMap.put("Z", "BMW");
        carTreeMap.put("A", "Ferrari");
        carTreeMap.put("D","Bugatti");
        carTreeMap.put("G", "Toyota");

        carTreeMap.put("X1", "Porsche");
        carTreeMap.put("Y2","Lamborghini");
        carTreeMap.put("Z3", "BMW");
        carTreeMap.put("A4", "Ferrari");
        carTreeMap.put("D5","Bugatti");
        carTreeMap.put("G6", "Toyota");

        for (Map.Entry<String,String> entry: carTreeMap.entrySet()){
            System.out.println(entry.getKey()+ " " +entry.getValue());
        }
    }
    static class Porownywarka implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            char a = str1.charAt(str1.length() - 1);
            char b = str2.charAt(str2.length() - 1);

            return Character.compare(a, b);
        }
    }
}
