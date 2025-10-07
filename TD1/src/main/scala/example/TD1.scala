package TD1
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.LocalDate

object Td1 {
    case class Information(message: String, country: String,timestamp: LocalDateTime, tags: List[String],price: Int)

    def parseInformation(line: String): Information = {
        val parts = line.split("--")
        val timestamp = parts(0).trim
        val country = parts(1).trim 
        val message = parts(2).trim
        val tags = parts(3).split(",").map(_.trim).toList
        val price = parts(4).split("€")(0).trim.toInt
        Information(message,country, LocalDateTime.parse(timestamp,DateTimeFormatter.ISO_LOCAL_DATE_TIME), tags, price)
    }
    //Méthode timestamps : Qui permet d'avoir la liste des timestamps des informations
    def informationTimeStamp(informations: List[Information]): List[LocalDateTime] = informations.map(_.timestamp)

    //Méthode Information Tag : Qui permet de connaitre les informations contenant un tag
    def informationTag(informations: List[Information],tag: String): List[Information] = informations.filter(_.tags.contains(tag))
    //CURRYFIER
    def informationTagCurry(tag: String)(informations: List[Information]): List[Information] = 
        informations.filter(_.tags.contains(tag))

    //Méthode informationTagOneOf : qui permet de connaitre les informations
    //contenant un ou plusieurs tags pris dans une liste
    def informationTagOneOf(informations: List[Information],tags: List[String]): List[Information] = 
        informations.filter(info => info.tags.exists(tag => tags.contains(tag)))

    
    //Méthode informationMessageSuchThat qui permet de connaitre les informations qui satisfont
    //une condition donnée portant sur le message
    def informationMessageSuchThat(informations: List[Information],condition: String => Boolean): List[Information] =   //ICI UTILISATION DE PREDICATE
        informations.filter(info => condition(info.message))

    //Méthode InformationCountry qui permet de connaitre les informations d'un pays donnée
    def informationsCountry(informations: List[Information],country: String): List[Information] = 
        informations.filter(_.country.equals(country))

    //PARTIE 1B

    @main 
    def test(): Unit = {
        val rawInformation = List(
            "2017-05-08T14:39:06 -- France -- This is an information -- tag1 -- 2€",
            "2017-05-08T14:49:06 -- UK -- This is another information -- tag1,tag2 -- 4€",
            "2018-05-10T14:39:06 -- France -- this is newer information -- tag3 -- 8€"
        )
        val informations = rawInformation.map(parseInformation(_))
        //la suite

        //test Timestamps
        val timestamps = informationTimeStamp(informations)
        println(timestamps)
        println("-----------------------------------------------------")
        //test informationtag
        val informationsWithTag = informationTag(informations,"tag1")
        println(informationsWithTag)
        println("-----------------------------------------------------")


        //Test informationTagOneOf
        val tagsToCheck = List("tag1","tag3")
        val filteredInformations = informationTagOneOf(informations,tagsToCheck)
        println(filteredInformations)
        println("-----------------------------------------------------")

        //Test informationMessageSuchThat
        //Test 1 : Si l'information contient le mot "information"
        val containsInformation = informationMessageSuchThat(informations, _.contains("information"))
        println("\nMessage contenant 'information':")
        println(containsInformation)
        println("-----------------------------------------------------")

        //Test 2 : Si l'informatio
        val startWithThis = informationMessageSuchThat(informations,msg => msg.toLowerCase.startsWith("this"))
        println("\nMessages commencant par 'this' :")
        println(startWithThis)
        println("-----------------------------------------------------")

        //Test informationCountry
        val franceInfo = informationsCountry(informations,"France")
        println("\nInformations pour la France :")
        println(franceInfo)

        val ukInfo = informationsCountry(informations,"UK")
        println("\nInformations pour le royaume-uni :")
        println(ukInfo)

    }
}