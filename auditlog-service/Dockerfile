# Usar a imagem oficial do OpenJDK 17 (ou a versão que você estiver usando)
FROM openjdk:17-jdk-alpine

# Copiar o jar gerado para dentro da imagem
COPY target/*.jar app.jar

# Rodar o jar quando iniciar o container
ENTRYPOINT ["java", "-jar", "/app.jar"]
