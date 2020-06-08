//Vitin
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Funcao{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        double Xa, Xb, Xc, Px;

        double Ya, Yb, Yc, Py;

        System.out.println("Insira os valores dos lados do triângulo X:");
        Xa = sc.nextDouble();
        Xb = sc.nextDouble();
        Xc = sc.nextDouble();

        System.out.println("Insira os valores dos lados do triângulo Y:");
        Ya = sc.nextDouble();
        Yb = sc.nextDouble();
        Yc = sc.nextDouble();

        double area_x = area(Xa, Xb, Xc);
        double area_y = area(Ya, Yb, Yc);


        System.out.println("A área do triângulo X é: " + area_x);
        System.out.println("A área do triângulo Y é: " + area_y);
        sc.close();
    }

       public static double area(double a, double b, double c){
            double p = (a+b+c)/2;
            double area = sqrt(p*(p-a)*(p-b)*(p-c));
            return area;
    }
}
