import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("netology.homework",8079);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.println("Введите число для расчета");
                msg = scanner.nextLine();
                out.println(msg);
                if ("end".equals(msg)) break;
                try {
                    System.out.println("Ответ: " + in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
