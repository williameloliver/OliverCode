# CodePad AI v0.1

Editor de código nativo y liviano para Android 4.2 (API 17) o superior.

## Funciones

- Abre, crea, edita y guarda archivos de texto/código en cualquier extensión.
- Resaltado extensible para Java, Python, C/C++, JavaScript, JSON, XML/HTML y otros.
- Proyectos ZIP: extracción segura, árbol navegable y reexportación.
- Pestañas bajo demanda para ahorrar RAM; mantener pulsada una pestaña para cerrarla.
- Panel lateral plegable con explorador y símbolos del archivo.
- Búsqueda, undo/redo, números de línea en la barra de estado y editor monoespaciado.
- Preguntas de IA sobre una selección o el archivo completo mediante un backend configurable.

## Compilar automáticamente con GitHub Actions

1. Descomprime el ZIP directamente en la raíz de un repositorio.
2. Sube los archivos a GitHub.
3. Abre **Actions → Compilar APK Android 4.2**.
4. Descarga el artifact **CodePadAI-Android-4.2**.

El workflow instala Java 17, Gradle 7.6 y Android SDK 33 automáticamente. No requiere `gradlew` ni configurar Codespaces.

## Compilar localmente

1. Abrir esta carpeta en Android Studio.
2. Usar JDK 11 o 17 y dejar que Gradle descargue Android Gradle Plugin 7.4.2.
3. Instalar Android SDK 33 si se solicita.
4. Ejecutar `assembleDebug` o pulsar **Build APK**.

El APK generado queda en `app/build/outputs/apk/debug/app-debug.apk`.

## Contrato del backend IA

La aplicación hace `POST` a la URL guardada en Ajustes con `Content-Type: application/json`:

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

En Ajustes → Seguridad debe permitirse instalar APK de fuentes desconocidas. La ruta `/sdcard/` es editable al abrir y exportar. El proyecto usa APIs clásicas, sin AndroidX ni Compose.
