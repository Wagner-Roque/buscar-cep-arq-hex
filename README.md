# buscar-cep-arq-hex
Api buscar cep usando arquitetura hexagonal
src/
└── main/
    ├── java/
    │   └── com/
    │       └── suaempresa/
    │           └── buscocep/
    │               ├── application/
    │               │   ├── ports/
    │               │   │   ├── input/
    │               │   │   │   └── BuscarCepUseCase.java
    │               │   │   └── output/
    │               │   │       ├── LogRepository.java
    │               │   │       └── CepClient.java
    │               │   └── service/
    │               │       └── BuscarCepService.java
    │               ├── domain/
    │               │   ├── CepResponse.java
    │               │   └── LogEntity.java
    │               ├── infrastructure/
    │               │   ├── adapters/
    │               │   │   ├── input/
    │               │   │   │   ├── rest/
    │               │   │   │   │   └── BuscarCepController.java
    │               │   │   └── output/
    │               │   │       ├── database/
    │               │   │       │   ├── LogJpaRepository.java
    │               │   │       │   └── LogRepositoryAdapter.java
    │               │   │       └── external/
    │               │   │           ├── CepClientAdapter.java
    │               │   │           └── WebClientConfig.java
    │               │   ├── config/
    │               │   │   ├── ApplicationConfig.java
    │               │   │   ├── SwaggerConfig.java
    │               │   │   └── DatabaseConfig.java
    │               │   └── util/
    │               │       └── LogMapper.java
    │               └── BuscoCepApplication.java
    └── resources/
        ├── application.properties
        ├── schema.sql
        └── data.sql


        Explicação das Pastas
1. Core/Núcleo
domain/ Contém as entidades principais e objetos de domínio:

CepResponse: Representa os dados retornados ao buscar um CEP.
LogEntity: Representa os registros salvos no banco de dados.
application/ Contém os casos de uso (serviços) e as portas da aplicação:

ports/input/: Define as interfaces para as ações que o núcleo da aplicação expõe, como BuscarCepUseCase.
ports/output/: Define as interfaces para dependências externas, como CepClient e LogRepository.
service/: Implementação dos casos de uso, como BuscarCepService.
2. Infraestrutura
infrastructure/adapters/ Contém os adaptadores (implementações) para as portas de entrada e saída:

input/rest/: Controladores REST, como BuscarCepController.
output/database/: Implementações para persistência, como LogJpaRepository e LogRepositoryAdapter.
output/external/: Implementações para integração externa, como CepClientAdapter.
infrastructure/config/ Configurações específicas da aplicação, como:

SwaggerConfig: Configuração do Swagger.
DatabaseConfig: Configuração do banco de dados.
WebClientConfig: Configuração do WebClient.
infrastructure/util/ Classes auxiliares, como:

LogMapper: Mapeamento entre objetos de domínio e entidades persistidas.
3. Bootstrap
BuscoCepApplication.java Classe principal que inicializa a aplicação Spring Boot.
4. Recursos
application.properties Contém as configurações, como conexões com banco e URLs externas.

schema.sql e data.sql Scripts SQL para inicialização do banco de dados (opcional).


