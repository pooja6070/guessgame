package com.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
     var count = 0
    var right: Int? = 1
    var wrong: Int? = 1
    lateinit var btnone: Button
    lateinit var btntwo: Button
    lateinit var totalscore: TextView
    lateinit var totalscore2: TextView
    lateinit var rightans: TextView
    lateinit var wrongans: TextView
    lateinit var resetgame: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//get a random number app open
        val myrandom1 = Random.nextInt(10..100)
        val myrandom2 = Random.nextInt(10..100)


        btnone = findViewById(R.id.button1)
        btntwo = findViewById(R.id.button2)
        totalscore = findViewById(R.id.totalscore)
        totalscore2 = findViewById(R.id.totalscore2)
        rightans = findViewById(R.id.rightans)
        wrongans = findViewById(R.id.wrongans)
        resetgame = findViewById(R.id.resetgame)
        btnone.text = "$myrandom1"
        btntwo.text = "$myrandom2"
        totalscore.text = "Invlaid!!"
        rightans.text = "Total Right:0"
        wrongans.text = "Total Wrong:0"

        resetgame.setOnClickListener {
            gameresetdone()

            val a = Random.nextInt(10..100)
            val b = Random.nextInt(10..100)
            btntwo.text = ("$a")
            btnone.text = ("$b")
            rightans.text = "Total Right:0"
            wrongans.text = "Total Wrong:0"
            count = 0
            right = 0
            wrong = 0
            totalscore.text = "Invlaid!!"
            totalscore2.setText("Total click is: $count")
        }

        btnone.setOnClickListener {

            if (count == 10)
                basicAlert()
            else
            {
                val a = Random.nextInt(10..100)
                val b = Random.nextInt(10..100)
                count++

                if (btntwo.text.toString() <= btnone.text.toString())
                {
                    totalscore.setText("Correct!!")
                   val r = right?.plus(1)
                    rightans.text = "Total Right:" + (right)
                    right = (r)
                }

                else if (btntwo.text.toString() > btnone.text.toString())
                {
                    totalscore.setText("Wrong!!")
                    val w = wrong?.plus(1)
                    wrongans.text = "Total Wrong:" + (wrong)
                    wrong = (w)

                }
                totalscore2.setText("Total Click is: $count")
                btntwo.text = ("$a")
                btnone.text = ("$b")
            }



        }
        btntwo.setOnClickListener {
            if (count == 10)
                basicAlert()
            else {
                val a = Random.nextInt(10..100)
                val b = Random.nextInt(10..100)
                count++
                if (btnone.text.toString() <= btntwo.text.toString())

                {
                    totalscore.setText("Correct!!")
                   val r = right?.plus(1)
                    rightans.text = "Total Right:" + (right)
                    right = (r)


                }

               else if (btnone.text.toString() > btntwo.text.toString())
                {
                    totalscore.setText("Wrong!!")
                    val w = wrong?.plus(1)
                    wrongans.text = "Total Wrong:" + (wrong)
                    wrong = (w)
                }

                totalscore2.setText("Total Click is: $count")
                btntwo.text = ("$a")
                btnone.text = ("$b")
            }
        }

    }
    fun basicAlert() {
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("You Can't Play more Game Please Reset Game")
            setMessage("Total Click: $count ${rightans.text} ${wrongans.text}")
            show()
        }
    }
    fun gameresetdone() {
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("Game Reset Sucess!!")
            setMessage("Now you can Play New Game.")
            show()
        }
    }


}
