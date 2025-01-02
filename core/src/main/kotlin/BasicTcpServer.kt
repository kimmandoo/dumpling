import socket.ConnectionHandler
import socket.TcpServer
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

class BasicTcpServer(
    private val backlog: Int = 50,
    private val connectionHandler: ConnectionHandler
) : TcpServer {
    
    private val isRunning = AtomicBoolean(false)
    private var serverSocket: ServerSocket? = null
    private val threadPool = Executors.newCachedThreadPool()

    override fun start(port: Int) {
        if (isRunning.get()) {
            throw IllegalStateException("Server is already running")
        }

        serverSocket = ServerSocket().apply {
            bind(InetSocketAddress(port), backlog)
        }
        isRunning.set(true)

        // 클라이언트 연결을 수락하는 메인 루프
        threadPool.submit {
            while (isRunning.get()) {
                try {
                    val clientSocket = serverSocket?.accept() ?: break
                    handleNewConnection(clientSocket)
                } catch (e: Exception) {
                    if (isRunning.get()) {
                        // 로깅 추가 필요
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    private fun handleNewConnection(clientSocket: Socket) {
        threadPool.submit {
            try {
                connectionHandler.handle(clientSocket)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    clientSocket.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun stop() {
        isRunning.set(false)
        serverSocket?.close()
        threadPool.shutdown()
    }

    override fun isRunning(): Boolean = isRunning.get()
}