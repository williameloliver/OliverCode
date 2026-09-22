package cl.will.codepadai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.KeyEvent;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.text.method.KeyListener;

/** Selection, copying, scrolling and zoom remain available in reading mode. */
public class CodeEditText extends EditText {
 public interface ChatVisible { boolean isVisible(); }
 public ChatVisible chatVisible; public Runnable backAction;
 @Override public boolean onKeyPreIme(int key,KeyEvent e){
  if(key==KeyEvent.KEYCODE_BACK&&chatVisible!=null&&chatVisible.isVisible()){
   if(e.getAction()==KeyEvent.ACTION_UP&&!e.isCanceled()&&backAction!=null)backAction.run();
   return true;
  }
  return super.onKeyPreIme(key,e);
 }
 private ScaleGestureDetector scale;
 private float sizeSp=14f;
 private KeyListener editingKeys;
 private boolean readOnly;
 public CodeEditText(Context c){super(c);init(c);}
 public CodeEditText(Context c,AttributeSet a){super(c,a);init(c);}
 private void init(Context c){
  editingKeys=getKeyListener();
  scale=new ScaleGestureDetector(c,new ScaleGestureDetector.SimpleOnScaleGestureListener(){
   public boolean onScale(ScaleGestureDetector d){sizeSp=Math.max(9,Math.min(32,sizeSp*d.getScaleFactor()));setTextSize(sizeSp);return true;}
  });
 }
 public void setReadOnly(boolean value){
  if(readOnly==value)return;
  readOnly=value;
  if(value){
   editingKeys=getKeyListener();setKeyListener(null);setTextIsSelectable(true);setCursorVisible(false);
   InputMethodManager imm=(InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
   imm.hideSoftInputFromWindow(getWindowToken(),0);imm.restartInput(this);
  }else{
   setTextIsSelectable(false);setKeyListener(editingKeys);setCursorVisible(true);setFocusable(true);setFocusableInTouchMode(true);
  }
 }
 public boolean isReadOnly(){return readOnly;}
 @Override public boolean onCheckIsTextEditor(){return !readOnly&&super.onCheckIsTextEditor();}
 @Override public InputConnection onCreateInputConnection(EditorInfo info){return readOnly?null:super.onCreateInputConnection(info);}
 @Override public boolean onTextContextMenuItem(int id){
  if(readOnly&&id!=android.R.id.copy&&id!=android.R.id.selectAll)return false;
  return super.onTextContextMenuItem(id);
 }
 @Override public boolean onKeyDown(int key,KeyEvent event){
  if(readOnly&&key!=KeyEvent.KEYCODE_BACK&&key!=KeyEvent.KEYCODE_DPAD_UP&&key!=KeyEvent.KEYCODE_DPAD_DOWN&&key!=KeyEvent.KEYCODE_DPAD_LEFT&&key!=KeyEvent.KEYCODE_DPAD_RIGHT)return true;
  return super.onKeyDown(key,event);
 }
 @Override public boolean onKeyMultiple(int code,int count,KeyEvent e){return readOnly||super.onKeyMultiple(code,count,e);}
 @Override public boolean onDragEvent(DragEvent event){return readOnly?false:super.onDragEvent(event);}
 @Override public boolean onTouchEvent(MotionEvent e){scale.onTouchEvent(e);return super.onTouchEvent(e);}
}
