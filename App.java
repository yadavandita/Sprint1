package com.Library;

import java.util.List;
import java.util.Scanner;

import com.Library.dao.LibraryDaoImpl;
import com.Library.pojo.Library;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryDaoImpl library = new LibraryDaoImpl();
        int ch;

        do {
            System.out.println("****Library Management System****");
            System.out.println("1.Add Book");
            System.out.println("2.Read All Books");
            System.out.println("3.Read Book By Id");
            System.out.println("4.Update Book Details");
            System.out.println("5.Delete Book");
            System.out.println("6.Exit");
            System.out.println("Enter choice:");
            ch = sc.nextInt();

            switch(ch) {
            case 1:
                System.out.println("Enter Book Name:");
                String bookName = sc.next();
                System.out.println("Enter Author Name:");
                String author = sc.next();
                System.out.println("Enter Book Price:");
                double price = sc.nextDouble();

                Library book = new Library(bookName, author, price);
                library.addBook(book);
                break;

            case 2:
                List<Library> books = library.getAllBooks();

                for(Library b : books) {
                    System.out.println(b);
                }
                break;

            case 3:
                System.out.println("Enter Book Id which you want to read:");
                int bid = sc.nextInt();

                Library found = library.getBookById(bid);

                if(found != null) {
                    System.out.println(found);
                } else {
                    System.out.println("Book Not Found!!!!");
                }
                break;

            case 4:
                System.out.println("Enter Book Id:");
                int id = sc.nextInt();

                System.out.println("Enter new Book Name:");
                String newBookName = sc.next();
                System.out.println("Enter new Author Name:");
                String newAuthor = sc.next();
                System.out.println("Enter new Book Price:");
                Double newPrice = sc.nextDouble();

                Library updatedDetails =
                        new Library(id, newBookName, newAuthor, newPrice);

                library.updateBook(updatedDetails);
                break;

            case 5:
                System.out.println("Enter Which Id you want to delete:");
                int deletedId = sc.nextInt();

                library.deleteBook(deletedId);
                break;

            case 6:
                System.out.println("Exit");
                break;

            default:
                System.out.println("Wrong Choice :( ");
            }

        } while(ch != 6);
    }
}
