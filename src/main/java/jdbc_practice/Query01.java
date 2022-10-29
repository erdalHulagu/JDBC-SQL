package jdbc_practice;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1) Driver yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erdal", "postgres", "aylaadem233");

        //3) Statement olustur
        Statement st = con.createStatement();

        //ResulSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //Sonuclari al
        while (veri.next()){

            //1)index kullanarak

            System.out.println(veri.getInt(1)+" "+veri.getString(2)+" "+veri.getString(3)+" "+veri.getString(4));

            //kapatma

            con.close();
            st.close();
            veri.close();
        }
    }
}
