import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Customer> list = List.of(
                new Customer("Johna P.", 33, 500),
                new Customer("Jarah M.", 49, 13000),
                new Customer("Charles B.", 22, 1920),
                new Customer("Mary T.", 16, 33)
        );

        List<Customer> listOfOlderCustomer = list
                .stream()
                .filter(Customer::isOlderThen20Age)
                .filter(customer -> customer.getName().contains("a"))
//                .filter(customer1 -> {
//                    try {
//                        return customer1.hasValidProfilePhoto();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
                .sorted(Comparator.comparing(Customer::getAge))
                .collect(Collectors.toList());

        listOfOlderCustomer.forEach(System.out::println);

        long countOfCustomer = list
                .stream()
                .filter(p -> p.getName().startsWith("J"))
                .count();
        System.out.println(countOfCustomer);
        var testList = list.stream().map(Customer::new).collect(Collectors.toList());

        Stream<Integer> numbersStream = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbersStream.reduce((x,y)->x*y);
        System.out.println(result.get()); // 720

        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce((x,y)->x + " " + y.toUpperCase());
        System.out.println(sentence.get());

        Stream<Integer> numberStream = Stream.of(-4, 3, -2, 1);
        int identity = 1;
        int result2 = numberStream.reduce(identity, (x,y)->x * y);
        System.out.println(result2);  // 24
    }
}