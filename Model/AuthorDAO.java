
package Model;

import Helper.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAO {
    DatabaseUtil databaseUntil = new DatabaseUtil();
    public ArrayList<Author> getAllAuthors() throws SQLException{
        String sql = "SELECT * FROM book";
        ResultSet res = databaseUntil.executeQuery(sql);
        ArrayList<Author> authorList = new ArrayList<>();
        while(res.next()){
            Book temp = new Author();            
            temp.setId(res.getInt("id"));
            temp.setName(res.getString("name"));
            temp.setAge(res.getInt("age"));
            bookList.add(temp);           
        }
        return authorList;
    }
    public boolean addAuthor(Author newAuthor) {
        String newName = newAuthor.getName();
        int newAge = newAuthor.getAge();
        String sql =  "INSERT INTO Author(name, age) VALUES('"+ newAuthor.name +"', '"+newAuthor.age+ "')";
        try {
            ResultSet res = databaseUntil.executeQuery(sql);
            if (res.next() == false) {
                databaseUntil.updateQuery(sql);
                System.out.println("Successfully added");
                return true;
            } else {
                System.out.println("Author existed");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error found");
            return false;
        }    
    }
    public boolean deleteAuthorById(int deleteID) {
        String sql = "DELETE FROM Author WHERE id= '"+ deleteID +"'";
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
    public boolean updateAuthor (String newName, int newAge){
        String sql = "UPDATE Author SET name = '"+ newName +"', price = '"+ newAge +"' ";
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
