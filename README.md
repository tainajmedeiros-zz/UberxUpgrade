<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">Uberx</h3>

  <p align="center">
    REST API desenvolvida para auxilio de estudos as alunas do curso da Luiza Code!
    <br />
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">Sobre o projeto</a>
      <ul>
        <li><a href="#built-with">Tecnologias utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Começando</a>
      <ul>
        <li><a href="#installation">Instalando</a></li>
      </ul>
    </li>
    <li><a href="#usage">Uso</a></li>
    <li><a href="#contact">Contatos</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Sobre o projeto

Essa API permite que as alunas desenvolvedoras do curso da sigam com um exemplo final do curso. O projeo intitulado Uberx centraliza informações sobre viagens de passageiros.

![swagger-completo-screenshot][swagger-completo-screenshot]


A arquitetura do projeto é formada por:
* EndPoints que podem ser usados por uma aplicação FrontEnd
* Exemplo de um database simples, porém com relacionamentos do tipo OneToOne e OneToMany


### Tecnologias utilizadas

O projeto foi criado usando as seguintes tecnologias:
* [Java 8 or more]
* [Spring framework]
* [Bando de dados H2]


<!-- GETTING STARTED -->
## Começando

Siga as instruções para executar a API.

### Instalando

1. Clone o repositório
   ```sh
   git clone https://github.com/tainajmedeiros/ErrorCenter.git
   ```
2. Excute o projeto por qualquer IDE
   ```sh
   run
   ```
3. Acesse os endpoints 
   ```sh
   Postman / Insomnia 
   ```
4. Acesse o Swagger
   ```sh
   localhost:8080/swagger-uui.html
   ```
   
<!-- USAGE EXAMPLES -->
## Uso

Você tem acesso aos endpoints de Passageiro, Cartão e Viagem

_Passageiro Endpoints_
![swagger-passageiro-screenshot][swagger-passageiro-screenshot]

_Cartão Endpoints_
![Swagger log Screen Shot][swagger-cartao-screenshot]

_Viagem Endpoints_
![swagger-viagem-screenshot][swagger-viagem-screenshot]

<!-- CONTACT -->
## Contatos

Tainá Medeiros - [@taina_medeiros](https://twitter.com/taina_medeiros) - tainajmedeiros@gmail.com

LinkedIn: [/tainamedeiros](https://www.linkedin.com/in/tainamedeiros)

Project Link: [https://github.com/tainajmedeiros/UberxUpgrade](https://github.com/tainajmedeiros/UberxUpgrade)



<!-- MARKDOWN LINKS & IMAGES -->
[swagger-completo-screenshot]: images/swagger-completo.png
[swagger-passageiro-screenshot]: images/swagger-passageiro.png
[swagger-cartao-screenshot]: images/swagger-cartao.png
[swagger-viagem-screenshot]: images/swagger-viagem.png
