package com.automation.util;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DbConsole {
    private static Server server;
    private static String DB_DRIVER = "org.h2.Driver";
    private static String DB_CONNECTION = "jdbc:h2:tcp://localhost/" + System.getProperty("java.io.tmpdir") + "/%s;DB_CLOSE_DELAY=-1;LOG=0;UNDO_LOG=0l;MVCC=TRUE";
    private static String DB_USER = "sa";
    private static String DB_PASS = "";

    public Server startH2DBConsole() throws SQLException {
        return Server.createWebServer("-ifNotExists").start();
    }

    public Server startTcpServer() throws SQLException {
        server = Server.createTcpServer();
        server.start();
        return server;
    }

    public void stopTcpServer() {
        if (server != null && server.isRunning(false)) {
            server.stop();
        }
    }

    public Connection getConnection(String dbName) throws SQLException, ClassNotFoundException {
        if (server == null) {
            server = startTcpServer();
        }
        if (!server.isRunning(false)) {
            startTcpServer();
        }
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(String.format(DB_CONNECTION, dbName), DB_USER, DB_PASS);
    }

    public static void main(String[] args) throws SQLException {
        H2DbConsole h2DbConsole = new H2DbConsole();
        h2DbConsole.startH2DBConsole();
    }
}
