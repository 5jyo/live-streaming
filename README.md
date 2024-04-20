# live-streaming

## How to run in local

- build springboot projects
```dtd
./gradlew bootJar
```

- run with docker-compoase
```dtd
docker-compose up -d
```

- localhost:8080 (meta api)
- localhost:8081 (signaling api & web app)
  - localhost:8081/streamer : create broadcast live streaming
  - localhost:8081/client : broadcast list
