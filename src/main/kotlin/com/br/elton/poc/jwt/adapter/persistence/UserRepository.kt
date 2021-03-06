package com.br.elton.poc.jwt.adapter.persistence

import com.br.elton.poc.jwt.adapter.entity.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(email: String): Optional<User>

}