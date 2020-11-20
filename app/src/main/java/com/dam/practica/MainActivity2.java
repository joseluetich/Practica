package com.dam.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

public class MainActivity2 extends AppCompatActivity {
    Button notificacionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //INTENT IMPLICITO EJEMPLO 2

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "intent de la actividad 2");
        sendIntent.setType("text/plain");
        Intent chooser = Intent.createChooser(sendIntent, "elegir esta");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

        //NOTIFICACIONES

        notificacionButton = findViewById(R.id.notificacionButton);

        Intent i = new Intent(this, MainActivity3.class);

        notificacionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NotificacionAsyncTask(notificacionButton).execute();
                startActivity(i);
            }
        });

    }

    //ASINC TASK PARA NOTIFICACION
    private static class NotificacionAsyncTask extends AsyncTask<Void, Void, String> {

        private WeakReference<Button> mButton;

        NotificacionAsyncTask(Button button) {
            mButton = new WeakReference<>(button);
        }

        @Override
        protected String doInBackground(Void... voids) {

            final int SLEEP_TIME = 3000;

            // Sleep for the random amount of time
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            NotificationPublisher notificationPublisher = NotificationPublisher.getInstance();
            Intent intent = new Intent();
            notificationPublisher.onReceive(mButton.get().getContext(),intent);
        }
    }
}