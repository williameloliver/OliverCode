package cl.will.codepadai;

import android.os.Build;
import java.io.*;
import java.net.*;
import java.security.Provider;
import javax.net.ssl.*;
import org.conscrypt.Conscrypt;
import org.json.*;

final class AIClient {
 interface Callback { void done(String answer,Exception error); }
 static void ask(final String baseUrl,final String header,final String secret,final String model,
  final String question,final String language,final String filename,final String code,
  final String projectContext,final Callback cb){new Thread(new Runnable(){public void run(){try{
   String url=baseUrl.trim();while(url.endsWith("/"))url=url.substring(0,url.length()-1);if(!url.toLowerCase().endsWith("/chat"))url+="/chat";
   HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection();
   if(c instanceof HttpsURLConnection&&Build.VERSION.SDK_INT<21){Provider provider=Conscrypt.newProvider();SSLContext context=SSLContext.getInstance("TLS",provider);context.init(null,null,null);((HttpsURLConnection)c).setSSLSocketFactory(context.getSocketFactory());}
   c.setRequestMethod("POST");c.setConnectTimeout(20000);c.setReadTimeout(90000);c.setDoOutput(true);c.setRequestProperty("Content-Type","application/json; charset=UTF-8");
   if(header!=null&&header.trim().length()>0&&secret!=null)c.setRequestProperty(header.trim(),secret);
   String system="Eres el asistente de OliverCode, un editor para estudiar y mejorar proyectos. Responde en español con explicaciones claras y cambios concretos. Contexto del proyecto:\n"+(projectContext==null||projectContext.length()==0?"No hay README disponible.":projectContext);
   String user=question+"\n\nArchivo activo: "+filename+" ("+language+")\n\n"+code;
   JSONArray messages=new JSONArray();messages.put(new JSONObject().put("role","system").put("content",system));messages.put(new JSONObject().put("role","user").put("content",user));
   JSONObject body=new JSONObject();body.put("model",model==null||model.length()==0?"openrouter/free":model);body.put("max_tokens",1200);body.put("messages",messages);body.put("question",question);body.put("language",language);body.put("filename",filename);body.put("code",code);body.put("project_context",projectContext);
   OutputStream o=c.getOutputStream();o.write(body.toString().getBytes("UTF-8"));o.close();int status=c.getResponseCode();InputStream in=status>=200&&status<300?c.getInputStream():c.getErrorStream();BufferedReader r=new BufferedReader(new InputStreamReader(in,"UTF-8"));StringBuilder b=new StringBuilder();String line;while((line=r.readLine())!=null)b.append(line);r.close();
   if(status<200||status>=300)throw new IOException("HTTP "+status+": "+b.toString());JSONObject j=new JSONObject(b.toString());String a=j.optString("text",j.optString("answer",j.optString("response",j.optString("message",b.toString()))));cb.done(a,null);
  }catch(Exception e){cb.done(null,e);}}}).start();}
}
