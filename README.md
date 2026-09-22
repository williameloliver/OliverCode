# OliverCode Lite · Beta 0.4.2

**Lee, comprende, edita y comparte proyectos desde tu tablet.**  
**Read, understand, edit and share projects on your tablet.**  
**在平板上阅读、理解、编辑和分享代码项目。**

Android 4.2+ · API 17 · Java nativo / Native Java / 原生 Java

## Español

OliverCode Lite es un editor liviano para explorar proyectos propios o generados con IA y aprender directamente de su código.

### Funciones destacadas

1. **Proyectos ZIP:** importa con el selector de Android, navega por carpetas y exporta el proyecto editado.
2. **Editor táctil:** pestañas, resaltado de sintaxis, números de línea lógicos, búsqueda, deshacer y rehacer.
3. **Lectura cómoda:** zoom con dos dedos, desplazamiento y ajuste de línea opcional, desactivado por defecto.
4. **Solo lectura:** botón superior para leer sin teclado; bloquea símbolos, pegado, escritura y deshacer/rehacer hasta activar edición.
5. **Símbolos flotantes:** paleta movible con los signos de programación más frecuentes.
6. **IA con contexto:** analiza la selección y el contexto README; sin selección, envía el archivo activo completo.
7. **Chat ajustable:** tres tamaños para conversar sin perder de vista el código.
8. **Preguntas rápidas:** botón **?** junto a “Oliver IA”, con un menú que no ocupa una fila permanente.
9. **Normal / Dev:** explicaciones breves o mayor presupuesto de respuesta. Dev aumenta el límite, pero no garantiza código de longitud ilimitada.
10. **Código separado:** bloques Markdown con tres acentos graves sobre fondo oscuro, texto verde y botón **COPIAR**, que copia solo el código.
11. **Conversaciones TXT:** al guardar archivos o cerrar pestañas, elige **GUARDAR**, **NO GUARDAR** o **CANCELAR**. Los archivos UTF-8 quedan en **workspaces/Conversaciones IA**.
12. **Notas para estudiar:** proyecto, fecha, modo, contextos README utilizados y conversación en bruto. El contexto es información del proyecto, no razonamiento interno de la IA.
13. **Atrás intuitivo:** primero cierra el chat; con el chat cerrado, minimiza OliverCode.
14. **Compartir:** abre código en aplicaciones compatibles y envía archivos o proyectos ZIP, incluido Bluetooth cuando el dispositivo lo ofrezca.
15. **Render + OpenRouter:** URL, contraseña y modelo configurables; la clave de OpenRouter permanece en el backend.
16. **Idioma de respuesta:** el prompt pide seguir el idioma de tu pregunta, aunque el código o README estén en otro idioma.

### Cómo usarlo

Importa un ZIP, abre un archivo y elige lectura o edición. Selecciona unas líneas y abre IA; sin selección se usa todo el archivo. Las preguntas rápidas llenan el campo sin enviarse automáticamente. Copia el código, pégalo con edición activada y utiliza **Abrir en compilador** o **Compartir proyecto ZIP**.

Cerrar el chat no borra su contenido. Si no cambia desde el último guardado o desde “No guardar”, no vuelve a preguntar. Ocultar el panel no pregunta, no borra la conversación y no cancela consultas. El menú **? → Guardar conversación TXT** permite guardarla manualmente. Al cerrar una pestaña, primero se resuelve el archivo y luego se ofrece guardar el chat. Si eliges Cancelar, la pestaña permanece abierta. Una respuesta que llegue después de guardar queda pendiente para un próximo guardado. Si consultas varios proyectos, el TXT conserva sus contextos registrados.

**Límites:** Android no permite mostrar una confirmación al forzar el cierre desde el gestor de tareas; guarda antes. Minimizar conserva la tarea; quitarla de Recientes permite empezar una nueva sesión, conservando los archivos guardados. C4droid y otros receptores deben aceptar el tipo de archivo y las URI compartidas; OliverCode no incluye compiladores. Bluetooth depende del dispositivo. Los cuadros de código requieren delimitadores Markdown. El modelo puede no seguir siempre las instrucciones de idioma.

