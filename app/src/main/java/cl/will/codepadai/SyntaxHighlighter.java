package cl.will.codepadai;

import android.graphics.Color;
import android.text.*;
import android.text.style.ForegroundColorSpan;
import java.io.File;
import java.util.regex.*;

final class SyntaxHighlighter {
    private static final int BLUE=Color.rgb(30,85,170), GREEN=Color.rgb(35,125,65), RED=Color.rgb(175,55,45), PURPLE=Color.rgb(120,55,145), GRAY=Color.rgb(110,110,110);
    static void apply(Editable e,File file){
        ForegroundColorSpan[] old=e.getSpans(0,e.length(),ForegroundColorSpan.class); for(ForegroundColorSpan s:old)e.removeSpan(s);
        String n=file.getName().toLowerCase(), t=e.toString();
        span(e,t,"(?s)/\\*.*?\\*/|//[^\\n]*|#[^\\n]*",GRAY);
        span(e,t,"\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'",RED);
        span(e,t,"\\b(?:true|false|null|None|True|False|[0-9]+(?:\\.[0-9]+)?)\\b",PURPLE);
        String words="if|else|for|while|do|switch|case|break|continue|return|new|class|interface|extends|implements|public|private|protected|static|final|void|int|long|float|double|boolean|char|try|catch|finally|throw|throws|import|package|def|lambda|in|is|and|or|not|from|as|with|yield|function|var|let|const|async|await|include|define|struct|enum|typedef|sizeof|echo";
        if(!n.endsWith(".txt")&&!n.endsWith(".md"))span(e,t,"\\b(?:"+words+")\\b",BLUE);
        if(n.endsWith(".json")||n.endsWith(".xml")||n.endsWith(".html"))span(e,t,"(?m)(?<=^|[,{])\\s*\"[^\"]+\"(?=\\s*:)|</?[A-Za-z][^>]*>",GREEN);
    }
    private static void span(Editable e,String t,String regex,int color){ try{Matcher m=Pattern.compile(regex).matcher(t);while(m.find())e.setSpan(new ForegroundColorSpan(color),m.start(),m.end(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}catch(Exception ignored){} }
}
