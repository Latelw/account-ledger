# Project Title

<!-- One sentence under the title: what the app is, for whom.
     Example: A console app that keeps a store's inventory in a csv file and lets a clerk search it. -->
     A account ledger app that keeps transaction data in a csv file and allows the user to filter their search.

## Description of the Project

<!-- Three to five sentences. What the application does, who uses it, what problem it solves.
     Write it for someone who has never seen the workbook: a recruiter, a classmate, you in six months. -->
     This application is made for a user to store transaction history. It primarily documents transactions onto a file,
     and recovers the information stored in the csv file. It also gives the user access to the information via specific
     filters to allow them to see the transactions in a specific time frame.

![Class Diagram](images/class-diagram.png)

## Features

-Add a deposit
-Make a payment
-Display Ledger
-->Show all transactions
 -Show ONLY deposits
 -Show ONLY payments
-Display Reports
-->Month to Date Report
 -Previous Month Report
 -Year to Date Report
 -Previous Year Report
 -Search By Vendor

## User Stories

<!-- The stories you worked from, one per bullet, in the format you learned in Workbook 3b:
     As a [type of user], I want [some goal] so that [some reason].
     Same text as the cards on your GitHub project board. -->

- As a ..., I want ..., so that ...
- As a ..., I want ..., so that ...

## Setup

### Prerequisites

- Java 17 (Amazon Corretto), the version used in class.
- IntelliJ IDEA Community Edition: <https://www.jetbrains.com/idea/download/>

### Running the application

1. Clone this repository, or download it as a zip and unzip it.
2. In IntelliJ: File > Open, pick the project folder (the one that holds `pom.xml`), press Open.
3. Wait for IntelliJ to finish indexing (progress bar at the bottom).
4. Open `src/main/java/com/pluralsight/FinancialTracker.java`. <!-- replace YourMainClassName with the class that has main -->
5. Right-click inside the file and choose Run 'YourMainClassName.main()'.

### Data and configuration

<!-- OPTIONAL. Anything the program needs that is not code: data files and where they must sit, files the
     program creates, a database script to run first, a settings file to edit (connection, port).
     If there is nothing, delete this subsection, heading included.
     Example:
     - `inventory.csv` sits at the project root, next to `pom.xml`. The program reads it at start.
     - `logs.txt` is created by the program at the project root on the first run. -->

-

## Technologies Used

- Java 17
- IntelliJ IDEA
<!-- Add anything else you used: a library, Maven plugins, an external tool. For a console app this list is short. That is fine. -->

## Demo

<!-- Pictures of the app running: the console for a console app, Insomnia or Swagger for an API.
     Screenshots are enough; a GIF is a bonus.
     1. Create a folder named `images` at the project root, next to `pom.xml`.
     2. Take screenshots of the app in the IntelliJ console (the menu, one feature, one error message):
          Windows: Win + Shift + S, drag a rectangle, then paste into Paint and save as PNG, or open the
                   notification and save. Save into the `images` folder.
          Mac:     Shift + Cmd + 4, drag a rectangle. The file lands on the Desktop; move it into `images`.
     3. Name the files by what they show: `images/menu.png`, `images/search.png`.
     4. Reference each one below with a relative path. No spaces in file names.
     5. Commit the images with the rest of your work (Git > Commit shows them as unversioned files: tick them).
     Optional GIF: LICEcap (free, Windows and Mac, <https://www.cockos.com/licecap/>) records a region of the
     screen straight to a .gif. Keep it under 10 seconds and under 10 MB, save it into `images`. -->


## A piece of code I am proud of

<!-- boolean found = false;
                 while (!found) {
                 for (Transaction transaction : transactions) {
                     if (transaction.getVendor().equalsIgnoreCase(userInput)) {
                         statement(transaction);
                         found = true;

                     }
                 }
                 if (!found) {
                     System.out.println("No results found");
                     break;
                 }
             }

             This code compares the transactions vendor to user input to see whether the it matches or not. If found,
             the program will print a formatted version of the transaction and proceed to the next line. If no match is
             found, the program will print "No results found". I wrote this code inspired by an example that I seen in
             sample code. Using the while loop to continue the process until all transactions have been checked.

```java

```

## Future Work

In the future, I would like to add a personalized opening message to the application to welcome the user. I would also
add a running balance for the user to view what remains after the transactions. I would also give the user an option to
delete transactions.

-
-

## Resources

<!-- What helped you: the workbook, the week's hub pages, a tutorial, a documentation page. Real links. -->

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>
-

## Author

<!-- Your name and, if you like, your GitHub profile link. For a team workshop, one line per person with what each one built. -->

- **Your Name**

## Thanks

<!-- Optional. The people who helped: the instructor, a classmate who debugged with you, a mentor. -->

- Thank you to ... for ...