import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
  This project takes the entered array size and array as input.
  It then reverses the array.
  For example
  *Please enter array of size*
  4
  *Please enter your array (for example 3 4 5 1)*
  3 4 1 2

  *Output*
  2 1 4 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter array of size : ");
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.print("Please enter your array (for example 3 4 5 1) : ");
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.print("Output : ");
        for (int i = n - 1; i >= 0 ; i --) {
            System.out.print(arr.get(i) + " ");
        }

        bufferedReader.close();
    }
}