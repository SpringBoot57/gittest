# AI Document Summarizer

This project provides a Spring Boot 3 application that allows users to upload documents and obtain AI-generated summaries using OpenAI.

## Features
- JWT based authentication with registration and login APIs
- Upload PDF/DOCX documents
- Asynchronous summarization using OpenAI API
- Stores summaries per user and document
- Audits all API calls
- Caching of summaries
- OpenAPI documentation available at `/swagger-ui.html`

## Building
```
mvn package
```

## Running Tests
```
mvn test
```
