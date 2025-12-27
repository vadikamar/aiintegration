# AI Integration

AI integration with Spring Boot using Perplexity-style APIs and a simple RAG (Retrieval-Augmented Generation) flow.

## Screenshots

![Screenshot 1](https://github.com/user-attachments/assets/9866b9c9-b41e-40d9-9546-275e35d53113)
![Screenshot 2](https://github.com/user-attachments/assets/347da1b8-cbd1-47bf-9027-9378dbccc5be)
![Screenshot 3](https://github.com/user-attachments/assets/52c49267-1355-43aa-9a04-435e5a95adcc)

## Overview

This project demonstrates:
- Generating embeddings from text (example model: `text-embedding-3-small`).
- Storing embeddings as "memories" and performing vector similarity search (cosine similarity).
- Retrieval-Augmented Generation: retrieving top-k context and asking a conversational model (example: `gpt-3.5-turbo`).
- Spring Boot backend using `WebClient` for AI API calls and `Jackson` (`ObjectMapper`) for JSON parsing.

## Features

- Persist short text "memories" with embeddings.
- Vector similarity search and RAG-based querying.
- Defensive handling for JSON parsing, empty/zero vectors, and immutable list sorting.
- Examples and troubleshooting notes included.

## Tech Stack

- Java (11+)
- Spring Boot (Web, Data JPA)
- Maven
- Jackson (`com.fasterxml.jackson.databind`)
- `WebClient` for HTTP calls

## Prerequisites

- JDK 11 or newer
- Maven 3.6+
- Database configured for Spring Data JPA (H2, PostgreSQL, etc.)
- AI API key and API URL (environment variables or application properties)

Example environment variables (PowerShell):
```powershell
$env:AI_API_KEY="your_api_key_here"
$env:AI_API_URL="https://api.example.com/v1"
