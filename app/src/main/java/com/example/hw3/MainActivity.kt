package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val stone = findViewById<RadioButton>(R.id.btn_stone)
        val papper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        btn_mora.setOnClickListener {
            if (ed_name.length()<1)
                tv_text.text = "請輸入玩家姓名"
            else{
                tv_name.text = "名字\n${ed_name.text}"

                tv_mmora.text = "我方出拳\n${if(scissor.isChecked) "剪刀"
                else if (stone.isChecked) "石頭"
                else
                    "布"}"

                var computer =(Math.random()*3).toInt()

                tv_cmora.text = "電腦出拳\n${if(computer==0) "剪刀"
                else if (computer==1)
                    "石頭"
                else
                    "布"}"

                when {
                    (scissor.isChecked && computer == 2 ||
                            stone.isChecked && computer == 0 ||
                            papper.isChecked && computer == 1 )-> {
                        tv_winner.text = "勝利者\n${ed_name.text}"
                        tv_text.text = "恭喜你win了"
                    }
                    (scissor.isChecked && computer == 1 ||
                            stone.isChecked && computer == 2 ||
                            papper.isChecked && computer == 0 )-> {
                        tv_winner.text = "勝利者\n電腦"
                        tv_text.text = "電腦win了廢物"
                    }
                    else -> {
                        tv_winner.text = "勝利者\n平手"
                        tv_text.text = "平局，再試一次!"
                    }
                }
            }
        }
    }
}