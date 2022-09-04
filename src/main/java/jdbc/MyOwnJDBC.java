package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyOwnJDBC {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed2", "postgres", "62191775");
            Statement st = con.createStatement();

            String sql1 = "CREATE TABLE sirketler(sirket_id VARCHAR(50),sirket_name VARCHAR(50), sirket_ozsermaye INT)";
            boolean result = st.execute(sql1);
            System.out.println(result);


            String sql2 = "ALTER TABLE sirketler ADD sirket_adress VARCHAR(80)";
            st.execute(sql2);
            String sql3 = "DROP TABLE sirketler";
            st.execute(sql3);

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
