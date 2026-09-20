package cl.will.codepadai;

import android.content.Context;
import android.graphics.*;
import android.view.View;
import android.widget.EditText;

public class LineNumberView extends View {
 private final Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG); private EditText editor;
 public LineNumberView(Context c){super(c);paint.setColor(Color.rgb(125,110,100));paint.setTextAlign(Paint.Align.RIGHT);setBackgroundColor(Color.rgb(242,238,233));}
 public void attach(EditText e){editor=e;}
 protected void onDraw(Canvas c){super.onDraw(c);if(editor==null)return;paint.setTextSize(editor.getTextSize()*.82f);int first=Math.max(0,editor.getScrollY()/Math.max(1,editor.getLineHeight()));int visible=getHeight()/Math.max(1,editor.getLineHeight())+2;int total=editor.getLineCount();float x=getWidth()-6;for(int i=first;i<total&&i<first+visible;i++){float y=editor.getPaddingTop()+(i+1)*editor.getLineHeight()-editor.getScrollY()-4;c.drawText(String.valueOf(i+1),x,y,paint);}}
}
