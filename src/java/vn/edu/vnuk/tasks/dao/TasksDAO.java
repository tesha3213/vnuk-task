/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vnuk.tasks.dao;

/**
 *
 * @author Hoang Trung
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import vn.edu.vnuk.tasks.jdbc.ConnectionFactory;
import vn.edu.vnuk.tasks.model.Tasks;
public class TasksDAO {
private Connection connection;

    public TasksDAO(){
            this.connection = new ConnectionFactory().getConnection();
    }


    //  CREATE
    public void create(Tasks task) throws SQLException{

        String sqlQuery = "insert into tasks (id, description, complete, date_of_completion) "
                        +	"values (?, ?, ?, ?)";

        PreparedStatement statement;

        try {
                statement = connection.prepareStatement(sqlQuery);

                //	Replacing "?" through values
                statement.setLong(1, task.getId());
                statement.setString(2, task.getDescription());
                statement.setString(3, task.getComplete());
                statement.setDate(4, new Date(task.getDateOfCompletion().getTimeInMillis()));

                // 	Executing statement
                statement.execute();

                System.out.println("New record in DB !");

        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                System.out.println("Done !");
                connection.close();
        }

    }
    
    
    //  READ (List of Tasks)
    @SuppressWarnings("finally")
    public List<Tasks> read() throws SQLException {

        String sqlQuery = "select * from tasks";
        PreparedStatement statement;
        List<Tasks> tasks = new ArrayList<Tasks>();

        try {

            statement = connection.prepareStatement(sqlQuery);

            // 	Executing statement
            ResultSet results = statement.executeQuery();

            while(results.next()){

                Tasks task = new Tasks();
                task.setId(results.getLong("id"));
                task.setDescription(results.getString("description"));
                task.setComplete(results.getString("complete"));
               

                Calendar date = Calendar.getInstance();
                date.setTime(results.getDate("date_of_completion"));
                task.setDateOfCompletion(date);

                task.add(tasks);

            }

            results.close();
            statement.close();


        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                connection.close();
                return tasks;
        }


    }


    //  READ (Single Tasks)
    @SuppressWarnings("finally")
    public Tasks read(int id) throws SQLException{

        String sqlQuery = "select * from tasks where id=?";

        PreparedStatement statement;
        Tasks tasks = new Tasks();

        try {
            statement = connection.prepareStatement(sqlQuery);

            //	Replacing "?" through values
            statement.setLong(1, id);

            // 	Executing statement
            ResultSet results = statement.executeQuery();

            if(results.next()){

                tasks.setId(results.getLong("id"));
                tasks.setDescription(results.getString("description"));
                tasks.setComplete(results.getString("complete"));
               

                Calendar date = Calendar.getInstance();
                date.setTime(results.getDate("date_of_completion"));
                tasks.setDateOfCompletion(date);

            }

            statement.close();

        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                connection.close();
                return tasks;
        }

    }


    //  UPDATE
    public void update(Tasks tasks) {
        String sqlQuery = "update tasks set id=?, description=?," 
                            + "complete=?, date_of_completion=? where id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, tasks.getDescription());
            statement.setString(2, tasks.getComplete());
            statement.setDate(4, new Date(tasks.getDateOfCompletion().getTimeInMillis()));
            statement.setLong(5, tasks.getId());
            statement.execute();
            statement.close();
            
            System.out.println("Tasks successfully modified.");
        } 

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    
    //  DELETE
    public void delete(Tasks tasks) {
        String sqlQuery = "delete from Taskss where id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, tasks.getId());
            statement.execute();
            statement.close();
            
            System.out.println("Tasks successfully deleted.");

        } 

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
}
