package Cours2;
public class CalculateurPourboire {
    public static int pourcentage(List<String> names){
        if(names.size() > 5){
            return 20;
        } else if(!names.empty()){
            return 10;
        } else {
            return 0;
        }
    }
}