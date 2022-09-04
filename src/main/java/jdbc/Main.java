package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        // DBWork objesini olustur
        DBWork db = new DBWork();


        //Connecton methodunu cagir.
        Connection con = db.connect_to_db("techproed2", "postgres", "62191775");

        //Yeni table olusturma
        db.createTable(con, "employees");

    }
}
