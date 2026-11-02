package basics;

import java.util.Scanner;

public class locationOfPoint {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter Y Coordinate ");
        double y = sc.nextDouble();
        System.out.print("enter X Coordinate ");
        double x = sc.nextDouble();
        if (x==0 && y==0 ){
            System.out.println("origin");
        } else if (x==0) {
            System.out.println("Y axis");

        }else if (y==0) {
            System.out.println("x axis");

        }else if (x>0 && y>0) {
            System.out.println("1st Quadrant");

        }else if (x>0 && y<0) {
            System.out.println("4th Quadrant");

        }else if (x<0 && y>0) {
            System.out.println("2nd Quadrant");

        }else if (x<0 && y<0) {
            System.out.println("3rd Qudrant");

        }
    }
}
