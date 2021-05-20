package com.example.apikotlin.controller

import com.example.apikotlin.domain.AlunoDomain
import com.example.apikotlin.model.AlunoModel
import com.example.apikotlin.service.AlunoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
@ResponseBody
class AlunoController(val alunoService: AlunoService) {

    @GetMapping
    fun getAll(): MutableList<AlunoDomain> {
       return alunoService.getAll()
    }

    @GetMapping("/{ra}")
    fun getById(@PathVariable ra: Long) : AlunoModel{
        return alunoService.getById(ra)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastraAluno(@RequestBody alunoModel: AlunoModel){
        alunoService.cadastraAluno(alunoModel)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeAll(){
        alunoService.removeAll()
    }


    @DeleteMapping("/{ra}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeAluno(@PathVariable ra:Long){
        alunoService.removeAluno(ra)
    }


}