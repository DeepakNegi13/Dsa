package basics;

import java.util.Scanner;

public class volumeOfSphere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tye radius of the number ");
        double r = sc.nextDouble();
        double vol = 4/3*3.141529*r*r*r;
        System.out.println("volume of the sphere is "+vol);

    }
}
