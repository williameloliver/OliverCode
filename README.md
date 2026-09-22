# OliverCode Lite Beta 0.4.0

Editor de código liviano, táctil y asistido por IA para Android 4.2 (API 17) o superior.

## Funciones principales

- Abre, crea, edita y guarda archivos de texto o código.
- Importa proyectos ZIP mediante el navegador de archivos de Android.
- Árbol de proyecto, pestañas, búsqueda, símbolos, deshacer/rehacer y exportación ZIP.
- Números de línea lógicos y ajuste de línea desactivado por defecto.
- Zoom con dos dedos y desplazamiento táctil horizontal/vertical.
- Barra flotante y movible con símbolos frecuentes de programación.
- Mantener pulsado un archivo o carpeta permite eliminarlo con confirmación.
- Mini chat de IA inferior con tres tamaños: pequeño, mediano y grande.
- Al abrir IA, usa solamente el texto seleccionado; si no hay selección, usa el archivo completo. En ambos casos conserva el contexto del README.
- Indicador visible `SELECCIÓN` / `ARCHIVO` para saber qué contenido se enviará.
- Modo IA Normal para ahorrar tokens y modo Dev para respuestas o soluciones más extensas.
- Preguntas frecuentes compactas y desplazables dentro del mini chat.
- Las consultas se pueden cancelar, tienen tiempo límite y no se mezclan al cambiar de proyecto.
- Oliver IA responde de forma breve y progresiva; solo genera código cuando se le solicita expresamente.
- Al importar un ZIP, busca `README.md`, `README.txt` o `README` y lo usa como contexto del proyecto.
- Si no hay conexión, el resumen del README se intenta una sola vez por proyecto durante la sesión.
- Conscrypt ofrece HTTPS moderno en Android 4.2, usando la misma solución probada en RetroAI.
- Botón superior para alternar entre edición y solo lectura sin abrir el teclado.
- Atrás minimiza la aplicación y mantiene proyecto, pestañas, cambios, cursores y chat mientras la tarea siga abierta. Al quitarla desde Aplicaciones recientes, el siguiente inicio es limpio.
- Envía el archivo activo a compiladores instalados como C4droid o a otras aplicaciones compatibles.
- Comparte archivos o el proyecto ZIP editado mediante el selector de Android, incluido Bluetooth cuando esté disponible.

## Configurar Render y OpenRouter

La carpeta `backend/` contiene el servidor y `render.yaml` permite desplegarlo en Render.

Variables privadas requeridas en Render:

- `OPENROUTER_API_KEY`: clave privada de OpenRouter; nunca va dentro del APK.
- `APP_SHARED_KEY`: contraseña compartida entre OliverCode y Render.
- `OPENROUTER_MODEL`: opcional; por defecto `openrouter/free`.

En **OliverCode → Ajustes de IA** escribe:

1. URL base de Render, por ejemplo `https://mi-app.onrender.com`.
2. Encabezado: `X-RetroAI-Key`, `X-OliverCode-Key` o `X-API-Key`.
3. La misma contraseña configurada como `APP_SHARED_KEY`.
4. El modelo de OpenRouter.

El backend acepta los tres nombres de encabezado para mantener compatibilidad con RetroAI.

## Compilar con GitHub Actions

1. Descomprime este ZIP en la raíz del repositorio.
2. Ejecuta `git add .`, `git commit` y `git push`.
3. Abre **Actions → Compilar OliverCode Beta**.
4. Descarga el artifact `OliverCode-Lite-Beta-v0.4.0-Android-4.2`.

El proyecto usa `minSdk 17`, Java 17 para la compilación, Gradle 7.6 y Android SDK 33.
