package DESAFIO

class Curso(
        val nomeCurso: String,
        val codigoCurso: Int,
        val quantMaxAlunos: Int,
        professorTitular: ProfessorTitular,
        professorAdjunto: ProfessorAdjunto
) {

    var alunosMatriculados: MutableList<Aluno> = mutableListOf()
    var professorTitular = ProfessorTitular("", "", 0, "")
    var professorAdjunto = ProfessorAdjunto("", 0)

    override fun equals(other: Any?): Boolean {
        val curso = other as? Curso
        return when (other) {
            is Curso -> {
                this.nomeCurso == curso?.nomeCurso
                this.codigoCurso == curso?.codigoCurso
                this.quantMaxAlunos == curso?.quantMaxAlunos
            }
            else ->
                super.equals(other)
        }
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if (alunosMatriculados.size < quantMaxAlunos) {
            alunosMatriculados.add(umAluno)
            return true
        } else {
            return false
            println("Excelente! Você foi inserido no curso.")
        }
    }

    fun excluirUmAluno(umAluno: Aluno) {
        alunosMatriculados.remove(umAluno)
        println("Até Logo")
    }

}












