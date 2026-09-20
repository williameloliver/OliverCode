package cl.will.codepadai;

import android.app.*;import android.os.*;import android.content.*;import android.graphics.Color;import android.text.InputType;import android.view.*;import android.widget.*;
public class SettingsActivity extends Activity {
 public static final String PREF="settings", URL="backend_url";
 public void onCreate(Bundle b){super.onCreate(b); final LinearLayout l=new LinearLayout(this);l.setOrientation(LinearLayout.VERTICAL);l.setPadding(20,20,20,20);TextView title=new TextView(this);title.setText("AJUSTES DE IA");title.setTextSize(20);title.setTextColor(Color.rgb(90,55,35));l.addView(title);
  final EditText url=new EditText(this);url.setHint("http://tu-backend.onrender.com/chat");url.setSingleLine();url.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_URI);url.setText(getSharedPreferences(PREF,0).getString(URL,""));l.addView(url,new LinearLayout.LayoutParams(-1,-2));
  TextView note=new TextView(this);note.setText("La API key permanece en Render. La app enviará question, language, filename y code como JSON.");note.setPadding(0,8,0,16);l.addView(note);Button save=new Button(this);save.setText("GUARDAR");l.addView(save);save.setOnClickListener(new View.OnClickListener(){public void onClick(View v){getSharedPreferences(PREF,0).edit().putString(URL,url.getText().toString().trim()).apply();Toast.makeText(SettingsActivity.this,"Guardado",Toast.LENGTH_SHORT).show();finish();}});setContentView(l); }
}
