package cl.will.codepadai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.EditText;
import android.text.method.KeyListener;

public class CodeEditText extends EditText {
 private ScaleGestureDetector scale;
 private float sizeSp=14f;
 private KeyListener editingKeys;
 private boolean readOnly;
 public CodeEditText(Context c){super(c);init(c);}
 public CodeEditText(Context c,AttributeSet a){super(c,a);init(c);}
 private void init(Context c){editingKeys=getKeyListener();scale=new ScaleGestureDetector(c,new ScaleGestureDetector.SimpleOnScaleGestureListener(){public boolean onScale(ScaleGestureDetector d){sizeSp*=d.getScaleFactor();if(sizeSp<9)sizeSp=9;if(sizeSp>32)sizeSp=32;setTextSize(sizeSp);return true;}});}
 public void setReadOnly(boolean value){
  if(readOnly==value)return;readOnly=value;
  if(value){editingKeys=getKeyListener();setKeyListener(null);setCursorVisible(false);clearFocus();}
  else{setKeyListener(editingKeys);setCursorVisible(true);setFocusableInTouchMode(true);}
 }
 public boolean isReadOnly(){return readOnly;}
 @Override public boolean onTouchEvent(MotionEvent e){scale.onTouchEvent(e);return super.onTouchEvent(e);}
}
