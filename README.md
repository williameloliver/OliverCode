# CodePad AI v0.2

Editor de código nativo y liviano para Android 4.2 (API 17) o superior.

## Funciones

- Abre, crea, edita y guarda archivos de texto/código en cualquier extensión.
- Resaltado extensible para Java, Python, C/C++, JavaScript, JSON, XML/HTML y otros.
- Proyectos ZIP: extracción segura, árbol navegable y reexportación.
- Pestañas bajo demanda para ahorrar RAM; mantener pulsada una pestaña para cerrarla.
- Panel lateral plegable con explorador y símbolos del archivo.
- Números de línea visibles, desplazamiento táctil horizontal/vertical y zoom de texto con dos dedos.
- Selector visual del sistema para abrir archivos y proyectos ZIP, sin escribir rutas manualmente.
- Búsqueda, undo/redo y editor monoespaciado con resaltado de sintaxis.
- Preguntas de IA sobre una selección o el archivo completo, con contraseña/token configurable.
- TLS 1.2 activado para conectar Android 4.2 con backends HTTPS modernos como Render.

## Compilar automáticamente con GitHub Actions

1. Descomprime el ZIP directamente en la raíz de un repositorio.
2. Sube los archivos a GitHub.
3. Abre **Actions → Compilar APK Android 4.2**.
4. Descarga el artifact **CodePadAI-Android-4.2**.

El workflow usa Java 17, Gradle 7.6 y el Android SDK incluido en GitHub Actions. No requiere `gradlew` ni configurar Codespaces.

## Compilar localmente

1. Abrir esta carpeta en Android Studio.
2. Usar JDK 11 o 17 y dejar que Gradle descargue Android Gradle Plugin 7.4.2.
3. Instalar Android SDK 33 si se solicita.
4. Ejecutar `assembleDebug` o pulsar **Build APK**.

El APK generado queda en `app/build/outputs/apk/debug/app-debug.apk`.

## Contrato del backend IA

La aplicación hace `POST` a la URL guardada en Ajustes con `Content-Type: application/json`. También puede enviar la contraseña o token usando el encabezado configurado, por ejemplo `X-API-Key` o `Authorization`:

```json
{
  "question": "Explícame este método",
  "language": "java",
  "filename": "MainActivity.java",
  "code": "..."
}
```

Reconoce una respuesta JSON con `answer`, `response` o `message`. La clave de OpenRouter permanece en Render.

## Nota Android 4.2

En Ajustes → Seguridad debe permitirse instalar APK de fuentes desconocidas. Para exportar un ZIP todavía se puede indicar una ruta de destino. El proyecto usa APIs clásicas, sin AndroidX ni Compose.
