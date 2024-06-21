import java.util.ArrayList;
import java.util.Arrays;

public class AirportUtil {
    public static void sortTransport(Comparable[] transport){
            Arrays.sort(transport);
    }
    static String reportAll (Movable[] movables) {
        ArrayList<String> buffer = new ArrayList<>();
        for (Movable m: movables) {
            buffer.add(m.getCurrentLocation());
        }
        return String.join("\n",buffer);
    }
}
