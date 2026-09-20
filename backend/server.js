const express = require("express");
const app = express();
app.use(express.json({ limit: "3mb" }));

function auth(req, res, next) {
  const expected = process.env.APP_SHARED_KEY || "";
  const received = req.header("X-OliverCode-Key") || req.header("X-RetroAI-Key") || req.header("X-API-Key") || "";
  if (!expected) return res.status(500).json({ error: "APP_SHARED_KEY no configurada" });
  if (received !== expected) return res.status(401).json({ error: "Clave de aplicación inválida" });
  next();
}

app.get("/health", (req, res) => res.json({ ok: true, app: "OliverCode Backend" }));

app.get("/models", auth, async (req, res) => {
  try {
    const r = await fetch("https://openrouter.ai/api/v1/models", { headers: { Authorization: `Bearer ${process.env.OPENROUTER_API_KEY}` } });
    res.status(r.status).type("application/json").send(await r.text());
  } catch (e) { res.status(500).json({ error: String(e) }); }
});

app.post("/chat", auth, async (req, res) => {
  try {
    let messages = Array.isArray(req.body.messages) ? req.body.messages : null;
    if (!messages) {
      const context = req.body.project_context || "Sin contexto README";
      messages = [
        { role: "system", content: `Eres el asistente de OliverCode. Contexto del proyecto:\n${context}` },
        { role: "user", content: `${req.body.question || "Analiza"}\n\nArchivo: ${req.body.filename || "archivo"}\n\n${req.body.code || ""}` }
      ];
    }
    const payload = {
      model: req.body.model || process.env.OPENROUTER_MODEL || "openrouter/free",
      messages,
      max_tokens: Math.max(128, Math.min(Number(req.body.max_tokens || 1200), 4096)),
      temperature: 0.35,
      stream: false
    };
    const r = await fetch("https://openrouter.ai/api/v1/chat/completions", {
      method: "POST",
      headers: {
        Authorization: `Bearer ${process.env.OPENROUTER_API_KEY}`,
        "Content-Type": "application/json",
        "HTTP-Referer": process.env.APP_URL || "https://localhost",
        "X-OpenRouter-Title": "OliverCode Beta"
      },
      body: JSON.stringify(payload)
    });
    const data = await r.json();
    if (!r.ok) return res.status(r.status).json(data);
    res.json({ text: data?.choices?.[0]?.message?.content || "", model: data.model || payload.model, usage: data.usage || {} });
  } catch (e) { res.status(500).json({ error: String(e) }); }
});

app.listen(process.env.PORT || 3000, "0.0.0.0", () => console.log("OliverCode backend listo"));
