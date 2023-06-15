package kr.hs.emirim.tablelayouttest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnPlus : Button
    lateinit var btnMinus : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? =null
    var btns = ArrayList<Button>(initialCapacity = 10)
    var btnIds = arrayOf(R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dir5_5)
        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        textResult = findViewById(R.id.textResult)

        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)

        for(i in 0..btnIds.size-1 step 1){
            btns.add(findViewById(btnIds[i]))
        }
        for(i in 0..btnIds.size-1 step 1){
            btns[i].setOnClickListener{
                if(edit1.isFocused){
                    num1 = edit1.text.toString()+btns[i].text.toString()
                    edit1.setText(num1)
                }else if(edit1.isFocused){
                    num2 = edit2.text.toString()+btns[i].text.toString()
                    edit2.setText(num2)
                }else {
                    Toast.makeText(applicationContext, "먼저 입력 할 곳에 포커스를 주세요", Toast.LENGTH.SHORT).show()
                }
            }
        }
        var btnListener=OnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            when(it.id){
                R.id.btnPlus->result = num1.toInt()+num2.toInt()
                R.id.btnMinus->result = num1.toInt()-num2.toInt()
                R.id.btnMultiply->result = num1.toInt()*num2.toInt()
                R.id.btnDivide->result = num1.toInt()/num2.toInt()
            }
            textResult.setText(R.string.text_result)
            textResult.append(result.toString())
        }
    }
}