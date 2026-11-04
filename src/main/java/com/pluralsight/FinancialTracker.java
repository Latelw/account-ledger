package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Capstone skeleton – personal finance tracker.
 * ------------------------------------------------
 * File format  (pipe-delimited)
 *     yyyy-MM-dd|HH:mm:ss|description|vendor|amount
 * A deposit has a positive amount; a payment is stored
 * as a negative amount.
 *
 * TODO: create the Transaction class in this package first.
 *       One object = one line of the file. Decide its fields from
 *       the file format above, add a constructor and getters.
 *       This class does not compile until Transaction exists.
 */
public class FinancialTracker {

    /* ------------------------------------------------------------------
       Shared data and formatters
       ------------------------------------------------------------------ */
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.csv";

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /* ------------------------------------------------------------------
       Main menu
       ------------------------------------------------------------------ */
    public static void main(String[] args) {
        loadTransactions(FILE_NAME);



        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    /* ------------------------------------------------------------------
       File I/O
       ------------------------------------------------------------------ */

    /**
     * Load transactions from FILE_NAME.
     * • If the file doesn’t exist, create an empty one so that future writes succeed.
     * • Each line looks like: date|time|description|vendor|amount
     */
    public static void loadTransactions(String fileName) {
        File file = new File(fileName);
       try {
           if (!file.exists()) {
               FileWriter fileWriter = new FileWriter(fileName);
               fileWriter.close();


           }
           BufferedReader reader = new BufferedReader(new FileReader(fileName));
           String line;

           while ((line = reader.readLine()) != null) {
               String[] transaction = line.split("\\|");
               LocalDate date = LocalDate.parse(transaction[0]);
               LocalTime time = LocalTime.parse(transaction[1]);
               String description = transaction[2];
               String vendor = transaction[3];
               double amount = Double.parseDouble(transaction[4]);

               Transaction newTransaction = new Transaction(date, time, description, vendor,amount);
               transactions.add(newTransaction);






           }
           reader.close();

       } catch (IOException e) {
           System.out.println("Error found");
       }

    }

    /* ------------------------------------------------------------------
       Add new transactions
       ------------------------------------------------------------------ */

    /**
     * Prompt for ONE date+time string in the format
     * "yyyy-MM-dd HH:mm:ss", plus description, vendor, amount.
     * Validate that the amount entered is positive.
     * Store the amount as-is (positive) and append to the file.
     */
    private static void addDeposit(Scanner scanner) {
        //Prompt user for BOTH date and time and hold in a string
        //Added Try catch to protect from incorrect format by user
       LocalDate date = null;
       LocalTime time = null;
        while (date == null || time == null) {
            try {
                System.out.println("Enter Date and Time of deposit(yyyy-MM-dd HH:mm:ss): ");
                String userDateTime = scanner.nextLine();
                //Use date time formatter provided above
                LocalDateTime dateTime = LocalDateTime.parse(userDateTime, DATETIME_FMT);
                //Class calls for date and time separately. Need to extract each
                date = dateTime.toLocalDate();

                time = dateTime.toLocalTime();
            } catch (Exception e) {
                System.out.println("Error with input. Check format and try again");
            }
        }

        //Get the rest of the attributes for transaction
        String description = "";
        while (description.isEmpty()) {
            System.out.println("Enter description: ");
            description = scanner.nextLine();
        }

        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();

        //Verify that the transaction is positive

        double amount = 0;

        while (amount <= 0) {
            try {

                System.out.println("Enter the amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                //if statement handles the verification to ensure the user is prompted to enter a new amount.
                if (amount <= 0) {
                    System.out.println("Invalid amount. Try Again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Numerical characters only");
            }
        }
        Transaction newTransaction = new Transaction(date,time,description,vendor,amount);
        transactions.add(newTransaction);

        System.out.println("Deposit Successful!");

        //Writing to the file (append mode) while maintaining current transactions
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(newTransaction.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("File can not be opened.");
        }










    }

    /**
     * Same prompts as addDeposit.
     * Amount must be entered as a positive number,
     * then converted to a negative amount before storing.
     */
    private static void addPayment(Scanner scanner) {
        LocalDate date = null;
        LocalTime time = null;
        while (date == null || time == null) {
            try {
                System.out.println("Enter Date and Time of Payment(yyyy-MM-dd HH:mm:ss): ");
                String userDateTime = scanner.nextLine();
                //Use date time formatter provided above
                LocalDateTime dateTime = LocalDateTime.parse(userDateTime, DATETIME_FMT);
                //Class calls for date and time separately. Need to extract each
                date = dateTime.toLocalDate();

                time = dateTime.toLocalTime();
            } catch (Exception e) {
                System.out.println("Error with input. Check format and try again");
            }
        }
    }

    /* ------------------------------------------------------------------
       Ledger menu
       ------------------------------------------------------------------ */
    private static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> reportsMenu(scanner);
                case "H" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Display helpers: show data in neat columns
       ------------------------------------------------------------------ */
    private static void displayLedger() { /* TODO – print all transactions in column format, newest first */ }

    private static void displayDeposits() { /* TODO – only amount > 0               */ }

    private static void displayPayments() { /* TODO – only amount < 0               */ }

    /* ------------------------------------------------------------------
       Reports menu
       ------------------------------------------------------------------ */
    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {/* TODO – month-to-date report */ }
                case "2" -> {/* TODO – previous month report */ }
                case "3" -> {/* TODO – year-to-date report   */ }
                case "4" -> {/* TODO – previous year report  */ }
                case "5" -> {/* TODO – prompt for vendor then report */ }
                case "6" -> customSearch(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Reporting helpers
       ------------------------------------------------------------------ */
    private static void filterTransactionsByDate(LocalDate start, LocalDate end) {
        // TODO – iterate transactions, print those within the range
    }

    private static void filterTransactionsByVendor(String vendor) {
        // TODO – iterate transactions, print those with matching vendor
    }

    private static void customSearch(Scanner scanner) {
        // TODO – prompt for any combination of date range, description,
        //        vendor, and exact amount, then display matches
    }

    /* ------------------------------------------------------------------
       Utility parsers (you can reuse in many places)
       ------------------------------------------------------------------ */
    private static LocalDate parseDate(String s) {
        /* TODO – return LocalDate or null */
        return null;
    }

    private static Double parseDouble(String s) {
        /* TODO – return Double   or null */
        return null;
    }
}
