package cl.will.codepadai;

import android.content.Context;
import android.graphics.*;
import android.view.View;
import android.widget.EditText;

public class LineNumberView extends View {
 private final Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG); private EditText editor;
 public LineNumberView(Context c){super(c);paint.setColor(Color.rgb(125,110,100));paint.setTextAlign(Paint.Align.RIGHT);setBackgroundColor(Color.rgb(242,238,233));}
 public void attach(EditText e){editor=e;}
 protected void onDraw(Canvas c){super.onDraw(c);if(editor==null||editor.getLayout()==null)return;paint.setTextSize(editor.getTextSize()*.82f);android.text.Layout layout=editor.getLayout();int first=layout.getLineForVertical(editor.getScrollY()),last=layout.getLineForVertical(editor.getScrollY()+getHeight());CharSequence text=editor.getText();int firstStart=layout.getLineStart(first),logical=1;for(int i=0;i<firstStart&&i<text.length();i++)if(text.charAt(i)=='\n')logical++;float x=getWidth()-6;for(int visual=first;visual<=last&&visual<layout.getLineCount();visual++){int start=layout.getLineStart(visual),end=layout.getLineEnd(visual);boolean realStart=start==0||(start>0&&text.charAt(start-1)=='\n');if(realStart){float y=editor.getPaddingTop()+layout.getLineBaseline(visual)-editor.getScrollY();c.drawText(String.valueOf(logical),x,y,paint);}if(end>start&&end<=text.length()&&text.charAt(end-1)=='\n')logical++;}}
}
