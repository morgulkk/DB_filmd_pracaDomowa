package DAO;

import DB.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface DAOInterface {

boolean insert ();


default boolean insertParams(List<String> filds, List<String> values){
    boolean status= false;
//TODO przeiterować się po liście  by były znaki zapytania 
    String query = "insert into ("+
            filds+
            ") values ("+
            values+
            ")";

    try (Connection connection = DataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.execute();
        status = true;
    } catch (SQLException e) {
        e.printStackTrace();
        status = false;
    }
//    finally {
//    }
    return status;
}


default  boolean delete (String table,Long id){
    boolean status= false;
    String query = "delete from "+
            table+
            "where id = "+
            id;

    try (Connection connection = DataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
         preparedStatement.execute();
         status = true;
    } catch (SQLException e) {
        e.printStackTrace();
        status = false;
    }
//    finally {
//    }
return status;
};

default boolean update (String table, String file, String value, String warunek){
    boolean status= false;
    String query = "update "+
            table+
            "set "+
            file+
            " = "+
            value+
            "where "+
            warunek;

    try (Connection connection = DataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.execute();
        status = true;
    } catch (SQLException e) {
        e.printStackTrace();
        status = false;
    }
//    finally {
//    }
    return status;
}
default boolean returnAll (String table){
    boolean status= false;
    String query = "select * from  "+
            table;

    try (Connection connection = DataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.executeQuery(); //TODO jet panel do wyświetlenia to do
        status = true;
    } catch (SQLException e) {
        e.printStackTrace();
        status = false;
    }
//    finally {
//    }
    return status;
    }
default boolean findById(String table, Integer id){
    boolean status= false;
    String query = "select * from  "+
            table+
            "where "+
            id;

    try (Connection connection = DataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.execute();
        status = true;
    } catch (SQLException e) {
        e.printStackTrace();
        status = false;
    }
//    finally {
//    }
    return status;
}
}
