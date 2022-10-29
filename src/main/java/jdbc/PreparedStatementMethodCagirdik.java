package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatementMethodCagirdik {
    public static void readData (Connection con, String tableName){
        try {


            String query = String.format("SELECT *FROM %s", tableName); //String.Format() metodu stringi dinamik hale getirir
            // boylece stringi varibleye istedigimiz degeri atabiliriz.
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);//  // SQL query calistirir. datayi cagirip REsultSet konteynirina koyuyoruz
            while (rs.next()) { //tum datayi cagiralim
                System.out.println(rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
