package com.solvd.farm.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPoolExecute {
    private static final Logger logger = LogManager.getLogger(ConnectionPoolExecute.class);
    public static void main(String[] args)  {
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

    }
}

