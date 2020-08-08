package co.ke.makamuevans.jav1.utilities.Helpers;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class ElmHelper {

    /**
     * Generate UUID
     * @param withdashes
     * @return
     */
    public static String generateUUID(Boolean withdashes) {
        final String uuid = UUID.randomUUID().toString();//.replace("-", "");
        return withdashes ? uuid : uuid.replace("-", "");
    }
}
