package com.romanidze.micronauttest.specs.controllers.hello

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import kotlin.test.assertEquals

object HelloControllerSpec : Spek({

    describe("HelloController Suite"){

        val embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: HttpClient = HttpClient.create(embeddedServer.url)

        it("проверяет, что /hello отдаёт \"Категорически приветствую\"") {

            val resp: String = client.toBlocking().retrieve("/hello")
            assertEquals("Категорически приветствую", resp)

        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }

    }

})