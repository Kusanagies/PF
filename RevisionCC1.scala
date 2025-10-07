object WordScore {
    def score(word: String) : Int = {
        return word.replaceAll("a","").length
    }

    def rankedWords(words: List[String]):List[String] = {
        return words.sortBy(word => -score(word)).reverse
    }
    @main 
    def wordScore1(): Unit = {
        val words = List("ada","haskell","scala","java","rust")
        println(rankedWords(words))
    }
}

object wordScore2 {
    def score(word : String) : Int = {
        return word.replaceAll("a","").length 
    }
    def bonus(word : String) : Int = {
        return if (word.replaceAll("c")) 5 else 0
    }
    def malus(word : String): Int = {
        return if (word.contains("s")) -7 else 0
    }
    def rankedWords(words: List[String]): List[String] = {
        return words.sortBy(word => score(word) + bonus(word) + malus(word)).reverse
    }
}
object wordScore3{
    def score(word : String): Int = {
        return word.replaceAll("a","").length
    }
    def bonus(word: String): Int = {
        return if(word.contains("c")) 5 else 0
    }
    def malus(word : String): Int = {
        return if(word.contains("s")) -7 else 0
    }
    def totalScore(word : String): Int = {
        return score(word) + bonus(word) + malus(word)
    }
    def rankedWords(words: List[String]) : List[String] = {
        return words.map(word => (word,totalScore(word))).sortBy(_._2).reverse.map(_._1)
    }
    @main 
    def wordScore3(): Unit = {
        val words = List("ada","haskell","scala","java","rust")
        println(rankedWords(words))

    }
}

object exercise1 {
    def longueurs(word : String): Int = return word.length()
    def nbLettresS(word: String): Int = return word.count(_ == "s")
    def inverseNumber(n : Int): Int = return -n
    def double(x: Int): Int = return 2*x 

    @main 
    def exercise1Main(): Unit = {
        assert(longueurs("scala") == 5)
        assert(nbLettresS("scala") == 1)
        assert(inverseNumber(1) == -1)
        assert(double(1) == 2)
    }
}

object wordScore4 {
    def score(word: String): Int = word.replaceAll("a","").length
    def bonus(word: String): Int = if(word.contains("c")) 5 else 0
    def malus(word: String): Int = if(word.contains("s")) -7 else 0
    def totalScore(word: String) = Int = score(word) + bonus(word) + malus(word)

    def highestScoringWord(scoring: String => Int, words: List[String],n: Int) : List[String] = {
        return words.filter(word => scoring(word) > 1)
    }
    @main 
    def wordScore4(): Unit = {
        val words = List("ada","haskell","scala","java","rust");
        assert(highestScoringWord(words => score(words),words,1) =)
    }
}