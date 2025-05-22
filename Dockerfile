# Usa imagem leve e otimizada do Java 17
FROM eclipse-temurin:17-jre-alpine
 
# Cria um usuário sem privilégios administrativos
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
 
# Cria diretório da aplicação e dá permissão ao usuário
WORKDIR /app
RUN chown appuser:appgroup /app
 
# Modifique seu Dockerfile para apontar para o caminho exato
COPY --chown=appuser:appgroup MottuSenseApi/target/MottuSenseApi-0.0.1-SNAPSHOT.jar app.jar
 
# Muda para o usuário sem privilégios
USER appuser
 
# Expondo a porta do Spring Boot
EXPOSE 8080
 
# Executa o .jar com otimizações para containers
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]