public class JavaApplication {
    enum Color {
        RED, GREEN, BLUE;
    }
    public static void main( String[ ] args ) {
        for( Color value : Color.values( ) ) {
            System.out.println( value.toString( ) );
        }
    }
}
