/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author admin
 */
public class BookDAO {
    DatabaseUtil databaseUntil = new DatabaseUtil();
    public ArrayList<Book> getAllBooks() throws SQLException{
        String sql = "SELECT * FROM book";
        ResultSet res = databaseUntil.executeQuery(sql);
        ArrayList<Book> bookList = new ArrayList<>();
        while(res.next()){
            Book temp = new Book();            
            temp.setId(res.getInt("id"));
            temp.setName(res.getString("name"));
            temp.setPrice(res.getInt("price"));
            bookList.add(temp);           
        }
        return bookList;
    }
    public boolean addBook(Book newBook) {
        String newName = newBook.getName();
        int newPrice = newBook.getPrice();
        String sql =  "INSERT INTO book(name, price) VALUES('"+ newBook.name +"', '"+newBook.price+ "')";
        try {
            ResultSet res = databaseUntil.executeQuery(sql);
            if (res.next() == false) {
                databaseUntil.updateQuery(sql);
                System.out.println("Successfully added");
                return true;
            } else {
                System.out.println("Book existed");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error found");
            return false;
        }    
    }
    public boolean deleteBookById(int deleteID) {
        String sql = "DELETE FROM book WHERE id= '"+ deleteID +"'";
        try {
           ResultSet res = databaseUntil.executeQuery(sql); 
            if (res.next() == false) {
               databaseUntil.executeQuery(sql);
                System.out.println("Successfully delete");
                return true;               
            } else {
                System.out.println("delete fail");
                return false;
            }
        } catch (SQLException e){
            System.out.println("false");
            return false;
        }        
    }
    public boolean updateBook (String newName, int newPrice){
        String sql = "UPDATE book SET name = '"+ newName +"', price = '"+ newPrice +"' ";
        try {
            ResultSet res = databaseUntil.executeQuery(sql);
            if (res.next() == false) {
                databaseUntil.executeQuery(sql);
                System.out.println("Successfully update");
                return true;
                
            } else {
                System.out.println("update false");
                return false;
            }
        } catch (SQLException e){
            System.out.println("false");
            return false;
        }
    }
}
