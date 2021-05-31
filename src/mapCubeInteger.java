import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mapCubeInteger {
    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);

        Stream<Integer> numberStream = numberList.stream();

        numberList.forEach(System.out::println);

        Stream<Integer> cubeStream = numberList.stream();
        List<Integer> numberCube = cubeStream.map(number -> number * number * number)
                .collect(Collectors.toList());

        numberCube.forEach(System.out::println);


    }
}
