package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query04 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed2",
                "postgres",
                "62191775");
        PreparedStatement ps = con.prepareStatement("INSERT INTO ogrenciler VALUES(?, ?, ?, ?)");
        ps.setInt(1, 200);
        ps.setString(2,"Veli Can");
        ps.setString(3,"12");
        ps.setString(4,"E");

        ps.executeUpdate();
        System.out.println("Veri girisi yapildi.");


    }
}