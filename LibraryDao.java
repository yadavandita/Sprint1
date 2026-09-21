package com.Library.dao;

import java.util.List;
import com.Library.pojo.Library;

public interface LibraryDao {

    void addBook(Library book);

    List<Library> getAllBooks();

    Library getBookById(int id);

    void updateBook(Library book);

    void deleteBook(int id);
}
