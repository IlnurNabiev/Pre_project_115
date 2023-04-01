package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                //settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydbtest?useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydbtest?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void CloseSessionFactory (SessionFactory sessionFactory) {
        sessionFactory.close();
    }

//    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
//    public static final String  DB_USERNAME = "root";
//    public static final String DB_PASSWORD = "root";
//
//    public static Connection getConnection()  {
//        Connection connection = null;
//        try {
//            Class.forName(DB_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            System.out.println("ERROR");
//        }
//        return connection;
//
//        }
    }

