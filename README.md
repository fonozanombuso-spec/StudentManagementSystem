# Student Management System

A simple Java Swing-based Student Management System designed for capturing and displaying student information through a user-friendly graphical interface.

## Features

* Clean and modern GUI built with Java Swing
* Student information capture:
  * Name
  * Surname
  * ID Number
  * Student Number
  * Course
* Submit student information
* Display entered information in a dedicated panel
* Clear form fields
* Refresh and reset the entire form
* Custom pink-themed user interface

## Technologies Used

* Java
* Java Swing
* AWT

## Project Structure

```
StudentManagementSystem.java
```

The application is contained in a single Java file and can be compiled and run directly.




## How to Run

### Prerequisites

* Java JDK 8 or later
* Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Compile

```bash
javac StudentManagementSystem.java
```

### Run

```bash
java StudentManagementSystem
```

## Application Functions

### Submit

The **Submit** button:

* Validates that all fields are completed
* Displays student information in the output area
* Shows a success message

### Clear

The **Clear** button:

* Clears all input fields

### Refresh

The **Refresh** button:

* Clears all input fields
* Clears displayed student information
* Resets the form

## Validation

The system checks that:

* Name is entered
* Surname is entered
* ID Number is entered
* Student Number is entered
* Course is entered

If any field is empty, an error message is displayed.

## User Interface

The application uses:

* Custom pink color theme
* Styled buttons
* Form validation dialogs
* Scrollable information display area
* Organized layout using BorderLayout and GridLayout

## Institution

**NDONIS INSTITUTE OF TECHNOLOGY**

This project was created as a simple desktop application for managing student information.

## Author

Nombuso Langa

## License

This project is open-source and available under the MIT License.
