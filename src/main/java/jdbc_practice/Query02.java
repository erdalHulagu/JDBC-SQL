package jdbc_practice;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erdal", "postgres", "aylaadem233");

        Statement st = con.createStatement();

        //
        String str ="select * ogrenciler where cinsiyet='E'";
        ResultSet data= st.executeQuery(str);


        while (data.next()){
            System.out.println(data.getInt(1)+ data.getString(2)+ data.getString(3)+data.getString(4));
        }
        con.close();
        st.close();

    }
}
