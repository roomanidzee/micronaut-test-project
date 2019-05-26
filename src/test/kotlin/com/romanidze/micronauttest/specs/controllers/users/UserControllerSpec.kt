package com.romanidze.micronauttest.specs.controllers.users

import com.fasterxml.jackson.databind.ObjectMapper

import com.romanidze.micronauttest.domain.User

import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.PropertySource
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import kotlin.test.assertEquals

object UserControllerSpec : Spek({

    describe("UserController Suite"){

        val propertySource : PropertySource = PropertySource.of(mapOf<String, Int>("micronaut.server.port" to 8081))
        val embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java, propertySource)
        val client: HttpClient = HttpClient.create(embeddedServer.url)

        it("Проверяет, что модель возвращаемого User верна") {

            val mapper = ObjectMapper()
            val expectedString: String = mapper.writeValueAsString(User("test", "test"))

            val resp: String = client.toBlocking().retrieve("/users")
            assertEquals(expectedString, resp)

        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }

    }

})