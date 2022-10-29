package jdbc;

import java.lang.reflect.Type;
import java.sql.*;

public class CallableStatement01 {
    /*
   Java'da methodlar return type sahibi olsa da, void olsa da method olarak adlandırılır.
   SQL'de ise data return ediyorsa "function" denir. Return yapmıyorsa "procedure" diye adlandırılır.
    */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

       Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erdal","postgres","aylaadem233");

        Statement st = con.createStatement();

        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        // 1. Adım: Fonksiyon kodunu yaz.
        String sql1= "CREATE OR REPLACE FUNCTION toplamaF(x numeric, y numeric)\n"+
                "RETURNS NUMERIC\n"+
                "LANGUAGE plpsql\n"+
                "AS\n"+
                "$$\n"+
                "BEGIN\n"+
                "\n"+
                "RETURN x+y;\n"+
                "END\n"+
                "$$";
        // 2. Adim: Fonksiyonu calistir
        st.execute(sql1);

        //3. Adim: Fonksiyonu cagir
        CallableStatement cst = con.prepareCall("{? = call toplama(?, ?)}");

        /* 4. Adım: Return için registerOutParameter() methodunu, parametreler için set()
         methodlarından uygun olanları kullan.*/
        cst.registerOutParameter(1, Types.NUMERIC);
        cst.setInt(2,-5);
        cst.setInt(3,5);

        //5. Adım: Çalıştırmak için execute() methodunu kullan.
        cst.execute();

        //6. Adım: Sonucu çağırmak için return data tipine göre "get" methodlarından uygun olanı kullan.
        System.out.println( cst.getBigDecimal(1));
        //================================================================================================

        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC, h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                " BEGIN\n" +
                " \n" +
                " RETURN 3.14 * r * r * h / 3;\n" +
                " \n" +
                " END\n" +
                "$$";

        st.execute(sql2);
        CallableStatement cst2 = con.prepareCall("{? = call koniHacmi(?, ?)}");
        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,1);
        cst2.execute();
        System.out.println(cst2.getBigDecimal(1));
    }
}
