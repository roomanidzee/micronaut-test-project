package com.romanidze.micronauttest.application

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>){

        val packages: Array<String> = arrayOf("com.romanidze.micronauttest.controllers")

        Micronaut.build()
                 .packages(*packages)
                 .mainClass(Application.javaClass)
                 .start()
    }

}