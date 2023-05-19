package com.solvd.farm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddConnection {
    private static final Logger logger = LogManager.getLogger(AddConnection.class);
    public static void main(String[] args) throws InterruptedException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        // Add connections to the pool
        Connection connection1 = new Connection(1, "API 1");
        Connection connection2 = new Connection(2, "API 2");
        Connection connection3 = new Connection(3, "API 3");
        Connection connection4 = new Connection(4, "API 4");
        Connection connection5 = new Connection(5, "API 5");
        connectionPool.execute(connection1);
        connectionPool.execute(connection2);
        connectionPool.execute(connection3);
        connectionPool.execute(connection4);
        connectionPool.execute(connection5);
//        Connection connection1 = connectionPool.getConnection();
//        Connection connection2 = connectionPool.getConnection();
//        Connection connection3 = connectionPool.getConnection();
//        Connection connection4 = connectionPool.getConnection();
//        Connection connection5 = connectionPool.getConnection();
//
//        // Create threads to get and print connections
//        Thread t1 = new Thread(() -> {
//            Connection connection = connectionPool.getConnection();
//            if (connection != null) {
//                logger.info(connection.getConnectionName());
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            Connection connection = connectionPool.getConnection();
//            if (connection != null) {
//                logger.info(connection.getConnectionName());
//            }
//        });
//
//        Thread t3 = new Thread(() -> {
//            Connection connection = connectionPool.getConnection();
//            if (connection != null) {
//                logger.info(connection.getConnectionName());
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t1.join();
//        t2.join();
//        t3.join();
    }
}

