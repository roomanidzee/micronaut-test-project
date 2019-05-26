package com.romanidze.micronauttest.controllers.users

import com.romanidze.micronauttest.domain.User

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/users")
class UserController {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun userInfo(): HttpResponse<User> {
        return HttpResponse.ok(User("test", "test"))
    }

}