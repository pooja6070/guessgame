package com.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.seconds

class MainActivity : AppCompatActivity() {
    lateinit var btnone: Button
    lateinit var btntwo: Button
    lateinit var totalscore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//get a random number
        val myrandom1 = Random.nextInt(10..100)
        val myrandom2 = Random.nextInt(10..100)

        btnone = findViewById(R.id.button1)
        btntwo = findViewById(R.id.button2)
        totalscore = findViewById(R.id.totalscore)
        btnone.text = "$myrandom1"
        btntwo.text = "$myrandom2"
        btnone.setOnClickListener {
            if (btntwo.text.toString() > btnone.text.toString())
                totalscore.setText("you are right")
            else (btntwo.text.toString() < btnone.text.toString())
                totalscore.setText("you are wrong !!")


        }
        btntwo.setOnClickListener {
            if (btnone.text.toString() < btntwo.text.toString())
                totalscore.setText("you are right")
            else (btnone.text.toString() > btntwo.text.toString())
                totalscore.setText("you are wrong !!")


        }


}

}