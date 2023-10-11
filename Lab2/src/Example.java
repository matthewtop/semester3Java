class Animal {
    Animal( )
    {
        System.out.println( "Konstruktor Animal" );
    }
}

class Bird
{
    static Animal animal = new Animal( );
}
public class Example
{
    public static void main( String...args )
    {
        Bird bird1 = new Bird( );
        Bird bird2 = new Bird( );
    }
}