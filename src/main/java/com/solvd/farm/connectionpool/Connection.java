package com.solvd.farm.connectionpool;

public class Connection {
    private int connectionId;
    private String connectionName;

    //private ConnectionPool.ConnectionStatus status;

    public Connection(int connectionId, String connectionName) {
        this.connectionId = connectionId;
        this.connectionName = connectionName;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }
}

