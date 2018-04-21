import java.io.File;
import java.util.Map;

public interface Handler {

    Map process(Map m, File file);

}