## English

OliverCode Lite is a lightweight editor for exploring your own or AI-generated projects and learning directly from their code.

### Highlights

1. **ZIP projects:** Android file picker, folder browser and edited-source export.
2. **Touch editor:** tabs, syntax highlighting, logical line numbers, search and undo/redo.
3. **Comfortable reading:** pinch zoom, scrolling and optional word wrap, off by default.
4. **Read-only mode:** a top button disables keyboard editing, paste, symbols and undo/redo while preserving reading and copying.
5. **Floating symbols:** a movable palette of common programming characters.
6. **Contextual AI:** selected text plus README context; without a selection, the entire active file is sent.
7. **Resizable chat:** three sizes with code remaining visible.
8. **Quick questions:** the **?** button next to “Oliver IA” opens a compact menu.
9. **Normal / Dev:** short answers or a larger response budget. Dev does not remove output limits.
10. **Code cards:** triple-backtick Markdown code blocks appear on a dark background with green text and a code-only **COPY** button.
11. **TXT conversations:** saving files or closing tabs offers Save, Don't save or Cancel. UTF-8 files are stored in **workspaces/Conversaciones IA**.
12. **Study notes:** project, date, mode, captured README contexts and raw conversation; no hidden model reasoning.
13. **Back navigation:** closes chat first; otherwise moves OliverCode to the background.
14. **Sharing:** open code in compatible apps and share edited ZIPs, including Bluetooth where available.
15. **Render + OpenRouter:** configurable endpoint, app password and model; the OpenRouter key stays on the backend.
16. **Language matching:** the prompt requests the language of your question rather than the source code's language.

### Usage and limitations

Import a ZIP, open a file and choose reading or editing. Select lines before opening AI, or leave no selection to ask about the whole file. Quick questions only fill the input. Paste copied code in editing mode, then open it in a compiler or share the project.

Hiding chat preserves its content. Unchanged conversations do not prompt repeatedly. Hiding chat never prompts or cancels a request. Use **? → Guardar conversación TXT** to save manually. File-save decisions come first when closing a tab. Cancel leaves that tab open. A later AI response becomes eligible for another save. Multi-project conversations retain captured contexts in their TXT export.

Android cannot display a save prompt during a forced task-manager closure: save beforehand. Backgrounding retains the task; removing it from Recents starts a fresh session next time, while saved files remain. Compiler integration depends on the receiver's MIME/content-URI support; no compiler is bundled. Bluetooth depends on the device. Code cards require Markdown fences, and language compliance depends on the selected model.

## 简体中文

OliverCode Lite 是一款轻量级代码编辑器，适合阅读自己的项目或 AI 生成的项目，并直接从实际代码中学习。

### 主要功能

1. **ZIP 项目：**通过 Android 文件选择器导入，浏览目录并导出修改后的源码。
2. **触控编辑：**标签页、语法高亮、逻辑行号、搜索、撤销与重做。
3. **舒适阅读：**双指缩放、滚动与可选自动换行；默认关闭自动换行。
4. **只读模式：**顶部按钮切换阅读与编辑；只读时禁止符号插入、粘贴、键盘输入、撤销和重做。
5. **浮动符号栏：**可移动的常用编程符号面板。
6. **有上下文的 AI：**使用 README 背景并分析选中的代码；没有选择时发送当前整个文件。
7. **聊天尺寸：**小、中、大三种尺寸，可同时查看代码。
8. **常见问题：**点击 “Oliver IA” 旁的 **?** 打开紧凑菜单，不长期占用聊天区域。
9. **Normal / Dev 模式：**选择简短解释或较大的输出额度；Dev 不代表无限输出。
10. **代码卡片：**Markdown 三反引号代码块显示为深色背景、绿色文字，按钮只复制代码。
11. **保存对话：**保存文件或关闭标签页时可选择保存、不保存或取消；UTF-8 TXT 位于 **workspaces/Conversaciones IA**。
12. **学习记录：**包含项目名称、日期、模式、README 上下文及原始对话，不包含模型内部推理。
13. **返回键：**先关闭聊天；聊天关闭后再将应用移到后台。
14. **分享：**将代码发送到兼容应用，或通过 Android 分享菜单发送修改后的 ZIP；支持设备提供的蓝牙分享。
15. **Render + OpenRouter：**配置服务器、应用密码及模型；OpenRouter API 密钥只保留在服务器。
16. **回答语言：**提示词要求 AI 使用当前问题的语言，而不是跟随代码或 README 的语言。

