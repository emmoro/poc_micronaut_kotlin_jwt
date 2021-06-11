package com.br.elton.poc.jwt

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.br.elton.poc.jwt")
		.start()
}

