package com.br.elton.poc.jwt.adapter.persistence

import com.br.elton.poc.jwt.adapter.entity.Person
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

}