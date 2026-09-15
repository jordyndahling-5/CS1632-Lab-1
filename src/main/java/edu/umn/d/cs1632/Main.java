package edu.umn.d.cs1632;

import java.util.Scanner;

public class Main  {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MArray mArray = new MArray("src/data/simple.csv");
        // Put your code for queries here
        System.out.println("Data:");
        System.out.println(mArray);

        while (true) {
            System.out.println();
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
            } else if (parts[0].equals("H")) {
                int row = Integer.parseInt(parts[1]);
                int colStart = Integer.parseInt(parts[2]);
                int colEnd = Integer.parseInt(parts[3]);

                String type = mArray.getType(row, colStart);
                boolean sameType = true;

                for (int col = colStart; col <= colEnd; col++) {
                    if (!mArray.getType(row, col).equals(type)) {
                        sameType = false;
                        break;
                    }
                }
                if (sameType) {
                    System.out.println(type);
                } else {
                    System.out.println("Multi");
                }
            } else if (parts[0].equals("M")) {
                int rowStart = Integer.parseInt(parts[1]);
                int rowEnd = Integer.parseInt(parts[2]);
                int colStart = Integer.parseInt(parts[3]);
                int colEnd = Integer.parseInt(parts[4]);

                String type = mArray.getType(rowStart, colStart);
                boolean sameType = true;

                for (int row = rowStart; row <= rowEnd; row++) {
                    for (int col = colStart; col <= colEnd; col++) {
                        if (!mArray.getType(row, col).equals(type)) {
                            sameType = false;
                            break;
                        }
                    }
                    if (!sameType) {
                        break;
                    }
                }
                if (sameType) {
                    System.out.println(type);
                } else {
                    System.out.println("Multi");
                }
            }
        }
        scanner.close();



    }
}