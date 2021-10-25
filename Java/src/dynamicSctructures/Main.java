package dynamicSctructures;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(
                "123",
                "Lautaro",
                "Goyenechea",
                21,
                "3564341212",
                "4818765",
                "B+"
        );

        Person p2 = new Person(
                "456",
                "Sofia",
                "Perez",
                15,
                "3514346712",
                "9888",
                "A-"
        );

        Person p3 = new Person(
                "789",
                "Jose",
                "Ayme",
                18,
                "125656",
                "0800",
                "A+"
        );

        Person p4 = new Person(
                "234",
                "Nadia",
                "Verdier",
                25,
                "5435353",
                "5534",
                "0+"
        );

        Race forestRace = new Race();

        System.out.println(forestRace.subscription("short", p1));
        System.out.println(forestRace.subscription("short", p2));
        System.out.println(forestRace.subscription("medium", p3));
        System.out.println(forestRace.subscription("advanced", p4));

        forestRace.showParticipants();
    }
}