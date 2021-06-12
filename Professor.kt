package DESAFIO

open class Professor constructor(
        val nomeProfessor: String,
        val sobrenomeProfessor: String,
        var tempoDeCasa: Int,
        val codigoProfessor: Int
) {
    override fun equals(other: Any?): Boolean {
        val professorTitular = other as? Professor
        val professorAdjunto = other as? Professor
        return when (other) {
            is Professor -> {
                this.nomeProfessor == professorTitular?.nomeProfessor
                this.sobrenomeProfessor == professorTitular?.sobrenomeProfessor
                this.codigoProfessor == professorTitular?.codigoProfessor
                this.tempoDeCasa == professorTitular?.tempoDeCasa
                        || this.nomeProfessor == professorAdjunto?.nomeProfessor
                this.sobrenomeProfessor == professorAdjunto?.sobrenomeProfessor
                this.codigoProfessor == professorAdjunto?.codigoProfessor
                this.tempoDeCasa == professorAdjunto?.tempoDeCasa
            }
            else -> {
                super.equals(other)
            }
        }
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}




