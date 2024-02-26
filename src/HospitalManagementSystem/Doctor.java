package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection;
    private Scanner scanner;

    public Doctor(Connection connection , Scanner scanner){
        this.connection=connection;
        this.scanner=scanner;
    }

    public void viewDoctor(){
        String query="SELECT * FROM doctors";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+---------------+----------------------+");
            System.out.println("| Doctor ID  |      Name     |    Specialisation    |");
            System.out.println("+------------+---------------+----------------------+");
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name= resultSet.getString("name");
                String specialisation=resultSet.getString("specialisation");
                System.out.printf("|%-12s|%-15s|%-22s|\n",id,name,specialisation);
                System.out.println("+------------+---------------+----------------------+");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
