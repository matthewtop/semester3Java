public class Sandbox {

    public static void main(String[] args) {
        int i=10;
        long z=12;

//        i = z;
//        i(long) = z;
        z = i;
//        i = z(int);
        i = (int)z;

        System.out.println(i);
        System.out.println(z);
    }


}
