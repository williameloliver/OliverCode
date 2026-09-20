package cl.will.codepadai;

import java.io.*;
import java.util.zip.*;

final class FileUtils {
    static String read(File f) throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        StringBuilder b=new StringBuilder(); char[] c=new char[4096]; int n;
        while((n=r.read(c))!=-1) b.append(c,0,n); r.close(); return b.toString();
    }
    static void write(File f,String s) throws IOException {
        File parent=f.getParentFile(); if(parent!=null) parent.mkdirs();
        Writer w=new OutputStreamWriter(new FileOutputStream(f),"UTF-8"); w.write(s); w.close();
    }
    static void unzip(File zip,File out) throws IOException {
        ZipInputStream in=new ZipInputStream(new BufferedInputStream(new FileInputStream(zip))); ZipEntry e; byte[] b=new byte[8192];
        String root=out.getCanonicalPath()+File.separator;
        while((e=in.getNextEntry())!=null){ File target=new File(out,e.getName());
            if(!target.getCanonicalPath().startsWith(root)) throw new IOException("Ruta insegura en ZIP");
            if(e.isDirectory()) target.mkdirs(); else { target.getParentFile().mkdirs(); FileOutputStream o=new FileOutputStream(target); int n; while((n=in.read(b))>0)o.write(b,0,n);o.close(); }
        } in.close();
    }
    static void zip(File root,File target) throws IOException {
        ZipOutputStream out=new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target))); add(root,root,out); out.close();
    }
    private static void add(File root,File f,ZipOutputStream out)throws IOException{
        File[] kids=f.listFiles(); if(f.isDirectory()){ if(kids!=null)for(File k:kids)add(root,k,out); return; }
        String name=root.toURI().relativize(f.toURI()).getPath(); out.putNextEntry(new ZipEntry(name)); FileInputStream in=new FileInputStream(f); byte[] b=new byte[8192]; int n; while((n=in.read(b))>0)out.write(b,0,n);in.close();out.closeEntry();
    }
    static boolean deleteRecursive(File f){
        if(f==null||!f.exists())return true;
        if(f.isDirectory()){File[] kids=f.listFiles();if(kids!=null)for(File k:kids)if(!deleteRecursive(k))return false;}
        return f.delete();
    }
}
