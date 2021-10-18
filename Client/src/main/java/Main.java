import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static String HOST = "localhost";
    public static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер члена ряда Фибоначчи для вычисления на сервере:");
            String number = scanner.nextLine();
            out.println(number);
            String fibonacciNumber = null;
            //ожидание получения результата от сервера
            while (fibonacciNumber == null) {
                fibonacciNumber = in.readLine();
            }
            System.out.printf("%s-е число Фибоначи равно %s", number, fibonacciNumber);
        }
    }
}
