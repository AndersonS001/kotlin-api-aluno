package com.example.apikotlin.model

import com.example.apikotlin.domain.AlunoDomain

data class AlunoModel(
    val nome: String,
    val ra: Long
){
    companion object{
        fun toDomain(alunoModel: AlunoModel) : AlunoDomain{
            return AlunoDomain(ra = alunoModel.ra, nome = alunoModel.nome)
        }
    }

}
