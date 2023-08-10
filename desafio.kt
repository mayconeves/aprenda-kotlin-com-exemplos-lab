enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val id: Long)

data class ConteudoEducacional(val nome: String, val stack: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    infix fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println("Conteúdo: ${conteudo.nome}\t Módulo: ${conteudo.stack} \t Duração: ${conteudo.duracao}")
    }

    fun mostrarInscritos(){
        for(inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
    // Criando os usuários
    val usuario1 = Usuario("Joao", 1L)
    val usuario2 = Usuario("Maria", 2L)
    val usuario3 = Usuario("Jose", 3L)
    val usuario4 = Usuario("Marcos", 4L)
    val usuario5 = Usuario("Mateus", 5L)

    // Criando a lista de conteúdos
    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Desmistificando a Linguagem de Programação Kotlin","Kotlin", 60),
        ConteudoEducacional("Fundamentos de Desenvolvimento Mobile Nativo Para Android","Kotlin", 48),
        ConteudoEducacional("Noções Básicas do Android com Kotlin","Kotlin", 120),
    	ConteudoEducacional("Dominando o Android Jetpack","Fundamentos Kotlin", 80))

    // Criando a formação
    val formacao = Formacao("Formação Android Developer", listaConteudosKotlin, Nivel.INICIANTE)
    
    // Verificando se a variável de formação não é nula, caso não seja, matriculando alunos
    formacao?.let{
        formacao.matricular(usuario1, usuario2, usuario3)
    }

    // Imprimindo na tela
      println("Formação:\n${formacao.nome}\n")
    println("Conteúdos:")
    formacao.mostrarConteudos()
    println("\nInscritos:")
    formacao.mostrarInscritos()

}