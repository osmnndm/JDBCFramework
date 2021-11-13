package com.techproed;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class DataBaseTesting {

    //Database url si.  mysql kullanacağımız için bunu yazdık oracle olsaydı oracle yazacaktık.
    String url = "jdbc:mysql://107.182.225.121:3306/LibraryMgmt";
    //kullanıcı adır
    String username = "techpro";
    //kullanıcı şifresi
    String password = "tchpr2020";

    //Connection, Statement, ResultSet objelerini oluşturulım.
    //Connection --> Database'e bağlanmak
    //Statement--> Databaseden data çekmek
    //ResulSet--> Cekilen dataları kullanıp assertion(doğrulama) yapma

    //3 tane obje oluşturuyoruz. her methodda kullanabilmek için başta burada tanımlama
    // yaptık instance variable oldu.
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    //tekrar tekrar her testten öncedatabase bağlanacağımız ve oradan data çekeceğimiz için bunu yazıyoruz
    // getConnection altı kırmızı oldu, addException yaparak çözdük.
    //  void setUp() throws SQLException { --> bunun manası connection yaptığında bağlanamadığında bana
    // hata olarak bilgi ver demek.
    @Before
    public void setUp() throws SQLException {
        //getConnection methodu ile database'e bağlanıyoruz
    connection = DriverManager.getConnection(url,username,password);
        //createStatement methoduyla statement objesi oluşturuyoruz.
        // Bu obyjei kullanarak resultset objesi oluşturacağız.
    statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }

    @Test
    public void Test1() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM book");
        // ilk satırda data olmadığı için her zaman ilk satırı atlıyoruz.
        resultSet.next();
        String deger1 = resultSet.getString("Bookname");
        System.out.println("DEGER1 : " + deger1);

    }
}
