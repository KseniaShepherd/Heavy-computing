import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8079);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(),
                         true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    int n = Integer.parseInt(line);
                    int fib1 = 1;
                    int fib2 = 1;
                    int fibSum;
                    for (int i = 1; i < n-2; i++) {
                        fibSum = fib1 + fib2;
                        fib1 = fib2;
                        fib2 = fibSum;
                    }
                    out.println(fib2);
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}