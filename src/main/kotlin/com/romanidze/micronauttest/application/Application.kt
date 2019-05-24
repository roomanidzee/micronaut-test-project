package com.romanidze.micronauttest.application

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>){

        Micronaut.build()
                 .packages("com.romanidze.micronauttest")
                 .mainClass(Application.javaClass)
                 .start()
    }

}