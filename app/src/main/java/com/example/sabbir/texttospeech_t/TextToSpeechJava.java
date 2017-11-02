package com.example.sabbir.texttospeech_t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Sabbir on 027  27 09 16  Sep.
 */

public class TextToSpeechJava extends Activity {

    TextToSpeech t1;
    EditText ed1;
    Button b1, b2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.text_to_speech);

        ed1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);


        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a1 = ed1.getText().toString();
                if (a1 != null) {
                    ed1.setText("");
                }
            }
        });
    }

    /*public void backtobeginning(View v) {
        Intent i = new Intent(this, FrontPanel.class);
        startActivity(i);
    }*/






    //@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        /**
         MenuItem shareItem = menu.findItem(R.id.action_share);

         ShareActionProvider mShare = (ShareActionProvider)shareItem.getActionProvider();

         Intent shareIntent = new Intent(Intent.ACTION_SEND);
         shareIntent.setAction(Intent.ACTION_SEND);
         shareIntent.setType("text/plain");
         shareIntent.putExtra(Intent.EXTRA_TEXT,"text to share");

         mShare.setShareIntent(shareIntent);
         */
        ShareActionProvider mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.action_share).getActionProvider();

        /** Getting the target intent */
        Intent intent = getDefaultShareIntent();

        /** Setting a share intent */
        if(intent!=null)
            mShareActionProvider.setShareIntent(intent);
        return true;
    }
    private Intent getDefaultShareIntent(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
        intent.putExtra(Intent.EXTRA_TEXT,"Sample Content !!!");
        return intent;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //Intent intent;

        switch (item.getItemId()) {
            /*case R.id.english1:
                Intent intent = new Intent(this, Alphabets.class);
                startActivity(intent);
                return true;

            case R.id.speak1:
                Intent intent1 = new Intent(this, TextToSpeechJava.class);
                startActivity(intent1);
                return true;

            case R.id.rhymes1:
                return true;

            case R.id.homophones1:
                return true;

            case R.id.about1:
                Intent intent2 = new Intent(this, AboutM.class);
                startActivity(intent2);
                return true;

            case R.id.exit1:
                //activity.moveTaskToBack(true); //exit does not properly works without it. !
                //android.os.Process.killProcess(android.os.Process.myPid());
                //System.exit(1);

                //Display Toast
                //Toast.makeText(getApplicationContext(), "This is simple Demo application with Action Bar", Toast.LENGTH_LONG).show();
                //test();
                //Toast.makeText(getApplicationContext(), "This is simple Demo application with Action Bar", Toast.LENGTH_LONG).show();
                moveTaskToBack(true); //exit does not properly works without it. !
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                return true;*/
            //break;
        }

        /*
        int id = item.getItemId();
        if (id == R.id.exit1) {
            //Display Toast

            return true;
        }
        */
        //return super.onOptionsItemSelected(item);
        return true;
    }
    //private void test(){
    //}

}
