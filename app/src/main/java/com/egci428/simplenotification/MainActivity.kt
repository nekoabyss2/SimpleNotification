package com.egci428.simplenotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendBtn.setOnClickListener {
            var intent = Intent(this@MainActivity, RecieverActivity::class.java)
            var pIntent = PendingIntent.getActivity(this@MainActivity, System.currentTimeMillis().toInt(), intent,0 )

            var intent1 = Intent(this@MainActivity, settingActivity::class.java)
            var pIntent1 = PendingIntent.getActivity(this@MainActivity, System.currentTimeMillis().toInt(), intent1,0 )

            var intent2 = Intent(this@MainActivity, warningActivity::class.java)
            var pIntent2 = PendingIntent.getActivity(this@MainActivity, System.currentTimeMillis().toInt(), intent2,0 )



            var callAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Call",pIntent).build()
            var settingAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Setting",pIntent1).build()
            var warningAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Warning",pIntent2).build()

            var builder = NotificationCompat.Builder(this@MainActivity)
            builder.setSmallIcon(R.drawable.ic_launcher_background)
            builder.setContentTitle("mail from egci428")
            builder.setContentText("here is notifications message")
            builder.addAction(callAction)
            builder.addAction(settingAction)
            builder.addAction(warningAction)
            builder.setWhen(System.currentTimeMillis()+10)

            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(0, builder.build())

        }
    }
}
