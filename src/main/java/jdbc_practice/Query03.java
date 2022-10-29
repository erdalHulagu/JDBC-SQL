package jdbc_practice;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erdal",
                                                     "postgres", "aylaadem233");
        //Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Sutun sayisi = "+rsmd.getColumnCount());

        System.out.println();

        System.out.println("Sutun isim 01= "+ rsmd.getColumnName(1));
        System.out.println("Sutun isim 02 = "+ rsmd.getColumnName(2));
        System.out.println("Sutun isim 03 = "+ rsmd.getColumnName(3));
        System.out.println("Sutun isim 04= "+ rsmd.getColumnName(4));

        System.out.println();

        System.out.println("1. sutunun data tipi = "+rsmd.getColumnTypeName(1));
        System.out.println("2. sutunun data tipi = "+rsmd.getColumnTypeName(2));
        System.out.println("3. sutunun data tipi = "+rsmd.getColumnTypeName(3));
        System.out.println("4. sutunun data tipi = "+rsmd.getColumnTypeName(4));





    }
}
