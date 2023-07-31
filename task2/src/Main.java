import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String[] cords = reader.readLine().split(" ");
            float cx = Float.valueOf(cords[0]);
            float cy = Float.valueOf(cords[1]);
            String radius = reader.readLine();
            float r = Float.valueOf(radius);
            reader = new BufferedReader(new FileReader(args[1]));
            String point;
            while((point = reader.readLine()) != null){
                String[] pointCords = point.split(" ");
                float px = Float.valueOf(pointCords[0]);
                float py = Float.valueOf(pointCords[1]);
                float dist = (px - cx) * (px - cx) + (py - cy) * (py - cy);
                if(dist == r * r)
                    System.out.print("0\n");
                if(dist < r * r)
                    System.out.print("1\n");
                if(dist > r * r)
                    System.out.print("2\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}