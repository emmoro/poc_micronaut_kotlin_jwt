package com.br.elton.poc.jwt.application.service

import com.br.elton.poc.jwt.application.model.CreatePersonRequest
import com.br.elton.poc.jwt.application.model.PersonResponse
import com.br.elton.poc.jwt.application.model.UpdatePersonRequest

interface PersonService {

    fun findByAll(): List<PersonResponse>

    fun findByCode(code: Long): PersonResponse

    fun save(createPersonRequest: CreatePersonRequest): PersonResponse

    fun update(id: Long, updatePersonRequest: UpdatePersonRequest): PersonResponse

    fun delete(code: Long)

}