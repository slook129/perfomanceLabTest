import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String input;
            int sum = 0;
            ArrayList<Integer> numbers = new ArrayList<>();
            while((input = reader.readLine()) != null){
                numbers.add(Integer.valueOf(input));
                sum += Integer.valueOf(input);
            }
            numbers.sort(Comparator.naturalOrder());
            int finalNum = numbers.get(numbers.size() / 2);
            int ans = 0;
            for(int i : numbers){
                ans += Math.abs(i - finalNum);
            }
            System.out.print(ans);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}