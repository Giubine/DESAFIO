package DESAFIO

open class Aluno constructor(
        val nomeAluno: String,
        val sobrenomeAluno: String,
        val codigoAluno: Int
) {
    constructor(nomeAluno: String, sobrenomeAluno: String, codigoAluno: Int, codigoCurso: Int) : this(nomeAluno, sobrenomeAluno, codigoAluno)


    override fun equals(other: Any?): Boolean {
        val aluno = other as? Aluno
        return when (other) {
            is Aluno -> {
                this.nomeAluno == aluno?.nomeAluno
                this.sobrenomeAluno == aluno?.sobrenomeAluno
                this.codigoAluno == aluno?.codigoAluno
            }
            else ->
                super.equals(other)
        }


    }
}
