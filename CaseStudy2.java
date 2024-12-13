import java.util.Scanner;

public class CaseStudy2 {
    static String[] menu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
    static int[] price = {15000, 22000, 12000, 18000};
    static String [][] overall = new String [100][6]; 
    static int numData = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Add Order");
            System.out.println("2. Show order list");
            System.out.println("3. Exit");
            System.out.print("Choose menu: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                addOrder();
            } else if (menu == 2) {
                displayOverall();
            } else if (menu == 3) {
                System.out.println("Thank you");
                break;
            } else {
                System.out.println("Incorrect option! Please choose a number between (1-3).");
            } 
        }
    }
}