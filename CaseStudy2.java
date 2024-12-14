import java.util.Scanner;

public class CaseStudy2 {
    static String[] menu = {"Black Coffee", "Latte", "Tarik Tea", "Fried Noodle"};
    static int[] price = {15000, 22000, 12000, 18000};
    static String [][] overall = new String [100][9]; 
    static int numData = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("===== MAIN MENU =====");
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
        int finalResult =0;
        while (true) {
            System.out.print("\nSelect a menu (enter the menu number, or 0 to finish): ");
            int menuNumber = sc.nextInt();
            if (menuNumber != 0 && menuNumber <= 4 && menuNumber >= 0) {
                while (true) {
                    System.out.print("Enter the number of item for " + menu[menuNumber - 1] + ": ");
                    total = sc.nextInt();
                    sum = 0;
                    if (total <= 0) {
                        System.out.println("Enter amount greater than 0");
                    } else {
                        sum += price[menuNumber-1] * total;
                        String summ = Integer.toString(sum);
                        finalResult += sum;
                        overall[numData][num] = menu[menuNumber-1] + " x " + total + " = Rp " + summ;
                        num++;
                        break;
                    }
                }
            }else if(menuNumber > 4 || menuNumber < 0){
                System.out.println("The menu is not available");
                continue;
            }else { 
                String finalTotal = Integer.toString(finalResult);
                overall[numData][8] = finalTotal;
                break;
            }
        }
        System.out.println("\nOrder successfully added.");
        System.out.println("Total order price: " + finalResult);
        System.out.println();
        numData += 1;
    }

    static void displayMenus(){
        System.out.println("\n===== CAFE MENU =====");
        System.out.println("1. " + menu[0]+ " - Rp " + price[0]);
        System.out.println("2. "+ menu[1] + " - Rp " + price[1]);
        System.out.println("3. "+ menu[2] +" - Rp " +  price[2]);
        System.out.println("4. " + menu [3] +" - Rp " +  price[3]);
    }
    
    static void displayOverall(){
        if (numData == 0) {
            System.out.println("\nThere is no order.");
        } else {
            System.out.println("\n==== ORDER LISTS ====");
            for (int i = 0; i < numData; i++){
                System.out.println("Customer Name: " + overall[i][0]);
                System.out.println("Table Number: " + overall[i][1]);
                System.out.println("Order details:");
                while (true) {
                for (int j = 2; j < overall[i].length; j++){
                    if (overall[i][j] == null) {
                        continue;
                    } else {
                        if(j > 7) break;
                        System.out.println("- " + overall[i][j]);
                    }
                    
                    }
                    System.out.println("Total Order Price: " + overall[i][8]);
                    System.out.println("----------------------------");
                    break;
                }
            }
            System.out.println();
        }
    }
}