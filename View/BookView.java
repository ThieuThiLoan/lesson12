/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BookController;
import Model.Book;
import java.sql.SQLException;

import java.util.ArrayList;

public class BookView {
    public void excute() throws SQLException{
        ArrayList<Book> data = BookController.getInstace().getAllBooks();
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }
}
