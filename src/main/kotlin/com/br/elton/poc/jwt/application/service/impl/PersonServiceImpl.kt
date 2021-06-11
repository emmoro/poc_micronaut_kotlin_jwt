package com.br.elton.poc.jwt.application.service.impl

import com.br.elton.poc.jwt.adapter.entity.Person
import com.br.elton.poc.jwt.adapter.persistence.PersonRepository
import com.br.elton.poc.jwt.application.exception.ObjectNotFoundException
import com.br.elton.poc.jwt.application.model.CreatePersonRequest
import com.br.elton.poc.jwt.application.model.PersonResponse
import com.br.elton.poc.jwt.application.model.UpdatePersonRequest
import com.br.elton.poc.jwt.application.service.PersonService
import javax.inject.Singleton

@Singleton
class PersonServiceImpl(private val repository: PersonRepository) : PersonService {

    override fun findByAll(): List<PersonResponse> {
        return repository.findAll().map { p ->
            PersonResponse(p.code, p.name, p.dateOfBirth, p.cpf, p.email)
        }
    }

    override fun findByCode(code: Long): PersonResponse {
        val (codeRes, name, dateOfBirth, cpf, email) = repository.findById(code)
            .orElseThrow { ObjectNotFoundException("Code $code not found") }
        return PersonResponse(code, name, dateOfBirth, cpf, email)
    }

    override fun save(createPersonRequest: CreatePersonRequest): PersonResponse {

        val (code, name, dateOfBirth, cpf, email) = repository.save(
            Person(
                code = null,
                name = createPersonRequest.name,
                dateOfBirth = createPersonRequest.dateOfBirth,
                cpf = createPersonRequest.cpf,
                email = createPersonRequest.email
            )
        )

        return PersonResponse(code, name, dateOfBirth, cpf, email)

    }

    override fun update(id: Long, updatePersonRequest: UpdatePersonRequest): PersonResponse {

        val personSaved = exist(id)

        personSaved.name = updatePersonRequest.name
        personSaved.dateOfBirth = updatePersonRequest.dateOfBirth
        personSaved.cpf = updatePersonRequest.cpf
        personSaved.email = updatePersonRequest.email

        val (code, name, dateOfBirth, cpf, email) = repository.update(personSaved)

        return PersonResponse(code, name, dateOfBirth, cpf, email)
    }

    override fun delete(code: Long) {
        exist(code)
        repository.deleteById(code)
    }

    private fun exist(code: Long): Person {
        return repository.findById(code).orElseThrow { ObjectNotFoundException("Code $code not found") }
    }

}