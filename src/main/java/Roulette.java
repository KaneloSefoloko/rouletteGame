package main.java;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Roulette {

    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int betChoice, number, spin = 0;
        int result;
        double amountToBet = 0;
        String numberType = null;

        final String BARBARA = "Barbara";


        ReadFromFile getFile = new ReadFromFile();
        List<String> nameList = getFile.readFromFile();

        //Print out names from nameList
        nameList.forEach(System.out::println);

        for (String name : nameList) {
            betChoice = -1;
            while (betChoice < 0 || betChoice > 2) {
                betChoice = input.nextInt();
            }

            amountToBet = input.nextDouble();
            number = 0;

            if (betChoice == 2) {
                while (number < 1 || number > 36) {
                    number = input.nextInt();
                }
            }

            if (betChoice % 2 == 0 && name.equalsIgnoreCase(BARBARA)) {
                numberType = "Even";
                System.out.println(name + " " + numberType + " " + amountToBet);
            } else if (betChoice % 2 != 0 && name.equalsIgnoreCase(BARBARA)){
                numberType = "Odd";
                System.out.println(name + " " + numberType + " " + amountToBet);
            } else {

                System.out.println(name + " " + betChoice + " " + amountToBet);
            }

            // Generate random number in range 0 to 36
            Thread.sleep(30000);
            int rand_int1 = random.nextInt(37);
            spin++;
            System.out.println(rand_int1);

            if (betChoice == 2) {
                if (rand_int1 == number) {
                    result = 36;
                } else {
                    result = 0;
                }
            } else {
                if (rand_int1 == 0 || rand_int1 % 2 != betChoice) {
                    result = 2;
                } else {
                    result = 2;
                }
            }

            if (result > 0) {
                System.out.println("Player \t" + "Bet\t" + "Outcome\t" + "Winnings");
                System.out.println("----");
                System.out.println(name + "\t" + betChoice + "\t" + "WIN" + " " + result * amountToBet);

            } else {
                System.out.println("Player \t" + "Bet\t" + "Outcome\t" + "Winnings");
                System.out.println("----");
                System.out.println(name + "\t" + betChoice + "\t" + "LOSE" + " " +result * amountToBet);

            }

        }


    }
}
