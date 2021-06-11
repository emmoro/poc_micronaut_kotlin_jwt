package com.br.elton.poc.jwt.presentation

import com.br.elton.poc.jwt.application.model.CreatePersonRequest
import com.br.elton.poc.jwt.application.model.PersonResponse
import com.br.elton.poc.jwt.application.model.UpdatePersonRequest
import com.br.elton.poc.jwt.application.service.PersonService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.net.URI
import javax.annotation.security.RolesAllowed

@Controller("/api/persons")
@Secured(SecurityRule.IS_AUTHENTICATED)  //This annotation configures that only successfully authenticated users have access
class PersonController(private val personService: PersonService) {

    @Produces(MediaType.APPLICATION_JSON)
    @Get
    @RolesAllowed("ROLE_READ_PERSON") //This annotation only allows users authenticated with Role of 'ROLE_READ_PERSON' registered in the previous scripts.
    fun findByAll(): HttpResponse<List<PersonResponse>> {
        return HttpResponse.ok(personService.findByAll())
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{code}")
    @RolesAllowed("ROLE_READ_PERSON")
    fun findByCode(@PathVariable code: Long): HttpResponse<PersonResponse> {
        return HttpResponse.ok(personService.findByCode(code))
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post
    @RolesAllowed("ROLE_CREATE_PERSON")
    fun save(@Body createPersonRequest: CreatePersonRequest): HttpResponse<PersonResponse>  {
        val response = personService.save(createPersonRequest)
        return HttpResponse
            .created(response)
            .headers { headers -> headers.location(toUri(response.code)) }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{code}")
    @RolesAllowed("ROLE_UPDADE_PERSON")
    fun update(@PathVariable code: Long, @Body updatePersonRequest: UpdatePersonRequest): HttpResponse<PersonResponse> {

        val response = personService.update(code, updatePersonRequest)
        return HttpResponse.ok(response)
            .headers { headers -> headers.location(toUri(response.code)) }
    }

    @Delete("/{code}")
    @RolesAllowed("ROLE_REMOVE_PERSON")
    fun delete(@PathVariable code: Long): HttpResponse<Void> {

        personService.delete(code)
        return HttpResponse.noContent()
    }

    private fun toUri(code: Long?): URI? {
        return URI.create("/api/persons/${code}")
    }

}