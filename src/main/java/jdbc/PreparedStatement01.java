package jdbc;


import java.sql.*;

public class PreparedStatement01 {
    public static <PrepareStatement> void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erdal", "postgres", "aylaadem233");
        Statement st = con.createStatement();


        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //1. Adım:  Prepared statement query'sini oluştur.
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        //2. Adım: PreparedStatement objesini oluştur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3. Adım: set...() methodları ile soru işaretleri için değer gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4. Adım: Execute query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satır guncellendi.");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {
            System.out.println(result1.getInt(1) + " --- " + result1.getString(2) + " --- " + result1.getInt(3));

        }

        //3. Adım: set...() methodları ile soru işaretleri için değer gir.
        pst1.setInt(1, 1500);
        pst1.setString(2, "GOOGLE");

        //4. Adım: Execute query
        int updateRowSayisi1 = pst1.executeUpdate();
        System.out.println(updateRowSayisi1 + " satır guncellendi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result2 = st.executeQuery(sql2);

        while (result2.next()) {
            System.out.println(result2.getInt(1) + " --- "
                    + result2.getString(2) + " --- " + result2.getInt(3));
        }


  //   2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        System.out.println("===========================");
        PreparedStatementMethodCagirdik.readData(con,"companies");

        }
        // ALTTAKI METHODU BASKA CLASTA CLASS YAPTIK VE ONU CAGIRDIK. CLASSI YAPMAYIP ALTTAKINIDE KULLANABILIRDIK SADECE YORUMDAN ALMAK YETERLIDIR
        // Ustteki islemde yaptigimiz gibi yaptik olmadi datayi cagiramadigimiz icin method yapip onu kullandik
        // ve buna exeption attik
        // Bir tablonun istenilen datasini prepared statement ile cagirmak icin kullanilan metoda
       //blic static void readData (Connection con, String tableName){
       //  try {


       //      String query = String.format("SELECT *FROM %s", tableName); //String.Format() metodu stringi dinamik hale getirir
       //      // boylece stringi varibleye istedigimiz degeri atabiliriz.
       //      Statement statement = con.createStatement();

       //      ResultSet rs = statement.executeQuery(query);//  // SQL query calistirir. datayi cagirip REsultSet konteynirina koyuyoruz
       //      while (rs.next()) { //tum datayi cagiralim
       //          System.out.println(rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(3));
       //      }
       //  } catch (Exception e) {
       //      System.out.println(e);
       //  }




        }