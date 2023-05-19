package com.solvd.farm.connectionpool;

public class Connection {
        private int connectionId;
        private String connectionName;

        private ConnectionPool.ConnectionStatus status;

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

        public void setStatusInterface(ConnectionPool.ConnectionStatus statusInterface) {
            this.status = statusInterface;
        }

        public Runnable getRunnable() {
            return new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running connection with id: "
                            + connectionId
                            + " and name: "
                            + connectionName
                    );

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
//                    ConnectionPool.onFinishedExecution(Connection.this);
                    status.onFinished(Connection.this);
                }
            };
        }
    }

