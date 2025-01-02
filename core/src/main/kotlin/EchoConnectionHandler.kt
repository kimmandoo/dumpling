import socket.ConnectionHandler
import java.net.Socket

class EchoConnectionHandler : ConnectionHandler {
    override fun handle(socket: Socket) {
        val input = socket.getInputStream().bufferedReader()
        val output = socket.getOutputStream().bufferedWriter()

        input.lineSequence().forEach { line ->
            output.write("$line\n")
            output.flush()
        }
    }
}