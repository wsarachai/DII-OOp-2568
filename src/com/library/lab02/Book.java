package com.library.lab02;

import java.time.LocalDate;

/**
 * Book class represents a book in the library management system.
 * This class manages book information and its borrowing status.
 */
public class Book {

  // Attributes
  private String title;
  private String author;
  private String isbn;
  private double price;
  private String status; // "Available" or "Borrowed"
  private LocalDate returnDueDate; // Class Attribute for return due date

  // Constructor
  public Book(String title, String author, String isbn, double price, String status) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.price = price;
    this.status = status;
    this.returnDueDate = null; // No due date until borrowed
  }

  // Getters
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  public double getPrice() {
    return price;
  }

  public String getStatus() {
    return status;
  }

  public LocalDate getReturnDueDate() {
    return returnDueDate;
  }

  // Setters
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * checkOut(): Changes book status from "Available" to "Borrowed"
   * Prevents checking out a book that is already borrowed.
   * Sets the return due date to 14 days from today.
   */
  public void checkOut(Member borrower) {
    // Challenge Solution: Prevent checkout if already borrowed
    if ("Borrowed".equalsIgnoreCase(this.status)) {
      System.out.println(" Error: Book '" + this.title + "' is already borrowed and cannot be checked out again.");
      return;
    }

    this.status = "Borrowed";
    this.returnDueDate = LocalDate.now().plusDays(14); // 14 days loan period
    System.out.println("  Book [" + this.title + "] has been borrowed by [" + borrower.getMemberName() +"].");
    // "Book [Title] has been borrowed by [Member Name]."
    System.out.println("  Return Due Date: " + this.returnDueDate);
  }

  /**
   * returnBook(): Changes book status from "Borrowed" to "Available"
   * Clears the return due date.
   */
  public void returnBook() {
    if ("Available".equalsIgnoreCase(this.status)) {
      System.out.println("  Error: Book '" + this.title + "' is already available.");
      return;
    }

    this.status = "Available";
    this.returnDueDate = null;
    System.out.println("  Book '" + this.title + "' has been returned successfully.");
  }

  /**
   * displayDetails(): Prints all information about the book to the console.
   */
  public void displayDetails() {
    System.out.println(" - Title:              " + this.title);
    System.out.println(" - Author:             " + this.author);
    System.out.println(" - ISBN:               " + this.isbn);
    System.out.println(" - Price:              " + this.price + " Baht");
    System.out.println(" - Status:             " + this.status);

    if (this.returnDueDate != null) {
      System.out.println(" - Return Due Date:    " + this.returnDueDate);
    } else {
      System.out.println(" - Return Due Date:    N/A (Book is available)");
    }
    System.out.println();
  }

  public void printSummary() {
    System.out.printf("Book[Title='%s', Status='%s']\n", title, status);
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", isbn='" + isbn + '\'' +
        ", price=" + price +
        ", status='" + status + '\'' +
        ", returnDueDate=" + returnDueDate +
        '}';
  }
}
