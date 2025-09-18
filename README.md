# 💊 PharmaCare+ - Sistema de Carrito de Compras para Farmacia

<div align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen?style=for-the-badge&logo=spring" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Docker-Supported-blue?style=for-the-badge&logo=docker" alt="Docker">
  <img src="https://img.shields.io/badge/Thymeleaf-Frontend-green?style=for-the-badge&logo=thymeleaf" alt="Thymeleaf">
</div>

## 📋 Descripción

**PharmaCare+** es una aplicación web moderna de carrito de compras especializada para farmacias. Desarrollada con **Java 21** y **Spring Boot**, implementa el patrón arquitectónico **MVC** y ofrece una experiencia completa de compra en línea con autenticación segura, gestión de productos farmacéuticos y proceso de pago simulado.

### 🎯 ¿Qué hace esta aplicación?

- **🏪 Catálogo de productos farmacéuticos** - Navega por medicamentos, vitaminas, productos de cuidado personal
- **🛒 Carrito de compras inteligente** - Agrega, modifica y gestiona productos antes de comprar
- **🔐 Sistema de autenticación seguro** - Login con JWT y roles de usuario
- **💳 Proceso de checkout completo** - Simulación realista de proceso de pago
- **📱 Diseño responsive** - Funciona perfectamente en móviles y escritorio

## ✨ Características Principales

### 🔐 **Autenticación y Autorización**
- Sistema de login basado en **JWT** (JSON Web Tokens)
- Roles de usuario: **ADMIN**, **USER**, **MODERATOR**
- Sesiones seguras con cookies HTTP-only
- Protección de rutas según permisos

### 🏪 **Gestión de Productos**
- Catálogo completo de productos farmacéuticos
- Organización por categorías (Analgésicos, Vitaminas, Antibióticos, etc.)
- Control de inventario y stock en tiempo real
- Precios dinámicos y ofertas

### 🛒 **Carrito de Compras Avanzado**
- Agregar/eliminar productos con validación de stock
- Actualización de cantidades en tiempo real
- Cálculo automático de totales y subtotales
- Persistencia del carrito durante la sesión

### 💳 **Proceso de Pago Completo**
- Formulario de checkout con validaciones
- Información de entrega pre-llenada
- Simulación de pago con tarjeta de crédito
- Confirmación de compra con detalles

### 🌐 **API REST**
- Endpoints RESTful para integración externa
- Documentación de API incluida
- Respuestas JSON estructuradas

## 🛠️ Tecnologías Utilizadas

### **Backend**
- ☕ **Java 21** - Lenguaje de programación principal
- 🍃 **Spring Boot 3.5.5** - Framework principal
- 🔧 **Spring Web** - Controladores y APIs REST
- 🔒 **Spring Security 6** - Autenticación y autorización
- 💾 **Spring Data JPA** - Persistencia de datos
- 🔑 **JWT** - JSON Web Tokens para autenticación

### **Frontend (Server-Side)**
- 🌿 **Thymeleaf** - Motor de plantillas
- 🎨 **Bootstrap 5** - Framework CSS responsive
- ⚡ **JavaScript** - Interactividad del frontend
- 🎭 **Font Awesome** - Iconografía moderna

### **Base de Datos**
- 🐘 **PostgreSQL 15** - Base de datos principal
- 🗃️ **JPA/Hibernate** - ORM (Object-Relational Mapping)
- 📊 **Flyway** - Migraciones de base de datos

### **Herramientas de Desarrollo**
- 📦 **Maven 3.9+** - Gestión de dependencias
- 🐳 **Docker & Docker Compose** - Contenerización
- 🔧 **Lombok** - Reducción de código boilerplate

## 📋 Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

### **Instalación Requerida:**

