package me.motyim.pattern.structural.bridge;

public class Test {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        Formatter printFormatter = new PrintFormatter();

        Printer moviePrinter = new MoviePrinter(movie);
        String print = moviePrinter.print(printFormatter);
        System.out.println(print);

        String htmlPrint = moviePrinter.print(new HtmlFormatter());

        System.out.println(htmlPrint);

    }
}
