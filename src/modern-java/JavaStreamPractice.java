// https://hbase.tistory.com/171

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class JavaStreamPractice {
    public static void main(String[] args) {
        // 스트림: 컬렉션에 저장되어 있는 엘리먼트들을 하나씩 순회하면서 처리할 수 있는 코드패턴

        // 1. intro
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        list.stream()
            .filter("b"::equals)
            .forEach(System.out::println);

        ////////////// 스트림 생성 ////////////////
        
        // 2. 스트림 객체 생성하기
        List<String> list2 = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();

        // 3. 스트림 생성 - 배열
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> streamArray1 = Arrays.stream(array);

        // 범위 지정 (1, 3) => "b", "c"만 포함
        Stream<String> streamArray2 = Arrays.stream(array, 1, 3);


        // 4. 스트림 생성 - 빌더
        Stream<Object> build = Stream.builder()
                                    .add("apple")
                                    .add("banana")
                                    .add("melon")
                                    .build();

        // 5. 스트림 생성 - Generator
        Stream<String> generate = Stream.generate(() -> "Hello")    
                                        .limit(5);


        // 6. 스트림 생성 - Iterator: 수열 형태로 스트림 생성
        Stream<Integer> streamIterator = Stream.iterate(100, n -> n + 10)
                                        .limit(5);

        // 7. 스트림 생성 - Empty
        Stream<String> empty = Stream.empty();

        // 8. 스트림 생성  - primitive type
        IntStream intStream = IntStream.range(1, 10);
        LongStream longStream = LongStream.range(1, 10);
        
        Stream<Integer> boxed = IntStream.range(1, 10).boxed();
        DoubleStream doubleStream  = new Random().doubles(3);
        doubleStream.forEach(System.out::println);

        // 9. 스트림 생성 - 문자열 스트림
        IntStream asciiStream = "Hello, World!".chars();


        // 10. 스트림 연결
        Stream<String> stream1 = Stream.of("a", "b", "c");
        Stream<String> stream2 = Stream.of("d", "e");
        Stream<String> streamConcat = Stream.concat(stream1, stream2);

        ////////////// 스트림 데이터 가공 //////////////
        // 11. filter(Predicate<> predicateLamda) 
        // predicateLamda를 true로 만족하는 데이터만 뽑아냄

        // 짝수만 뽑아내는 예시
        Stream<Integer> streamToFilter = IntStream.range(1, 10).boxed();
        streamToFilter.filter(v -> ((v % 2) == 0));
                        // .forEach(System.out::println);

        // 12. map(Function<> mapper)
        // 값을 변환해주는 람다식을 인자로 받아, 스트림에서 생성된 데이터를 가지고 새로운 데이터를 만들어낸다
       
        // 20, 40, 60, 80
        Stream<Integer> streamMapper = IntStream.range(1, 10).boxed();
        streamMapper.filter(n -> n%2 == 0)
                    .map(v -> v * 10);
                    // .forEach(System.out::println);
        
        // 13. flatMap: map과 비슷하지만 파라미터로 받는 람다의 리턴타입이 Stream
        // 중첩된 스트림 구조를 한단계 적은 단일 컬렉션에 대한 스트림으로 만들어 줌
        
        
        List<List<String>> listFlatMap = Arrays.asList(
                                            Arrays.asList("A", "B", "C"),
                                            Arrays.asList("a", "b", "c")
                                    );
        System.out.println(listFlatMap);
        // [["A", "B", "C"], ["a", "b", "c"]]

        List<String> flatList = listFlatMap.stream()
                                    .flatMap(Collection::stream)
                                    .collect(Collectors.toList());
        System.out.println(flatList);
        // ["A", "B", "C", "a", "b", "c"]
         
        // 14. sorted
        List<Integer> listSorted = Arrays.asList(3, 1, 2);
        System.out.println(listSorted.stream().sorted().toList());
        System.out.println(listSorted.stream().sorted(Collections.reverseOrder()).toList());

        // 15. peek 
        // map과 다르게 데이터에 변형을 가하지 않고, 인자로 받은 람다를 실행만 함
        // 로깅 등의 목적으로 사용함
        int sum = IntStream.range(1, 10)
                            .peek(System.out::println).sum();
        
        // 16.통계값 구하기 - sum(), count(), max(), min(), average()

        // 17. collect() - stream 을 collection으로 만들기 (stream to collection)
        // 보통 어떤 collection에 대해 가공한 후, 다시 collection으로 만드는 데 사용한다
        Set<Integer> evenNumber = IntStream.range(1, 1000)
                                            .boxed()
                                            .filter(n -> (n%2 == 0))
                                            .collect(Collectors.toSet());
        // 18. Collector.joining() - 작업 결과를 모두 이어붙인 하나의 문자열을 반환
        List<String> listJoining = Arrays.asList("a", "b", "c");
        String stringJoining = listJoining.stream()
                                            .collect(Collectors.joining()); 
        
        System.out.println(stringJoining);
        

        // 19. forEach : 스트림에서 뽑아져 나오는 스트림에 있는 각 값에 대한 처리
        // 뭘 리턴하지는 않는다.

        IntStream.range(1, 1000).boxed()
                    .filter(x -> x%2 == 0)
                    .forEach(System.out::println);
    }

}
