package cl.will.codepadai;

import java.io.*;import java.net.*;import org.json.*;
final class AIClient {
 interface Callback { void done(String answer,Exception error); }
 static void ask(final String url,final String question,final String language,final String filename,final String code,final Callback cb){new Thread(new Runnable(){public void run(){try{
  HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection();c.setRequestMethod("POST");c.setConnectTimeout(15000);c.setReadTimeout(60000);c.setDoOutput(true);c.setRequestProperty("Content-Type","application/json; charset=UTF-8");
  JSONObject body=new JSONObject();body.put("question",question);body.put("language",language);body.put("filename",filename);body.put("code",code);
  OutputStream o=c.getOutputStream();o.write(body.toString().getBytes("UTF-8"));o.close();InputStream in=c.getResponseCode()<400?c.getInputStream():c.getErrorStream();BufferedReader r=new BufferedReader(new InputStreamReader(in,"UTF-8"));StringBuilder b=new StringBuilder();String line;while((line=r.readLine())!=null)b.append(line);r.close();
  JSONObject j=new JSONObject(b.toString());String a=j.optString("answer",j.optString("response",j.optString("message",b.toString())));cb.done(a,null);
 }catch(Exception e){cb.done(null,e);}}}).start(); }
}
