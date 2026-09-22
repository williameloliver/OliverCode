package cl.will.codepadai;

import android.content.*;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import java.io.*;

public class OliverFileProvider extends ContentProvider {
 public boolean onCreate(){return true;}
 private File resolve(Uri uri) throws FileNotFoundException {
  String path=uri.getQueryParameter("path");if(path==null)throw new FileNotFoundException("Ruta vacía");
  try{File f=new File(path).getCanonicalFile();File files=getContext().getExternalFilesDir(null).getCanonicalFile();File cache=getContext().getExternalCacheDir().getCanonicalFile();String p=f.getPath();if(!p.startsWith(files.getPath()+File.separator)&&!p.startsWith(cache.getPath()+File.separator))throw new FileNotFoundException("Ruta no compartible");return f;}catch(IOException e){throw new FileNotFoundException(e.getMessage());}
 }
 public ParcelFileDescriptor openFile(Uri uri,String mode)throws FileNotFoundException{return ParcelFileDescriptor.open(resolve(uri),mode!=null&&mode.indexOf('w')>=0?ParcelFileDescriptor.MODE_READ_WRITE:ParcelFileDescriptor.MODE_READ_ONLY);}
 public String getType(Uri uri){String n;try{n=resolve(uri).getName().toLowerCase();}catch(Exception e){return "application/octet-stream";}if(n.endsWith(".zip"))return "application/zip";if(n.endsWith(".c")||n.endsWith(".h"))return "text/x-csrc";if(n.endsWith(".cpp")||n.endsWith(".hpp"))return "text/x-c++src";if(n.endsWith(".java"))return "text/x-java";if(n.endsWith(".py"))return "text/x-python";return "text/plain";}
 public Cursor query(Uri uri,String[] projection,String selection,String[] args,String sort){File f;try{f=resolve(uri);}catch(Exception e){return null;}String[] cols=projection==null?new String[]{OpenableColumns.DISPLAY_NAME,OpenableColumns.SIZE}:projection;MatrixCursor c=new MatrixCursor(cols,1);Object[] row=new Object[cols.length];for(int i=0;i<cols.length;i++){if(OpenableColumns.DISPLAY_NAME.equals(cols[i]))row[i]=f.getName();else if(OpenableColumns.SIZE.equals(cols[i]))row[i]=f.length();}c.addRow(row);return c;}
 public int delete(Uri u,String s,String[] a){return 0;}public int update(Uri u,ContentValues v,String s,String[] a){return 0;}public Uri insert(Uri u,ContentValues v){return null;}
}
