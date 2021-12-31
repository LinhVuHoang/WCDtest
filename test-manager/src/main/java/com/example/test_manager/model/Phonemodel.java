package com.example.test_manager.model;



import com.example.test_manager.entity.Phone;
import com.example.test_manager.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Phonemodel {
    public static void main(String[] args) {
    }

    public  boolean save(Phone phone){
        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into phones (name,brand,price,description) values(?,?,?,?)");
                        preparedStatement.setString(1,phone.getName());
                        preparedStatement.setInt(2,phone.getBrand());
                        preparedStatement.setDouble(3,phone.getPrice());
                        preparedStatement.setString(4,phone.getDescription());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public ArrayList<Phone> findAll(){
        Connection connection = ConnectionHelper.getConnection();
        ArrayList<Phone> result = new ArrayList<>();
        if(connection !=null){
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from  phones");
              ResultSet resultSet= preparedStatement.executeQuery();
              while(resultSet.next()){
                 int id = resultSet.getInt("id");
                 String name =   resultSet.getString("name");
                  int brand = resultSet.getInt("brand");
                  double price = resultSet.getDouble("price");
                 String description = resultSet.getString("description");

                  Phone phone = new Phone(id,name,brand,price,description);
                  result.add(phone);
              }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public Phone findById(int id){
        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null){
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from  phones where id =?");
                preparedStatement.setInt(1,id);
                ResultSet resultSet= preparedStatement.executeQuery();
                if(resultSet.next()){
                    int phoneid =    resultSet.getInt("id");
                    String name =   resultSet.getString("name");
                    int brand = resultSet.getInt("brand");
                    double price = resultSet.getDouble("price");
                    String description = resultSet.getString("description");
                    Phone phone = new Phone(phoneid,name,brand,price,description);
                    return phone;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public  boolean update(int id,Phone phone){

        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("update  phones set name=? , brand=?,price=?,description=? where id=? ");
                preparedStatement.setInt(5,id);
                preparedStatement.setString(1,phone.getName());
                preparedStatement.setInt(2,phone.getBrand());
                preparedStatement.setDouble(3,phone.getPrice());
                preparedStatement.setString(4,phone.getDescription());
                    preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public boolean delete(int id){

        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from phones where id=?");
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public boolean deletethin(int id){
        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("update  phones set status=-1  where id=? ");
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
