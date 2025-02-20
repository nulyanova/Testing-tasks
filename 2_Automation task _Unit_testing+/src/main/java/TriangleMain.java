import java.util.Scanner;
public class TriangleMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую сторону [a]:");
        int a = in.nextInt();

        System.out.println("Введите вторую сторону [b]:");
        int b = in.nextInt();

        System.out.println("Введите третью сторону [c]:");
        int c = in.nextInt();

        Triangle triangle = new Triangle(a, b, c);
        String output = triangle.triangleType();

        System.out.printf("%s \n", output);
    }
}