package com.br.elton.poc.jwt.config

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class BCryptPasswordEncoderService : PasswordEncoder {

    private val bCryptEncoder = BCryptPasswordEncoder()

    override fun encode(rawPassword: CharSequence?): String {
        return bCryptEncoder.encode(rawPassword)
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
        return bCryptEncoder.matches(rawPassword, encodedPassword)
    }

}