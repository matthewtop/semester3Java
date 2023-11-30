import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Test {
    public static void main(String[] args) {
        TreeSet map = new TreeSet();
        map.add("one");
        map.add("two");
        map.add("three");
        map.add("four");
        map.add("one");
        Iterator it = map.iterator();

        while (it.hasNext()){
            System.out.println(it.next()+" ")   ;
        }

//        Set s =new TreeSet();
//
//        s.add(new Integer(1));
//        s.add("2");
//        s.add(new Integer(3));
//        for (Iterator theIterator=s.iterator(); theIterator.hasNext();){
//            System.out.println(theIterator.next());
//        }
    }

}
