# Spring Boot REST API for Product Management

## Overview
This is a RESTful API developed using Spring Boot, designed to manage a catalog of products. It includes features such as user registration, authentication, and CRUD operations for products. The API uses MongoDB to store product information and secures endpoints using JWT tokens.

## Features
- **User Registration and Authentication**: Allows users to register and log in to access the API.
- **JWT Token Authentication**: Secures API endpoints and validates user sessions.
- **CRUD Operations for Products**: Authenticated users can create, read, update, and delete products.
- **Input Validation**: Ensures data integrity through validation.
- **Error Handling**: Provides meaningful error messages for better debugging and user experience.

## Technologies
- **Spring Boot**
- **Spring Security**
- **JWT**
- **MongoDB**
- **Maven**

## Prerequisites
- **Java**: Ensure you have JDK 8 or later installed.
- **MongoDB**: Make sure MongoDB is installed and running.
- **Maven**: Ensure Maven is installed for dependency management.

## Getting Started

### Clone the Repository
```sh
git clone https://github.com/nickemma/springboot-rest-api.git
cd springboot-rest-api
