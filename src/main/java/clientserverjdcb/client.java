package clientserverjdcb;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server.");
            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1: List MCA Sci students");
                System.out.println("2: Retrieve student by ID");
                System.out.println("3: Update student details");
                System.out.println("4: Exit");

                String choice = userInput.readLine();
                if (choice.equals("4")) break;

                switch (choice) {
                    case "1":
                        out.println("SELECT * FROM STUDENT WHERE PROGRAM = 'MCA Sci';");
                        break;
                    case "2":
                        System.out.print("Enter Student ID: ");
                        String id = userInput.readLine();
                        out.println("SELECT * FROM STUDENT WHERE ID = " + id + ";");
                        break;
                    case "3":
                        System.out.print("Enter Student ID: ");
                        String updateId = userInput.readLine();
                        System.out.print("Enter New Name: ");
                        String newName = userInput.readLine();
                        System.out.print("Enter New Age: ");
                        String newAge = userInput.readLine();
                        out.println("UPDATE STUDENT SET NAME = '" + newName + "', AGE = " + newAge + " WHERE ID = " + updateId + ";");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }

                String response;
                while (!(response = in.readLine()).equals("END")) {
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}