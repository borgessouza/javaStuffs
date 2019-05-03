package Tests;

public class Function {

    private static Comparable<String> func1 = new Comparable<String>() {
        @Override
        public int compareTo(String a) {
            System.out.println("o = [" + a + "]");
            return 1;
        }
    };



    public static void main(String[] args) {
        String phoneNumber = "011989218482";

        Long phoneNumberReady = Long.valueOf(phoneNumber);
        phoneNumber = phoneNumberReady.toString();
        System.out.println("args = [" + phoneNumber + "]");


    }


}
