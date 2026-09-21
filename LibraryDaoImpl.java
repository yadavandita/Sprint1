package com.Library.dao;

import java.util.ArrayList;
import java.util.List;

import com.Library.pojo.Library;

public class LibraryDaoImpl implements LibraryDao {

    private List<Library> books = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void addBook(Library book) {
        book.setId(nextId++);
        books.add(book);
        System.out.println("Book Added Successfully!!!!");
    }

    @Override
    public List<Library> getAllBooks() {
        return books;
    }

    @Override
    public Library getBookById(int id) {
        for(Library book : books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void updateBook(Library updatedBook) {
        Library existingBook = getBookById(updatedBook.getId());

        if(existingBook != null) {
            existingBook.setBookName(updatedBook.getBookName());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            System.out.println("Book Updated Successfully!!!!");
        } else {
            System.out.println("Book Not Found!!!!");
        }
    }

    @Override
    public void deleteBook(int id) {
        Library book = getBookById(id);

        if(book != null) {
            books.remove(book);
            System.out.println("Book Deleted Successfully!!!!");
        } else {
            System.out.println("Book Not Found!!!!");
        }
    }
}
