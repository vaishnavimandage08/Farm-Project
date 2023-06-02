package com.solvd.farm.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolExecute {
    private static final Logger logger = LogManager.getLogger(ConnectionPoolExecute.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executorService = Executors.newFixedThreadPool(connectionPool.MAX_POOL_SIZE);
        int numTasks = 5; // Number of tasks to run

        for (int i = 0; i < numTasks; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Connection connection = null;
                    try {
                        connection = connectionPool.getConnection();
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (connection != null) {
                            connectionPool.onFinishedExecuting(connection);
                        }
                    }
                }
            });
        }

        executorService.shutdown();
    }
}