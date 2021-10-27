package PracticaLibreInterface;

public class Main {
    public static void main(String[] args) {
        EnglishLanguage english = new EnglishLanguage();
        ProgrammingLanguage pl = new ProgrammingLanguage();

        english.sayHi();
        pl.sayHi();
        pl.sayBye();
        pl.sayHi();
    }
}
