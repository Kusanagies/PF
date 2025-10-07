package Cours2;
import java.util.*;

public class Main{
    static int score(String word) {
        return word.replaceAll("a", "").length();
    }
    static int scoreWithBonus(String word){
        int base = score(word);
        return (word.contains("c")) ? base + 5 : base;
    }
    static int scoreWithBonus2(String word){
        int base = score(word) + scoreWithBonus(word);
        return (word.contains("s")) ? base - 7 : base;
    }

    //Ma solution pour l'exercise 3 du cours
    static int scoreWithBonusAndPenalty(String word){
        int base = score(word);
        int bonus = (word.contains("c")) ? 5 : 0;
        int penalty = (word.contains("s")) ? 7 : 0;
        return base + bonus - penalty;
    }
    //Utilisation du Lambda
    static Comparator<String> scoreComparator = (String o1, String o2) -> Integer.compare(score(o2), score(o1));
    static Comparator<String> scoreWithBonusComparator=(String o1, String o2)-> Integer.compare(scoreWithBonus(o2), scoreWithBonus(o1));
    static Comparator<String> scoreWithBonusComparator2=(String o1, String o2)->Integer.compare(scoreWithBonus2(o2),scoreWithBonus2(o1));
    static Comparator<String> scoreWtihBonusAndPenaltyComparator = (String o1,String o2) -> Integer.compare(scoreWithBonusAndPenalty(o2),scoreWithBonusAndPenalty(o1));
    /* 
    Comparator<String>(){
        @Override
        public int compare(String o1,String o2){
            return Integer.compare(score(o2),score(o1);
        }
    };
    */ 
    //On compare avec une autre méthode (Slide sur le lambda)
    static List<String> rankedWords(Comparator<String> comp, List<String> words) {
        List<String> rankedWords = new ArrayList<>(words);
        rankedWords.sort(comp);
        return rankedWords;
    }
    //On change Function<String,Integer> par Calculateur
    public interface Calculateur extends Function<String,Integer>{}

    static Calculateur score = word -> word.replaceAll("a","").length();
    static Calculateur bonus = word -> word.contains("c") ? 5 : 0;
    static Calculateur malus = word -> word.contains("s") ? 7 : 0;
    static Calculateur wordScore(Calculateur base, Calculateur bonus,Calculateur malus){
        return word -> base.apply(word) + bonus.apply(word) - malus.apply(word);
    }
    static

    




    public static void main(String[] args) {
        List<String> words = Arrays.asList("ada", "haskell", "scala", "java", "rust");
        System.out.println(rankedWords(scoreComparator, words));
        System.out.println(rankedWords(scoreWithBonusComparator, words));
        System.out.println(rankedWords(scoreWithBonusComparator2,words));

        //Ma Solution pour l'exercise 3 du cours
        System.out.println(rankedWords(scoreWtihBonusAndPenaltyComparator,words));


    }
}
