package jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed2", "postgres", "62191775");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //1.ADIM: Prepared statement query' sini olustur
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        //2.ADIM: PreparedStatement objesini olustur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3.ADIM: set...() methodlari ile soru isaretleri icin deger gir.
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        //4.ADIM: Execute query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi+" satir guncellendi.");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while(result1.next()){
            System.out.println(result1.getInt(1)+"--"+result1.getString(2)+"--"+result1.getInt(3));
        }

        //Google için değişiklik
        pst1.setInt(1,15000);
        pst1.setString(2,"GOOGLE");

        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi2+" satır güncellendi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result3 =  st.executeQuery(sql3);

        while (result3.next()){

            System.out.println(result3.getInt(1)+"--"+result3.getString(2)+"--"+result3.getInt(3));
        }

//      2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        System.out.println("---------------------");
        read_data(con,"companies");
//        String sql4 = "SELECT * FROM ?";
//
//        PreparedStatement pst2 = con.prepareStatement(sql4);
//
//        pst2.setString(1,"companies");
//
//        ResultSet result4 = pst2.executeQuery();
//
//        while (result4.next()){
//            System.out.println(result4.getInt(1)+"--"+result4.getString(2)+"--"+result4.getInt(3));
//        }


    }
    //Bir tablonun istenilen datasini prepared statement ile cagirmak icin kullanilan method
    public static void read_data(Connection con, String tableName){
        try {

            String query = String.format("SELECT * FROM %s",tableName);//format() methodu dinamik String olusturmak icin kullanilir.
           //SQL query' yi calistir.
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query); //Datayi cagirip ResultSet konteyner' ina koyuyoruz.
            while (rs.next()){  //Tum datyi cagiralim
                System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
            }

        }catch (Exception e){
            System.out.println(e);
        }




    }


}
