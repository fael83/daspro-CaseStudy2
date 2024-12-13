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
    
    static void addOrder(){
        System.out.print("Insert customer name: ");
        overall [numData][0] = sc.next();
        System.out.print("Insert table number: ");
        overall [numData][1] = sc.next();
        displayMenus(); 
        int sum ;
        int total = 0;
        int num=2;
        int hasilAkhir =0;
        while (true) {
            System.out.print("\nSelect a menu (enter the menu number, or 0 to finish): ");
            int coffee = sc.nextInt();
            if (coffee != 0 && coffee <= 4) {
                while (true) {
                    System.out.print("Enter the number of item for " + menu[coffee - 1] + ": ");
                    total = sc.nextInt();
                    sum = 0;
                    if (total <= 0) {
                        System.out.println("Enter amount greater than 0");
                    } else {
                        sum += price[coffee-1] * total;
                        String summ = Integer.toString(sum);
                        hasilAkhir += sum;
                        overall[numData][num] = menu[coffee-1] + " x " + total + " = " + summ;
                        num++;
                        break;
                    }
                }
            }else if(coffee >= 4){
                System.out.println("G ada boss");
            }else { 
                String totalAhir = Integer.toString(hasilAkhir);
                overall[numData][8] = totalAhir;
                break;
            }
        }
        System.out.println("\nOrder successfully added.");
        System.out.println("Total order price: " + hasilAkhir);
        System.out.println();
        numData += 1;
    }
}