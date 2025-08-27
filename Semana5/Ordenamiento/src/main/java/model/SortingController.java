package model;

import java.util.Comparator;

public class SortingController {


    public String compareIntegers(int x, int y){
        String msj = "";
        //if(x > y){
        if( (x - y) > 0 ){
            msj = "X mayor que y";
        }
        else {
            msj = "Y mayor que x";
        }
        return msj;
    }

    public String compareStrings(String str1, String str2){
        String msj = "";
        if(str1.compareTo(str2) > 0){
            msj = "STR1 mayor que STR2";
        }
        else {
            msj = "STR2 mayor que STR1";
        }
        return msj;
    }

    public String comparePersons(Person p1, Person p2){
        String msj = "";
        if(p1.compareTo(p2) > 0){
            msj = "P1 mayor que P2";
        }
        else {
            msj = "P2 mayor que P1";
        }
        return msj;

    }

    public String comparePersons(Person p1, Person p2, Comparator<Person> comparator){
        String msj = "";
        if(comparator.compare(p1, p2) > 0){
            msj = "P1 mayor que P2";
        }
        else {
            msj = "P2 mayor que P1";
        }
        return msj;
    }

}
