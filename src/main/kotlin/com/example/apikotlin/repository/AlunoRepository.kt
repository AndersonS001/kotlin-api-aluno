package com.example.apikotlin.repository

import com.example.apikotlin.domain.AlunoDomain
import org.springframework.data.mongodb.repository.MongoRepository

interface AlunoRepository : MongoRepository<AlunoDomain, Long> {
}