# SafeCloud-Manager

Este projeto implementa uma arquitetura baseada em microserviços com foco na separação de responsabilidades e escalabilidade. Os serviços são independentes, comunicam-se de forma assíncrona e compartilham bibliotecas comuns para reutilização de código.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- MongoDB
- Apache Kafka ou RabbitMQ (mensageria)
- Maven
- Docker / Docker Compose


## Padrões adotados

- Cada microserviço possui seu próprio banco de dados (PostgreSQL ou MongoDB).
- Comunicação assíncrona entre serviços via mensageria.
- As dependências entre serviços são evitadas ao máximo; apenas bibliotecas compartilhadas são reutilizadas via Maven.
- As entidades não mantêm relacionamentos JPA com entidades de outros serviços.