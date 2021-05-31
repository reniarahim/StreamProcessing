import java.util.stream.Stream;

public class StreamsQuizStarter {
    public static void main(String pars[]) {
        Stream<String> msg = Stream.of("Java8 ", "in ", "Action ");
        msg.forEach(System.out::print);
        msg.forEach(System.out::print);
    }
}
