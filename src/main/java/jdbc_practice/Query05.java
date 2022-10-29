package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erdal", "postgres", "aylaadem233");
        Statement st = con.createStatement();
        // PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?,?,?,?)");

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')
        //  ps.setInt(1,300);
        //  ps.setString(2,"Sena Can");
        //  ps.setString(3,"12");
        //  ps.setString(4,"K");
        //  ps.executeUpdate();
       // int s1 = st.executeUpdate("insert into ogrenciler values(300, 'Sena Can', 12, 'K')");
        //System.out.println(s1 + " adet satir database'e eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

        String[] veri = {"insert into ogrenciler values(400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(402, 'Sena Can', 12, 'K')"};

       //int count=0;
       //for (String each:veri){
       //    count=count+st.executeUpdate(each);


       //}
       //System.out.println(count + "Satir eklendi");
        //2. yol
        String[] veri2 = {"insert into ogrenciler values(500, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(501, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(502, 'Sena Can', 12, 'K')"};

        for (String each:veri2){
            st.addBatch(each);    // yukaridaki datalarin hepsini birlestiriyor

        }
        st.executeBatch();       // datalari tek seferde gonderiyor
    }
}

