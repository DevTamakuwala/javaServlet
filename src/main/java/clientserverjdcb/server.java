package clientserverjdcb;

import java.io.*;
import java.net.*;
import java.sql.*;

public class server {
    static String DB_URL = "jdbc:mysql://localhost:3306/advancejava";
    static String USER = "root";
    static String PASS = "9016204659";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                Connection conn = DriverManager.getConnection(server.DB_URL, server.USER, server.PASS);
                //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "1011");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String query;
            while ((query = in.readLine()) != null) {
                Statement stmt = conn.createStatement();
                if (query.startsWith("SELECT")) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        out.println(rs.getInt("ID") + " | " + rs.getString("NAME") + " | " +
                                rs.getString("PROGRAM") + " | " + rs.getInt("AGE"));
                    }
                    out.println("END");
                } else {
                    int result = stmt.executeUpdate(query);
                    out.println(result > 0 ? "Success" : "Failure");
                    out.println("END");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}