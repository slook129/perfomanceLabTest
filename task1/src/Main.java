public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.print(1);
        int cur = (m - 1) % n + 1;
        while(cur != 1){
            System.out.print(cur);
            cur = (cur + m - 2) % n + 1;
        }
    }
}