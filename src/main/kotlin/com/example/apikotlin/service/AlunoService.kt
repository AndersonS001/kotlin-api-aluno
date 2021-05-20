package com.example.apikotlin.service

import com.example.apikotlin.domain.AlunoDomain
import com.example.apikotlin.model.AlunoModel
import com.example.apikotlin.repository.AlunoRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.Throws

@Service
class AlunoService(val alunoRepository: AlunoRepository) {
    fun getAll(): MutableList<AlunoDomain> {
        return alunoRepository.findAll()
    }

    fun cadastraAluno(alunoModel: AlunoModel) {
        alunoRepository.save(AlunoModel.toDomain(alunoModel))
    }

    fun removeAluno(ra: Long) {
        alunoRepository.delete(findById(ra))
    }

    fun getById(ra: Long): AlunoModel {
        val aluno = findById(ra)

        return AlunoDomain.toModel(aluno)
    }

    @Throws(ResponseStatusException::class)
    private fun findById(ra:Long) : AlunoDomain{
        val aluno = alunoRepository.findById(ra)

        if(!aluno.isPresent)
            throw ResponseStatusException(HttpStatus.NOT_FOUND)

        return aluno.get()
    }

    fun removeAll() {
        alunoRepository.deleteAll()
    }
}