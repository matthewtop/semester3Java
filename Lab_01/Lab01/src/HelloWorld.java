import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Base64;
import static java.lang.System.out;

/**
 * Klasa HelloWorld jest pierwszym zadaniem laboratoryjnym.
 * Jej zadaniem jest dekodowanie ciągu znaków w formacie Base64 na UTF8
 *
 * @author Mateusz Tołpa tm53837
 * @version 1.0
 * @since 4.10.2023
 */

public class HelloWorld {
    static final String encoded = "V3lkemlhxYIgSW5mb3JtYXR5a2kgWmFjaG9kbmlvcG9tb3Jza2kgVW5pd2Vyc3l0ZXQgVGVjaG5vbG9naWN6bnkgdyBTemN6ZWNpbmll";

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        for (int index = 0; index < decoded.length(); index+=10) {
            @SuppressWarnings("unused")
            char character = decoded.charAt(index);
            buffer.append(character);
        }
        out.println(decoded.replaceAll(MessageFormat.format("[{0}]", buffer.toString()),"-"));
    }

}
