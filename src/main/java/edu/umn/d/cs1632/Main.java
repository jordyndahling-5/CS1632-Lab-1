package edu.umn.d.cs1632;

import java.util.Scanner;

public class Main  {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
        System.out.print("Fil of data to read: ");
        String fileName = scanner.nextLine();
        */

 

        MArray mArray = new MArray("src/data/simple.csv");
        // Put your code for queries here
        System.out.println("Data:");
        System.out.println(mArray);

        while (true) {
            System.out.println("Query? ");
            String query = scanner.nextLine();

            if (query.equals("Q")) {
                break;
            }
            String[] parts = query.split(" ");

            if (parts[0].equals("V")) {
                int col = Integer.parseInt(parts[1]);
                int rowStart = Integer.parseInt(parts[2]);
                int rowEnd = Integer.parseInt(parts[3]);

                String type = mArray.getType(rowStart, col);
                boolean sameType = true;

                for (int row = rowStart; row <= rowEnd; row++) {
                    if (!mArray.getType(row, col).equals(type)) {
                        sameType = false;
                        break;
                    }
                }
                if (sameType) {
                    System.out.print(type);
                } else {
                    System.out.println("Multi");
                }


            }

        }

        scanner.close();



    }
}