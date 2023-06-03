package com.solvd.farm.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

     final int MAX_POOL_SIZE = 3;
    private static ConnectionPool connectionPool;

    private int connectionNumber = 0;

    private ConnectionPool() {
    }

    public static synchronized ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public synchronized Connection getConnection() throws InterruptedException {
        connectionNumber++;
        Connection connection = new Connection(connectionNumber, "Connection " + connectionNumber);
        logger.info("Acquired next connection from the pool: " + connection.getConnectionName());
        return connection;
    }

    public synchronized void onFinishedExecuting(Connection connection) {
        logger.info("Finished executing: " + connection.getConnectionName());
    }
}


