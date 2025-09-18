# Proyecto Carrito de Compras

Este es un proyecto de Carrito de Compras desarrollado en Java con Spring Boot.

## Características

*   **Autenticación y Autorización:** Sistema de login basado en JWT (JSON Web Tokens) con roles de usuario.
*   **Gestión de Productos:** Mantenimiento de productos y categorías.
*   **Carrito de Compras:** Funcionalidad para agregar, visualizar y gestionar productos en el carrito de un usuario.
*   **Proceso de Pago:** Simulación de un proceso de checkout.
*   **API REST:** Endpoints para interactuar con los recursos de la aplicación.

## Tecnologías Utilizadas

*   **Backend:**
    *   Java
    *   Spring Boot
    *   Spring Web
    *   Spring Security
    *   Spring Data JPA
*   **Base de Datos:**
    *   SQL (Compatible PostgreSQL)
*   **Build Tool:**
    *   Maven
*   **Contenerización:**
    *   Docker

## Guía de Instalación

### Prerrequisitos

*   JDK (Java Development Kit) 21.
*   Maven 3.6 o superior.
*   Un gestor de base de datos (PostgreSQL).
*   Docker (Opcional, para ejecutar con Docker Compose).

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone <url-del-repositorio>
    cd carrito-compra
    ```

2.  **Crear la Base de Datos:**
    *   Crea una base de datos en tu gestor de base de datos preferido.
    *   Ejecuta el script `src/main/resources/carrito.sql` para crear las tablas necesarias y cargar los datos iniciales. Este script creará las tablas de categorías, productos, usuarios, roles y otras tablas requeridas para el funcionamiento de la aplicación.

3.  **Configurar la conexión a la Base de Datos:**
    *   Abre el archivo `src/main/resources/application.yml`.
    *   Modifica las siguientes propiedades para apuntar a tu base de datos:
        ```yaml
        spring:
          datasource:
            url: jdbc:postgresql://localhost:5433/bd_carrito_compras
            username: carrito_compra
            password: CarritoCompra*
        ```

4.  **Compilar y Ejecutar el proyecto:**
    *   Puedes ejecutar la aplicación usando el wrapper de Maven incluido:
        ```bash
        # En Windows
        ./mvnw spring-boot:run

        # En Linux/macOS
        ./mvnw spring-boot:run
        ```
    *   La aplicación estará disponible en `http://localhost:8085`.

### Instalación con Docker (Alternativa)

1.  Asegúrate de tener Docker y Docker Compose instalados.
2.  Configura las variables de entorno necesarias en el archivo `compose.yaml` si es necesario.
3.  Ejecuta el siguiente comando en la raíz del proyecto:
    ```bash
    docker-compose up -d
    ```
