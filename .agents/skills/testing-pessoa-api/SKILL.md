# Testing pessoa-api

## Overview
Spring Boot 4.x REST API for managing "Pessoa" (person) records. Uses clean architecture with domain/use-case/infrastructure layers.

## Prerequisites
- Java 21 (install via `sudo apt-get install -y openjdk-21-jdk`)
- Maven (install via `sudo apt-get install -y maven`)
- Set `JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64`

## Running Locally
The app uses an H2 in-memory database with the `dev` profile by default — no external DB setup needed.

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
mvn spring-boot:run
```

Server starts on `http://localhost:8080`.

## API Endpoints
- `GET /api` — List all persons
- `POST /api/create` — Create a person (JSON body: `{"nome", "email", "telefone", "cpf"}`)
- `GET /api/app` — Health check (returns "ok")

## Testing via curl

### Health check
```bash
curl -s http://localhost:8080/api/app
# Expected: "ok"
```

### Create a person
```bash
curl -s -w "\nHTTP_STATUS: %{http_code}\n" -X POST http://localhost:8080/api/create \
  -H "Content-Type: application/json" \
  -d '{"nome":"Test User","email":"test@email.com","telefone":"11999999999","cpf":"12345678901"}'
# Expected: 201 Created with JSON body
```

### Duplicate CPF (should return 409 Conflict)
```bash
# POST again with same CPF
curl -s -w "\nHTTP_STATUS: %{http_code}\n" -X POST http://localhost:8080/api/create \
  -H "Content-Type: application/json" \
  -d '{"nome":"Another User","email":"other@email.com","telefone":"11888888888","cpf":"12345678901"}'
# Expected: 409 Conflict with structured JSON error
```

### List all persons
```bash
curl -s http://localhost:8080/api
# Expected: JSON array of persons
```

## Build & Test
```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
mvn compile   # Build
mvn test      # Run tests
```

## Notes
- This is a shell-only testing scenario (REST API, no web UI). Use curl for all endpoint testing — no browser recording needed.
- The H2 database is in-memory, so data resets on every server restart.
- Port 8080 might be occupied if multiple Maven processes start simultaneously. Kill stale processes with `kill $(ss -tlnp | grep 8080 | awk '{print $NF}' | grep -oP '\d+')` before restarting.
- No CI is configured for this repo as of now.

## Devin Secrets Needed
None — the app uses an embedded H2 database with hardcoded dev credentials.
