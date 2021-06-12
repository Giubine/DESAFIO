package DESAFIO

import java.util.*

class DigitalHouseManager(
        val listaAlunos: MutableList<Aluno> = mutableListOf<Aluno>(),
        val listaprofessores: MutableList<Professor> = mutableListOf<Professor>(),
        var listaCursos: MutableList<Curso> = mutableListOf<Curso>(),
        val listaMatriculas: MutableList<Matricula> = mutableListOf<Matricula>()
) {
    fun registrarCurso(nomeCurso: String, codigoCurso: Int, quantMaxAlunos: Int) {
        val professorTitular = ProfessorTitular("", "", 0, "")
        val professorAdjunto = ProfessorAdjunto("", 0)
        val novoCurso = Curso(nomeCurso, codigoCurso, quantMaxAlunos, professorTitular, professorAdjunto)
        listaCursos.add(novoCurso)
        println("Novo curso registrado: $nomeCurso, código: $codigoCurso, e a quantidade limite dessa turma é de $quantMaxAlunos alunos.")
    }

    fun registrarCurso(nomeCurso: Curso) {
        listaCursos.add(nomeCurso)
    }

    fun excluirCurso(codigoCurso: Int) {
        listaCursos.removeAt(codigoCurso)
        println("Curso excluído.")
    }

    fun registrarProfessorAdjunto(nomeProfessor: String, quantidadeDeHoras: Int = 0) {
        val novoProfessorAdjunto1 = ProfessorAdjunto(nomeProfessor, quantidadeDeHoras)
        listaprofessores.add(novoProfessorAdjunto1)
        println("Seja Bem vindo Professor! $nomeProfessor Seu registro foi efetuado. Sua quantidade de horas atual é $quantidadeDeHoras Horas")
    }

    fun registrarProfessorAdjunto(professorAdjunto: ProfessorAdjunto) {
        listaprofessores.add(professorAdjunto)
    }

    fun registrarProfessorTitular(nomeProfessor: String, sobrenomeProfessor: String, codigoProfessor: Int, especialidade: String) {
        var novoProfessorTitular1 = ProfessorTitular(nomeProfessor, sobrenomeProfessor, codigoProfessor, especialidade)
        registrarProfessorTitular(novoProfessorTitular1)
        println("Seja Bem vindo Professor! $nomeProfessor $sobrenomeProfessor Seu registro foi efetuado. Seu código  de registro é: $codigoProfessor, e você ministrará o curso de $especialidade.")
    }

    fun registrarProfessorTitular(professorTitular: ProfessorTitular) {
        listaprofessores.add(professorTitular)
    }

    fun excluirProfessor(codigoProfessor: Int) {
        var professor: Professor
        listaprofessores.forEach {
            if (it.codigoProfessor == codigoProfessor) {
                professor = it
                listaprofessores.removeAt(codigoProfessor)
                println("Até logo Professor! Seu registro $codigoProfessor foi excluído.")
            }
        }
    }

    fun matricularAluno(nomeAluno: String, sobrenomeAluno: String, codigoAluno: Int) {
        val aluno1 = Aluno("Matheus", "Andrade", 1234, 20001)
        val aluno2 = Aluno("Thiago", "Santos", 1235, 20001)
        val aluno3 = Aluno("Felipe", "Lopes", 1236, 20002)
        val aluno4 = Aluno("Pedro", "Gonçalves", 1237, 20002)
        val aluno5 = Aluno("Paulo", "Oliveira", 1238, 20002)
        listaAlunos.add(aluno1)
        listaAlunos.add(aluno2)
        listaAlunos.add(aluno3)
        listaAlunos.add(aluno4)
        listaAlunos.add(aluno5)
        println("Prezado(a) Aluno(a), $nomeAluno $sobrenomeAluno Seja Bem vindo! Sua matrícula foi efetuada. Seu código de aluno é $codigoAluno")
    }

    fun matricularAluno(aluno: Aluno) {
        listaAlunos.add(aluno)
    }

    fun matricularAlunoCurso(codigoAluno: Int, codigoCurso: Int) {
        var aluno = Aluno("", "", +1, +1)
        var curso = Curso("", +1, +1, professorTitular = ProfessorTitular("", "", +1, ""), professorAdjunto = ProfessorAdjunto("", +1))
        listaCursos.forEach {
            if (it.codigoCurso == codigoCurso) {
                curso = it
                return@forEach
            }
        }
        listaAlunos.forEach {
            if (it.codigoAluno == codigoAluno) {
                aluno = it
                return@forEach
            }
        }
        aluno.let { alunoMatriculado ->
            if (curso.adicionarUmAluno(alunoMatriculado) == true) {
                val date = Calendar.getInstance()
                var date2 = Date()
                date2 = date.time
                curso.let { cursoMatriculado ->
                    val novaMatricula = Matricula(alunoMatriculado, cursoMatriculado, date2)
                    listaMatriculas.add(novaMatricula)
                }
                println("Boa escolha! $codigoAluno Sua matrícula foi efetuada nesse curso: $codigoCurso")
            } else {
                println("Que Pena! $codigoAluno Sua matrícula não pode ser efetuada nesse curso, pois não há vagas diponíveis")
            }
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {

        var novoProfessorTitular = ProfessorTitular("", "", 0, "")
        var novoProfessorAdjunto = ProfessorAdjunto("", 0)

        listaprofessores.forEach {
            if (it.codigoProfessor == codigoProfessorTitular) {
                novoProfessorTitular = it as ProfessorTitular
            }

            if (it.codigoProfessor == codigoProfessorAdjunto) {
                novoProfessorAdjunto = it as ProfessorAdjunto
            }
        }
        println("Obrigado Professor! $codigoProfessorAdjunto Seu registro já consta nesse curso: $codigoCurso")
        println("Obrigado Professor! $codigoProfessorAdjunto Seu registro já consta nesse curso: $codigoCurso")

        listaCursos.forEach {
            if (it.codigoCurso == codigoCurso) {
                it.professorTitular = novoProfessorTitular
                it.professorAdjunto = novoProfessorAdjunto
                return@forEach
            }
        }
    }
}


