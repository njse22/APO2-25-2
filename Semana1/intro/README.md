# Resumen del Proyecto de Introducción

Este proyecto es una aplicación simple de Java construida con Maven, diseñada como una introducción para un curso de algoritmos y programación.

## Componentes del Proyecto

A continuación se describe la estructura y los componentes clave del proyecto:

- **`pom.xml`**: El corazón del proyecto Maven. Define las dependencias (como `com.google.genai:java-genai`), la estructura del proyecto y cómo compilar y empaquetar el código.

- **`.gitignore`**: Un archivo estándar que le indica a Git qué archivos y directorios debe ignorar. Esto es útil para evitar que archivos generados por el IDE (como los de la carpeta `.idea/`) o los artefactos de compilación (la carpeta `target/`) se suban al repositorio.

- **`.idea/`**: Un directorio que contiene los archivos de configuración específicos del IDE IntelliJ IDEA.

- **`src/main/java/`**: Contiene el código fuente principal de la aplicación.
  
  - **`ui/Main.java`**: La clase principal que contiene el punto de entrada de la aplicación.

- **`src/main/resources/`**: Almacena recursos que no son código, como archivos de configuración.
  
  - **`config.properties`**: (Hubicado en `src/main/resources/config.properties`) Un archivo de propiedades para almacenar claves de API y otras configuraciones.
  - **`archetype-resources/` y `META-INF/`**: Estos directorios contienen metadatos que sugieren que el proyecto fue creado a partir de un arquetipo de Maven, que es una plantilla de proyecto.

- **`target/`**: El directorio de salida para todo el proceso de compilación de Maven. Aquí es donde se guardan las clases compiladas (`.class`) y el archivo JAR ejecutable.

---

## Explicación de `src/main/java/ui/Main.java`

La clase `Main` es el punto de inicio de la aplicación. Su función principal es demostrar cómo interactuar con la API de Google Gemini.

El flujo de ejecución es el siguiente:

1. **Carga de Configuración**: Intenta cargar un archivo `config.properties` desde los recursos del proyecto. Espera encontrar una propiedad llamada `GEMINI_API_KEY` dentro de este archivo para poder autenticarse con el servicio de Google.

2. **Inicialización del Cliente**: Utiliza la clave de API obtenida para construir una instancia del cliente de Google GenAI (`com.google.genai.Client`).

3. **Llamada a la API**: Envía una solicitud al modelo de lenguaje `gemini-2.0-flash-001`. La pregunta que le hace al modelo es: `"Dame una descripción del proyecto googleapis/java-genai"`.

4. **Impresión de la Respuesta**: Recibe la respuesta del modelo y la imprime directamente en la consola.

En resumen, esta clase es un ejemplo práctico de cómo usar la biblioteca `java-genai` para hacer una consulta simple a un modelo de lenguaje de Google.



> README generado por el modelo `gemini-2.5-pro`, revisado y modificado por @njse22
