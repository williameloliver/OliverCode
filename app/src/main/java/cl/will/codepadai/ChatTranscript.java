package cl.will.codepadai;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Native views only: no WebView, JavaScript or external Markdown engine. */
public final class ChatTranscript extends LinearLayout {
 private final StringBuilder raw=new StringBuilder();
 private static final Pattern FENCE=Pattern.compile("(?m)^[ \\t]*```([^\\r\\n]*)\\r?\\n([\\s\\S]*?)(?:^[ \\t]*```[ \\t]*(?:\\r?\\n|$)|\\z)");
 public ChatTranscript(Context context){super(context);setOrientation(VERTICAL);}
 public CharSequence getText(){return raw.toString();}
 public void append(CharSequence text){raw.append(text);render();}
 public void setText(CharSequence text){raw.setLength(0);if(text!=null)raw.append(text);render();}
 private int dp(int value){return (int)(value*getResources().getDisplayMetrics().density+.5f);}
 private TextView text(String value){TextView v=new TextView(getContext());v.setText(value);v.setTextColor(Color.DKGRAY);v.setTextIsSelectable(true);v.setTextSize(14);v.setPadding(dp(4),dp(3),dp(4),dp(3));return v;}
 private void render(){
  removeAllViews();String source=raw.toString();Matcher match=FENCE.matcher(source);int end=0;
  while(match.find()){
   if(match.start()>end)addView(text(source.substring(end,match.start())));
   addCode(match.group(1).trim(),match.group(2));end=match.end();
  }
  if(end<source.length())addView(text(source.substring(end)));
 }
 private void addCode(String language,final String code){
  LinearLayout box=new LinearLayout(getContext());box.setOrientation(VERTICAL);box.setBackgroundColor(Color.rgb(22,25,23));
  LinearLayout heading=new LinearLayout(getContext());heading.setGravity(Gravity.CENTER_VERTICAL);
  TextView label=text(language.length()==0?"Código":language);label.setTextColor(Color.LTGRAY);heading.addView(label,new LinearLayout.LayoutParams(0,-2,1));
  TextView copy=text("COPIAR");copy.setTextIsSelectable(false);copy.setGravity(Gravity.CENTER);copy.setTextColor(Color.WHITE);copy.setPadding(dp(12),dp(6),dp(12),dp(6));
  copy.setContentDescription("Copiar solamente el código");
  copy.setOnClickListener(new View.OnClickListener(){public void onClick(View view){
   ClipboardManager clipboard=(ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE);
   clipboard.setPrimaryClip(ClipData.newPlainText("Código",code));Toast.makeText(getContext(),"Código copiado",Toast.LENGTH_SHORT).show();
  }});
  heading.addView(copy);box.addView(heading);
  HorizontalScrollView scroller=new HorizontalScrollView(getContext());TextView content=text(code);content.setTypeface(Typeface.MONOSPACE);content.setTextColor(Color.rgb(175,240,185));content.setHorizontallyScrolling(true);scroller.addView(content);box.addView(scroller,new LinearLayout.LayoutParams(-1,-2));
  LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(-1,-2);params.setMargins(0,dp(4),0,dp(6));addView(box,params);
 }
}
