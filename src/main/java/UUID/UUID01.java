package UUID;

/*
    123e4567-e89b-42d3-a456-556642440000
    xxxxxxxx-xxxx-Bxxx-Axxx-xxxxxxxxxxxx

    A represents the variant which determines the layout of the UUID
    B represents the version. The version in the mentioned UUID (value of B) is 4

    These are 5 different versions for variant 2 UUIDs:
    Time Based (UUIDv1),
    DCE Security (UUIDv2),
    Name Based (UUIDv3 and UUIDv5),
    Random (UUIDv4).

 */


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUID01 {

    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

 public static void printar(UUID uuid) {
        int variant = uuid.variant();
        int version = uuid.version();
        System.out.println(String.format("UUID: %s", uuid.toString()));
        System.out.println(String.format("Variant: %d", variant));
        System.out.println(String.format("Version: %d", version));
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("Starting");
        UUID01.version4RandomDefault();
        UUID01.generateSpecificTypeUUID();
        UUID01.version3();
        UUID01.version5();
        UUID01.version4Specific();
        System.out.printf("Ending");

    }

    public static void version4RandomDefault() {
        UUID uuid = UUID.randomUUID();
        printar(uuid);
    }


    public static void version4Specific() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        UUID uuid = UUID.randomUUID();
        MessageDigest algh = MessageDigest.getInstance("SHA-256");
        algh.update(UUID.randomUUID()
                .toString()
                .getBytes("UTF-8"));

        String newAlgh = bytesToHex(algh.digest());
        System.out.println(newAlgh);
    }






    public static void generateSpecificTypeUUID () {

    /*
     * @param  mostSigBits
     *         The most significant bits of the {@code UUID}
     *
     * @param  leastSigBits
     *         The least significant bits of the {@code UUID}
     *   UUID spec = new UUID(long mostSigBits, long leastSigBits))
     */

        UUID uuid = new UUID(3L,5L);
        printar(uuid);
    }

    /*
        Name Based (UUIDv3 and UUIDv5),
        The UUIDs are generated using the hash of namespace and name.
        UUID = hash(NAMESPACE_IDENTIFIER + NAME)

        The only difference between UUIDv3 and UUIDv5 is the Hashing Algorithm ?
        v3 uses MD5 (128 bits) while
        v5 uses SHA-1 (160 bits)
     */
    public static void version3() {
        try {

            String source = "namespace" + "name";
            byte[] bytes = source.getBytes("UTF-8");
            UUID uuid = UUID.nameUUIDFromBytes(bytes);
            printar(uuid);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /*
        Name Based (UUIDv3 and UUIDv5),
        The UUIDs are generated using the hash of namespace and name.
        UUID = hash(NAMESPACE_IDENTIFIER + NAME)

        The only difference between UUIDv3 and UUIDv5 is the Hashing Algorithm ?
        v5 uses SHA-1 (160 bits)
     */
    public static void version5() {

        String source = "namespace" + "name";
        MessageDigest md;
        byte[] bytesName;
        try {
            bytesName = source.getBytes("UTF-8");
            md = MessageDigest.getInstance("SHA-1");

            byte[] bytes = md.digest(bytesName);
            bytes[6] &= 0x0f; /* clear version        */
            bytes[6] |= 0x50; /* set to version 5     */
            bytes[8] &= 0x3f; /* clear variant        */
            bytes[8] |= 0x80; /* set to IETF variant  */

            UUID uuid = constructType5UUID(bytes);
            printar(uuid);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static UUID constructType5UUID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "data must be 16 bytes in length";

        for (int i = 0; i < 8; i++)
            msb = (msb << 8) | (data[i] & 0xff);

        for (int i = 8; i < 16; i++)
            lsb = (lsb << 8) | (data[i] & 0xff);
        return new UUID(msb, lsb);
    }


    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
