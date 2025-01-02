package com.kimmandoo.dumpling

import BasicTcpServer
import EchoConnectionHandler

/**
 * echo서버 만들어서 돌리는 것
 */
fun runBasicTcpServer() {
    val server = BasicTcpServer(
        backlog = 50,
        connectionHandler = EchoConnectionHandler()
    )

    server.start(8080)
    println("8080포트에 서버 열기")

    Runtime.getRuntime().addShutdownHook(Thread {
        println("서버 닫는 중...")
        server.stop()
    })
}