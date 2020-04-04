public class Main {

    public static void main(String[] args) {
        System.out.println("start main");

        System.out.println("value is : " + 0xFFFFFFBF);

        int value = ((Integer.MIN_VALUE + Integer.MIN_VALUE) >>> 2);
        int value2 = Integer.MIN_VALUE + (Integer.MIN_VALUE - Integer.MIN_VALUE) / 2;
        System.out.println("min + min = " + value);
        System.out.println("value2 = " + value2);
    }
}
