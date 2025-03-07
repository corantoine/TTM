//package fr.initiativedeuxsevres.ttm;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
///**
// * Classe permettant de tester que l'application est connectée à la base de données.
// */
//
//@SpringBootTest
//public class DatabaseConnectionTest {
//
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Disabled("")
//    @Test
//    public void testConnection() throws SQLException {
//        try (Connection connection = dataSource.getConnection()) {
//            Assertions.assertNotNull(connection);
//            Assertions.assertFalse(connection.isClosed());
//        }
//    }
//}
