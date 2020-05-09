package study.playground.WildcardGeneric;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Father> fatherList1 = new ArrayList<Father>();
//        List<Father> fatherList2 = new ArrayList<Grandpa>(); // error
//        List<Father> fatherList3 = new ArrayList<Son>(); // error

        List<? extends Father> fatherList4 = new ArrayList<Father>();
        List<? extends Father> fatherList5 = new ArrayList<Son>();
//        List<? extends Father> fatherList6 = new ArrayList<Grandpa>(); // error
//
        List<? super Father> fatherList7 = new ArrayList<Father>();
        List<? super Father> fatherList8 = new ArrayList<Grandpa>();
//        List<? super Father> fatherList9 = new ArrayList<Son>(); // error
//        Father father = fatherList8.get(0); // error

        Father[] fatherArray1 = new Father[0];
        Father[] fatherArray2 = new Son[0];
//        Father[] fatherArray3 = new Grandpa[0]; // error
    }
}
