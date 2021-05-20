package com.example.apikotlin.domain

import com.example.apikotlin.model.AlunoModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "aluno")
data class AlunoDomain(
    @Id
    val ra : Long,

    val nome : String
) {
    companion object{
        fun toModel(alunoDomain: AlunoDomain):AlunoModel{
            return AlunoModel(nome = alunoDomain.nome, ra = alunoDomain.ra)
        }
    }
}
