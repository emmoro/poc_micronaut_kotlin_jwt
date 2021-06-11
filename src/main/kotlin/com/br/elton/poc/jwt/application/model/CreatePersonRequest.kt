package com.br.elton.poc.jwt.application.model

import java.time.LocalDate

data class CreatePersonRequest (
    val name: String,
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String

)