1. **☕ Java Development Kit (JDK) 21**
   ```bash
   # Verificar instalación
   java -version
   javac -version
   ```
   - **Windows**: Descargar desde [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) o [OpenJDK](https://openjdk.org/projects/jdk/21/)
   - **macOS**: `brew install openjdk@21`
   - **Linux**: `sudo apt install openjdk-21-jdk` (Ubuntu/Debian)

2. **📦 Apache Maven 3.9+**
   ```bash
   # Verificar instalación
   mvn -version
   ```
   - **Windows**: Descargar desde [Maven Official](https://maven.apache.org/download.cgi)
   - **macOS**: `brew install maven`
   - **Linux**: `sudo apt install maven`

3. **🐘 PostgreSQL 15+**
   ```bash
   # Verificar instalación
   psql --version
   ```
   - **Windows**: Descargar desde [PostgreSQL Official](https://www.postgresql.org/download/windows/)
   - **macOS**: `brew install postgresql@15`
   - **Linux**: `sudo apt install postgresql-15`

### **Opcional (Recomendado):**

4. **🐳 Docker & Docker Compose**
   ```bash
   # Verificar instalación
   docker --version
   docker-compose --version
   ```
   - Descargar desde [Docker Official](https://www.docker.com/products/docker-desktop/)

5. **💻 IDE Recomendado**
   - **IntelliJ IDEA Community** (Gratuito)
   - **Eclipse IDE for Java Developers**
   - **Visual Studio Code** con extensión Java

## 🚀 Guía de Instalación Completa

### **Método 1: Instalación Manual (Paso a Paso)**

#### **Paso 1: Obtener el Código Fuente**

```bash
# Opción A: Clonar repositorio (si tienes Git)
git clone <url-del-repositorio>
cd carritoApp

# Opción B: Descargar ZIP y extraer
# Navegar a la carpeta extraída
cd carritoApp
```

#### **Paso 2: Configurar la Base de Datos**

1. **Iniciar PostgreSQL:**
   ```bash
   # Windows (como servicio)
   net start postgresql-x64-15
   
   # macOS/Linux
   sudo systemctl start postgresql
   ```

2. **Conectar a PostgreSQL:**
   ```bash
   # Conectar como superusuario
   psql -U postgres
   ```

3. **Crear la Base de Datos y Usuario:**
   ```sql
   -- Crear la base de datos
   CREATE DATABASE bd_carrito_compras;
   
   -- Crear usuario específico
   CREATE USER carrito_compra WITH PASSWORD 'CarritoCompra*';
   
   -- Otorgar permisos
   GRANT ALL PRIVILEGES ON DATABASE bd_carrito_compras TO carrito_compra;
   
   -- Salir
   \q
   ```

4. **Ejecutar Scripts de Base de Datos:**
   ```bash
   # Navegar a la carpeta del proyecto
   cd src/main/resources
   
   # Ejecutar script principal
   psql -U carrito_compra -d bd_carrito_compras -f carrito.sql
   
   ```

#### **Paso 3: Configurar la Aplicación**

1. **Verificar configuración de BD en `application.yml`:**
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5433/bd_carrito_compras
       username: carrito_compra
       password: CarritoCompra*
       driver-class-name: org.postgresql.Driver
   ```

2. **Ajustar puerto si es necesario:**
   - Si PostgreSQL usa puerto **5432** (por defecto), cambiar `5433` por `5432`
   - Si tienes otro puerto, actualizar la URL correspondiente

#### **Paso 4: Compilar y Ejecutar**

1. **Compilar el proyecto:**
   ```bash
   # Windows
   ./mvnw clean compile
   
   # Linux/macOS
   ./mvnw clean compile
   ```

2. **Ejecutar la aplicación:**
   ```bash
   # Windows
   ./mvnw spring-boot:run
   
   # Linux/macOS
   ./mvnw spring-boot:run
   ```

3. **Verificar que está funcionando:**
   - Abrir navegador en: **http://localhost:8085**
   - Deberías ver la página principal de PharmaCare+

### **Método 2: Instalación con Docker (Recomendado para Principiantes)**

#### **Paso 1: Verificar Docker**
```bash
# Verificar que Docker está ejecutándose
docker --version
docker-compose --version
```

#### **Paso 2: Ejecutar con Docker Compose**
```bash
# En la carpeta raíz del proyecto
docker-compose up -d

# Verificar que los contenedores están ejecutándose
docker-compose ps
```

#### **Paso 3: Acceder a la Aplicación**
- **Aplicación**: http://localhost:8085
- **Base de Datos**: localhost:5433 (si necesitas conectarte directamente)

## 🎮 Cómo Usar la Aplicación

### **1. Acceso Inicial**
- Navegar a: **http://localhost:8085**
- Verás la página principal con productos de farmacia

### **2. Usuarios de Prueba Disponibles**

| Usuario | Contraseña    | Rol | Descripción |
|---------|---------------|-----|-------------|
| `admin` | `admin2025`   | ADMIN | Administrador completo |
| `johndoe` | `admin2025` | USER | Usuario estándar |
| `janedoe` | `admin2025` | USER + MODERATOR | Usuario con permisos extra |
| `testuser` | `admin2025` | USER | Usuario de prueba |

### **3. Flujo de Compra Completo**

#### **Paso 1: Explorar Productos**
- En la página principal, navega por las categorías
- Ve detalles de productos, precios y stock disponible

#### **Paso 2: Iniciar Sesión**
- Clic en "Mi Cuenta" en la navegación
- Usar cualquiera de los usuarios de prueba
- Serás redirigido a la página principal

#### **Paso 3: Agregar al Carrito**
- Seleccionar cantidad deseada
- Clic en "Agregar al carrito"
- Ver confirmación de producto agregado

#### **Paso 4: Gestionar Carrito**
- Clic en "Carrito" en la navegación
- Modificar cantidades o eliminar productos
- Ver total calculado automáticamente

#### **Paso 5: Proceso de Checkout**
- Clic en "Proceder al Pago"
- Completar información de pago (simulado)
- Confirmar compra

#### **Paso 6: Confirmación**
- Ver página de éxito con detalles de la compra
- Opción de realizar nueva compra

### **4. Navegación de la Aplicación**

| URL | Descripción | Requiere Login |
|-----|-------------|----------------|
| `/` | Página principal con productos | No |
| `/login` | Formulario de inicio de sesión | No |
| `/cart` | Ver carrito de compras | Sí |
| `/checkout` | Proceso de pago | Sí |
| `/success` | Confirmación de compra | Sí |
| `/dashboard` | Panel de usuario | Sí |
| `/admin` | Panel administrativo | Sí (Admin) |

## 🔧 Configuración Avanzada

### **Variables de Entorno**

Puedes configurar las siguientes variables de entorno:

```bash
# Base de datos
DB_HOST=localhost
DB_PORT=5433
DB_NAME=bd_carrito_compras
DB_USER=carrito_compra
DB_PASSWORD=CarritoCompra*

# Aplicación
SERVER_PORT=8085
JWT_SECRET=miSecretSuperSecreto2024

# Logging
LOGGING_LEVEL=INFO
```

### **Perfiles de Spring**

```bash
# Ejecutar en modo desarrollo
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# Ejecutar en modo producción
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

### **Configuración de Puerto**

Si el puerto 8085 está ocupado:

1. **Cambiar en `application.yml`:**
   ```yaml
   server:
     port: 8080  # o cualquier puerto disponible
   ```

2. **O usar variable de entorno:**
   ```bash
   export SERVER_PORT=8080
   ./mvnw spring-boot:run
   ```

## 🐛 Solución de Problemas Comunes

### **❌ Error: "Could not connect to database"**

**Problema**: La aplicación no puede conectarse a PostgreSQL.

**Soluciones**:
1. Verificar que PostgreSQL esté ejecutándose:
   ```bash
   # Windows
   net start postgresql-x64-15
   
   # Linux/macOS
   sudo systemctl status postgresql
   ```

2. Verificar puerto en `application.yml`:
   - PostgreSQL por defecto usa puerto **5432**
   - Tu configuración usa **5433**
   - Cambiar según tu instalación

3. Verificar credenciales:
   ```bash
   # Probar conexión manual
   psql -U carrito_compra -d bd_carrito_compras -h localhost -p 5433
   ```

### **❌ Error: "Port 8085 already in use"**

**Problema**: El puerto está ocupado por otra aplicación.

**Soluciones**:
1. Cambiar puerto en `application.yml`
2. Terminar proceso que usa el puerto:
   ```bash
   # Windows
   netstat -ano | findstr :8085
   taskkill /PID <numero_pid> /F
   
   # Linux/macOS
   lsof -i :8085
   kill -9 <pid>
   ```

### **❌ Error: "Java_Home not found"**

**Problema**: Java no está configurado correctamente.

**Soluciones**:
1. Configurar JAVA_HOME:
   ```bash
   # Windows
   set JAVA_HOME=C:\Program Files\Java\jdk-21
   
   # Linux/macOS
   export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
   ```

2. Verificar PATH:
   ```bash
   echo $JAVA_HOME
   java -version
   ```

### **❌ Error: "Access denied for user"**

**Problema**: Permisos insuficientes en PostgreSQL.

**Soluciones**:
1. Otorgar permisos completos:
   ```sql
   GRANT ALL PRIVILEGES ON DATABASE bd_carrito_compras TO carrito_compra;
   GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO carrito_compra;
   GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO carrito_compra;
   ```

### **❌ Error: "Table doesn't exist"**

**Problema**: Las tablas no se crearon correctamente.

**Soluciones**:
1. Ejecutar scripts manualmente:
   ```bash
   psql -U carrito_compra -d bd_carrito_compras -f src/main/resources/carrito.sql
   ```

2. Verificar que las tablas se crearon:
   ```sql
   \dt  -- Listar todas las tablas
   ```

## 📊 Estructura del Proyecto

```
carritoApp/
├── 📁 src/main/java/
│   └── org/softprimesolutions/carritoapp/
│       ├── 🎮 controller/          # Controladores MVC
│       ├── 📦 service/             # Lógica de negocio
│       ├── 🗄️ repository/          # Acceso a datos
│       ├── 🏗️ model/               # Entidades JPA
│       ├── 🔒 security/            # Configuración de seguridad
│       ├── 📊 dto/                 # Data Transfer Objects
│       └── ⚙️ config/              # Configuraciones
├── 📁 src/main/resources/
│   ├── 🌐 templates/               # Plantillas Thymeleaf
│   ├── 🎨 static/                  # CSS, JS, imágenes
│   ├── 🗃️ carrito.sql              # Script de base de datos
│   ├── 📄 data.sql                 # Datos de prueba
│   └── ⚙️ application.yml          # Configuración principal
├── 🐳 docker-compose.yml           # Configuración Docker
├── 📦 pom.xml                      # Dependencias Maven
└── 📖 README.md                    # Esta documentación
```

## 🤝 Contribuir al Proyecto

### **Pasos para Contribuir:**

1. **Fork del repositorio**
2. **Crear rama de feature**: `git checkout -b feature/nueva-funcionalidad`
3. **Commit cambios**: `git commit -m 'Agregar nueva funcionalidad'`
4. **Push a la rama**: `git push origin feature/nueva-funcionalidad`
5. **Crear Pull Request**

### **Estándares de Código:**
- Seguir convenciones de Java
- Usar Lombok para reducir boilerplate
- Comentar métodos complejos
- Escribir tests unitarios

## 📞 Soporte y Contacto

### **¿Necesitas Ayuda?**

- 📧 **Email**: support@pharmacare-plus.com
- 💬 **Discord**: [Servidor de la Comunidad]
- 📱 **Teléfono**: +51 (01) 123-4567
- 🌐 **Website**: https://pharmacare-plus.com

### **Reportar Problemas**
- Usar el sistema de **Issues** de GitHub
- Incluir logs de error completos
- Especificar versión de Java y OS

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**. Ver archivo `LICENSE` para más detalles.

---

<div align="center">
  <p><strong>💊 PharmaCare+ - Tu Farmacia de Confianza en Línea</strong></p>
  <p>Desarrollado con ❤️ usando Spring Boot y tecnologías modernas</p>
  <p>© 2024 SoftPrime Solutions. Todos los derechos reservados.</p>
</div>