### 使用说明与限制

导入 ZIP 后打开文件，选择阅读或编辑模式。选择几行代码后提问，或不选择任何内容以询问整个文件。常见问题只填入输入框，不会自动发送。复制代码后，在编辑模式粘贴，再分享到编译器。

关闭聊天不会清空内容；没有变化的对话不会重复询问保存。隐藏聊天不会询问保存，也不会取消请求。可以通过 **? → Guardar conversación TXT** 手动保存。关闭标签页时先处理文件保存，再处理对话保存；取消会保留标签页。稍后收到的新回答可再次保存。如果讨论多个项目，TXT 会保留已记录的项目上下文。

通过任务管理器强制关闭应用时，Android 无法弹出保存确认，因此请提前保存。后台任务可以保留会话；从最近任务中移除后，下次开启新会话，已保存文件仍然保留。编译器对接取决于接收应用是否支持文件类型及 Android 内容 URI。本应用不内置编译器。蓝牙依赖设备服务。代码卡片需要 Markdown 代码块，回答语言也受模型影响。

## Configurar IA / AI setup / AI 设置

Variables en Render / Render environment variables / Render 环境变量：

- **OPENROUTER_API_KEY:** clave privada / private API key / 私有 API 密钥。
- **APP_SHARED_KEY:** contraseña app-backend / app password / 应用密码。
- **OPENROUTER_MODEL:** modelo predeterminado opcional / optional default model / 可选默认模型。

En **Ajustes de IA**, introduce la URL de Render, el encabezado (**X-RetroAI-Key**, **X-OliverCode-Key** o **X-API-Key**), la contraseña y el modelo.  
In **AI settings**, enter your Render URL, header, app password and model.  
在 AI 设置中填写 Render 地址、请求头名称、应用密码及模型。

## Compilar / Build / 编译

Java 17 · Gradle 7.6 · Android Gradle Plugin 7.4.2 · compileSdk 33 · minSdk 17 · targetSdk 28

1. Sube el ZIP a Codespaces / Upload the ZIP to Codespaces / 将 ZIP 上传到 Codespaces。
2. Descomprime en la raíz del repositorio / Extract at the repository root / 解压到仓库根目录。
3. Confirma y sube / Commit and push / 提交并推送。
4. Abre / Open / 打开 **Actions → Compilar OliverCode Lite Beta**。
5. Descarga / Download / 下载 **OliverCode-Lite-Beta-v0.4.2-Android-4.2**。

~~~bash
cd /workspaces/OliverCode
unzip -o OliverCode_Lite_Beta_v0.4.2_source.zip
git add app backend .github README.md build.gradle settings.gradle gradle.properties render.yaml
git commit -m "OliverCode Lite Beta 0.4.2"
git pull --rebase origin main
git push origin main
~~~

Si aparecen conflictos, resuélvelos antes del push. / Resolve conflicts before pushing. / 如出现冲突，请先解决再推送。

APK: **app/build/outputs/apk/debug/app-debug.apk**

## Validación / Validation / 验证

Java compilado contra las API de Android 4.1 (nivel 16, anterior al mínimo 17), Conscrypt 2.5.2 y clases JSON. XML y sintaxis del backend revisados. Esto comprueba referencias y tipos Java; el ensamblado APK y las pruebas táctiles, Bluetooth y de ciclo de vida quedan para Actions y el dispositivo.

Java sources compiled against Android 4.1 API stubs, Conscrypt 2.5.2 and JSON classes; XML and backend syntax checked. APK assembly and real-device interaction tests remain necessary.

Java 源码已使用 Android 4.1 API、Conscrypt 2.5.2 和 JSON 类编译检查，并检查了 XML 与后端语法。仍需在 Actions 构建 APK，并在真机测试触控、蓝牙及应用生命周期。
