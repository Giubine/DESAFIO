package DESAFIO

fun main() {

    val novoProfessorTitular = DigitalHouseManager()
    val novoProfessorAdjunto = DigitalHouseManager()

    novoProfessorTitular.registrarProfessorTitular("José", "Silva", 20, "Full Stack")
    novoProfessorAdjunto.registrarProfessorAdjunto("João", 650)
    novoProfessorTitular.registrarProfessorTitular("Antonio", "Souza", 23, "Android")
    novoProfessorAdjunto.registrarProfessorAdjunto("Francisco", 520)

    val novoCurso = DigitalHouseManager()

    novoCurso.registrarCurso("Full Stack", 20001, 3)
    novoCurso.registrarCurso("Android", 20002, 2)

    val alocarProfessor = DigitalHouseManager()

    alocarProfessor.alocarProfessores(20001, 20, 21)
    alocarProfessor.alocarProfessores(20002, 23, 22)

    val novaMatricula = DigitalHouseManager()

    novaMatricula.matricularAluno("Matheus", "Andrade", 1234)
    novaMatricula.matricularAluno("Thiago", "Santos", 1235)
    novaMatricula.matricularAluno("Felipe", "Lopes", 1236)
    novaMatricula.matricularAluno("Pedro", "Gonçalves", 1237)
    novaMatricula.matricularAluno("Paulo", "Oliveira", 1238)

    val matriculaAluno = DigitalHouseManager()

    matriculaAluno.matricularAlunoCurso(1234, 20001)
    matriculaAluno.matricularAlunoCurso(1235, 20001)
    matriculaAluno.matricularAlunoCurso(1236, 20002)
    matriculaAluno.matricularAlunoCurso(1237, 20002)
    matriculaAluno.matricularAlunoCurso(1238, 20002)
}









