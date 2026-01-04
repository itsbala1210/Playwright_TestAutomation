package Utilities;


import org.apache.commons.codec.binary.Base64;

public class EncryptionUtil {
    public static String encodeKey(String key) {
        byte[] encodedKey = Base64.encodeBase64(key.getBytes());
        return new String(encodedKey);
    }

    public static String decodeKey(String key) {
        byte[] decodedKey = Base64.decodeBase64(key);
        return new String(decodedKey);
    }
}
