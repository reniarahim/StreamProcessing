import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sum50Integers {
    //Calculate the sum of the first 50 whole numbers using iterate() and reduce() methods of Stream.

    public static void main(String[] args) {

        Optional<Integer> wholeNumberStream = Stream.iterate(1, i -> i<=50, i -> i=i+1)
                .reduce(Integer::sum);

       System.out.println(wholeNumberStream.get());


    }
}
