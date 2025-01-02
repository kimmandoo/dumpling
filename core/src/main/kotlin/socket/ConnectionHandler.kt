package socket

import java.net.Socket

interface ConnectionHandler { // 클라이언트 연결 처리
    fun handle(socket: Socket)
}