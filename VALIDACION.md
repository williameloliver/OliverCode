# Validación de OliverCode Lite 0.4.2

- Compilación de todas las clases Java con javac, API Android 4.1, Conscrypt 2.5.2 y clases JSON: correcta.
- La API usada para validar es anterior a minSdk 17.
- Prueba del separador de Markdown: múltiples bloques, texto fuera del bloque, código exacto para copiar y bloque sin cierre: correcta.
- Manifiesto XML, sintaxis del backend Node.js e integridad ZIP: correctos.
- No se ensambló un APK local ni se ejecutó un emulador en esta entrega. GitHub Actions realiza assembleDebug.
- Sin acceso al backend privado: no se realizaron consultas pagadas reales.

## Pruebas en tablet

1. Abrir IA pequeña: el botón ? está en cabecera y no ocupa espacio de conversación.
2. Activar lectura: tocar símbolos, pegar y escribir con teclado Bluetooth no modifica el archivo. Copiar y seleccionar siguen disponibles.
3. Volver a edición y comprobar símbolos, pegado y teclado.
4. Chat abierto: Atrás, × e IA ocultan sin preguntar ni cancelar consultas. Reabrir conserva el contenido.
4a. Guardar/Guardar todos ofrece guardar TXT una sola vez. Repetir sin cambios no pregunta.
4b. Cerrar pestaña resuelve primero cambios de archivo, luego TXT. Cancelar deja pestaña abierta. No guardar conserva chat.
4c. Menú ? → Guardar conversación TXT guarda a demanda.
4d. Exportar ZIP ofrece guardar TXT después de exportar; compartir no abre preguntas adicionales.
5. Con chat cerrado, Atrás minimiza. Volver conserva la sesión.
6. Guardar TXT, abrir workspaces/Conversaciones IA y revisar contexto, fecha, acentos y conversación.
7. Solicitar dos bloques de código: copiar cada uno sin mezclar explicación.
8. Preguntar en español, inglés y chino; comprobar el idioma del modelo elegido.
9. Repetir apertura en C4droid y compartir por Bluetooth.
10. Cerrar desde Recientes no puede mostrar una confirmación de guardado: guardar el chat antes.

## Instalación

Mantiene applicationId cl.will.codepadai y minSdk 17; versionCode 8.
Instalar sobre la app anterior requiere la misma firma. No desinstalar sin respaldar los proyectos locales.
