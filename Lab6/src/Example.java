public class Example {
    public static void main(String[] args) {
        Example instancja = Example.getInstancja();
        instancja.cutMaterial();
    }
    private static Example instancja;
    private Example(){}

    public static Example getInstancja(){
        if (instancja==null){
            instancja=new Example();
        }
        return instancja;
    }

    public void cutMaterial(){
        System.out.println("Cut material");
    }
}
