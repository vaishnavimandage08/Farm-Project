package com.solvd.farm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

    private static final int MAX_POOL_SIZE = 3;
    private static ConnectionPool connectionPool;
    private static final List<Connection> connections = new ArrayList<>();

    private int currentRunning = 0;
    private ConnectionPool(){}

    public static synchronized ConnectionPool getInstance(){
        if(connectionPool ==null){
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    private synchronized void addConnection(Connection connection) {
        connections.add(connection);
    }

    public void execute(Connection connection) {
        connection.setStatusInterface(getStatusInterface());
        if (currentRunning >= MAX_POOL_SIZE) {
            System.out.println("MAX_POOL_SIZE reached. Adding connection " + connection.getConnectionId() + " to queue");
            addConnection(connection);
            return;
        }
        currentRunning ++;
//        Connection currentConnection = connections.remove(0);
        Thread t1 = new Thread(connection.getRunnable());
        t1.start();
    }

    private synchronized void executePending() {
        if (connections.size() > 0) {
            System.out.println("Execute pending connection with id: " + connections.get(0).getConnectionId());
            execute(connections.remove(0));
        }
    }

    private ConnectionStatus getStatusInterface() {
        return new ConnectionStatus() {
            @Override
            public void onFinished(Connection connection) {
                currentRunning --;
                executePending();
            }
        };
    }

    interface ConnectionStatus {
        void onFinished(Connection connection);
    }
}

