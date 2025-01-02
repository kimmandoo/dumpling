package socket

interface TcpServer { // 라이프사이클 관리용 인터페이스
    fun start(port: Int)
    fun stop()
    fun isRunning(): Boolean
}