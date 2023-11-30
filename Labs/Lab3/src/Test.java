class Test {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5};
        int suma = 0;
//        for(int i = 0; i<a.length; i++){
//            suma += a[i];
//        }
        for (int i:a)
        {
            suma += i;
        }
        System.out.println(suma);
    }
}