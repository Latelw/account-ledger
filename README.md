# Project Title

<!-- HOW TO USE THIS TEMPLATE
     Save it as README.md at the root of your project, next to pom.xml. Replace every comment like this one
     with your own text; comments do not show on GitHub, so what you leave untouched shows as an empty heading.
     Two sections are optional and say so: Class Diagram, and Data and configuration. When your project does not
     need one, delete the whole section, heading included. Every other section stays. -->

<!-- One sentence under the title: what the app is, for whom.
     Example: A console app that keeps a store's inventory in a csv file and lets a clerk search it. -->

## Description of the Project

<!-- Three to five sentences. What the application does, who uses it, what problem it solves.
     Write it for someone who has never seen the workbook: a recruiter, a classmate, you in six months. -->
This application is made for a user to store transaction history. It primarily documents transactions onto a file,
and recovers the information stored in the csv file. It also gives the user access to the information via specific
filters to allow them to see the transactions in a specific time frame.
## Class Diagram

<!-- OPTIONAL. Only when the project asks for one (Capstone 2 onward). Export the diagram as a PNG into the
     images folder and keep the line below. If your project has no class diagram, delete this whole section,
     heading included. -->

![Class Diagram](images/class-diagram.png)

## Features

<!-- One bullet per thing the app can do, in the order of your menu. Mark bonuses.
     For an API (Capstone 3), one line per endpoint instead: method, path, what it does.
     Be honest: list what works. If something is half done, say so under Future Work instead.
     Example:
     - Shows every product in the store
     - Searches products by name (bonus) -->

-Add a deposit

-Make a payment

-Display Ledger

→Show all transactions

-Show ONLY deposits

-Show ONLY payments

-Display Reports

→Month to Date Report

-Previous Month Report

-Year to Date Report

-Previous Year Report

-Search By Vendor


## User Stories

<!-- The stories you worked from, one per bullet, in the format you learned in Workbook 3b:
     As a [type of user], I want [some goal] so that [some reason].
     Same text as the cards on your GitHub project board. -->
View All Transactions:

As a user, I want to see all transactions so that I can review my financial activity.

View Deposits:

As a user, I want to see deposits so that I can review incoming money.

View Payments:

As a user, I want to see payments so that I can review outgoing money.

Month to Date:

As a user, I want to see this month's transactions so that I can review recent activity.

Previous Month:

As a user, I want to see last month's transactions so that I can compare activity.

Year to Date:

As a user, I want to see this year's transactions so that I can review annual activity.

Previous Year:

As a user, I want to see last year's transactions so that I can compare annual activity.

Search by Vendor:

As a user, I want to search by vendor so that I can find specific transactions.


## Setup

### Prerequisites

- Java 17 (Amazon Corretto), the version used in class.
- IntelliJ IDEA Community Edition: <https://www.jetbrains.com/idea/download/>
-https://raymaroun.github.io/yearup-java-fall2026/week-04/index.html
### Running the application

1. Clone this repository, or download it as a zip and unzip it.
2. In IntelliJ: File > Open, pick the project folder (the one that holds `pom.xml`), press Open.
3. Wait for IntelliJ to finish indexing (progress bar at the bottom).
4. Open `src/main/java/com/pluralsight/FinancialTracker.java`. <!-- replace YourMainClassName with the class that has main -->
5. Right-click inside the file and choose Run 'FinancialTracker.main()'.



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

![Main menu](images/menu.png)

![One feature in action](images/feature.png)

## A piece of code I am proud of

<!-- Paste one short block of your own code (5 to 15 lines) between the three backticks, then write two
     or three sentences: what it does and why you chose to write it that way. This is what you show on
     demo day and what you talk about in an interview. --> 

```java
private static void previousMonth() {
        LocalDate today = LocalDate.now();
        //Isolate first day of the previous month by going back one month while including the first day after
        LocalDate firstDayOfMonth = today.minusMonths(1).withDayOfMonth(1);
        //Isolate first day of current month and then subtract a day to find the last day of previous month
        LocalDate lastDayOfMonth = today.withDayOfMonth(1).minusDays(1);

        System.out.println("Previous Month Report: ");
        transactionHeader();

        for (Transaction transaction : transactions) {
            //Transaction date is not before the first day of the previous month and not after the last day of the previous month, print the transaction
            if (!transaction.getDate().isBefore(firstDayOfMonth) && !transaction.getDate().isAfter(lastDayOfMonth)) {
                statement(transaction);
            }
        }


    }

```
This code creates a method that filters and prints the transactions from the previous month only.
This challenged me because I was unsure about isolating a full month and had to use my peers and resources to finish.
## Future Work

<!-- What you would add or fix next, one bullet each. Unfinished bonuses belong here. -->

-I would like to add a personalized opening message to the application to welcome the user. 

-I would also add a running balance for the user to view what remains after the transactions.

## Resources

<!-- What helped you: the workbook, the week's hub pages, a tutorial, a documentation page. Real links. -->

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>

## Author

<!-- Your name and, if you like, your GitHub profile link. For a team workshop, one line per person with what each one built. -->

- **Latel Williams Jr**

## Thanks

<!-- Optional. The people who helped: the instructor, a classmate who debugged with you, a mentor. -->

- Thank you to PGH Software Dorm, Isaiah C's cousin, and Raymond for the support and advice throughout the project.