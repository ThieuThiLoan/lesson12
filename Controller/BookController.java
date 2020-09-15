/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.BookDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class BookController {
    private static final BookController INSTANCE = new BookController();
    private BookController(){        
    }
    public static BookController getInstace(){
        return INSTANCE;        
    }
    BookDAO bookDAO = new BookDAO();
    public ArrayList<Book> getAllBooks() throws SQLException{
        return bookDAO.getAllBooks();        
    }  
}
