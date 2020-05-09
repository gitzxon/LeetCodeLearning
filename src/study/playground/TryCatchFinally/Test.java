package study.playground.TryCatchFinally;

class Test
{
    public static void main(String args[])
    {
        String test = Test.test();
        System.out.println(test);
    }

    public static String test()
    {
        try {
            System.out.println("try");
            throw new Exception();
        } catch(Exception e) {
            System.out.println("catch");
            return "return in catch 111";
        } finally {
            System.out.println("finally");
            return "return in finally";
        }
    }
}