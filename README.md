# ✨ Foro Hub - API REST con Spring Boot y JWT

Foro Hub es una API REST desarrollada con Spring Boot que permite la creación, edición y eliminación de tópicos en un foro de discusión. La aplicación implementa autenticación segura con Spring Security y JWT y almacena los datos en una base de datos MySQL.

---

## 🚀 Tecnologías Utilizadas
- Java 17
- Spring Boot 3
- Spring Security (Autenticación y Autorización)
- JWT (JSON Web Token)
- Spring Data JPA
- MySQL
- Maven

---

## 🛠️ Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalados:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL Server](https://dev.mysql.com/downloads/installer/)
- [Insomnia](https://insomnia.rest/) o Postman para probar la API

---

## ⚙️ Configuración del Proyecto
### 1️⃣ Clonar el Repositorio
```sh
 git clone https://github.com/tu-usuario/foro-hub.git
```

### 2️⃣ Configurar la Base de Datos
Crea una base de datos en MySQL llamada `foro_hub`:
```sql
CREATE DATABASE foro_hub;
```

Asegúrate de configurar las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Compilar y Ejecutar el Proyecto
```sh
mvn clean install
mvn spring-boot:run
```

---

## 📌 Endpoints de la API

### 🔹 Autenticación
| Método | Endpoint         | Descripción |
|---------|-----------------|--------------|
| `POST`  | `/auth/register` | Registra un nuevo usuario |
| `POST`  | `/auth/login`    | Autentica un usuario y devuelve un token JWT |

### 🔹 Tópicos (Requiere autenticación con JWT)
| Método | Endpoint       | Descripción |
|---------|---------------|--------------|
| `GET`   | `/topicos`    | Lista todos los tópicos |
| `GET`   | `/topicos/{id}` | Obtiene un tópico por ID |
| `POST`  | `/topicos`    | Crea un nuevo tópico |
| `PUT`   | `/topicos/{id}` | Actualiza un tópico |
| `DELETE` | `/topicos/{id}` | Elimina un tópico |

---

## 🔐 Autenticación con JWT

Para acceder a los endpoints protegidos, primero debes obtener un token JWT mediante el endpoint `/auth/login`.

### 1️⃣ Obtener Token (POST /auth/login)
Solicitud:
```json
{
  "username": "admin",
  "password": "1234"
}
```

Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```

### 2️⃣ Usar Token en Endpoints Protegidos
Una vez obtenido el token, agrégalo en los headers de las solicitudes:
```yaml
Authorization: Bearer <TOKEN>
```

Ejemplo de `GET /topicos` con el token en Insomnia:
```http
GET /topicos
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR...
```

---

## 🛠️ Pruebas en Insomnia
Puedes importar la siguiente colección en Insomnia para probar los endpoints:
📌 (Opcional: Agregar enlace a un JSON de Insomnia con las pruebas preconfiguradas)

---

## 💡 Contribuciones
Si deseas contribuir a este proyecto, sigue estos pasos:
1. **Haz un fork** del repositorio.
2. **Crea una rama nueva** (`git checkout -b feature-nueva`).
3. **Realiza tus cambios y haz commit** (`git commit -m "Agrego nueva funcionalidad"`).
4. **Haz push a la rama** (`git push origin feature-nueva`).
5. **Abre un Pull Request** y explícanos tus cambios.

---



🚀 **Gracias por usar Foro Hub!** 🎉

