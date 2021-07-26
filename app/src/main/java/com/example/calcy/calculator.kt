package com.example.calcy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

lateinit var displayVal: TextView
lateinit var displayRes:TextView
var data= arrayListOf<String>()

class calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        var expr:String=""
        var n1:Button=findViewById(R.id.number1)
        var n2:Button=findViewById(R.id.number2)
        var n3:Button=findViewById(R.id.number3)
        var n4:Button=findViewById(R.id.number4)
        var n5:Button=findViewById(R.id.number5)
        var n6:Button=findViewById(R.id.number6)
        var n7:Button=findViewById(R.id.number7)
        var n8:Button=findViewById(R.id.number8)
        var n9:Button=findViewById(R.id.number9)
        var n0:Button=findViewById(R.id.number0)
        var ndot:Button=findViewById(R.id.numberdot)
        var tvAdd:Button=findViewById(R.id.tvAdd)
        var tvSub:Button=findViewById(R.id.tvSub)
        var tvMul:Button=findViewById(R.id.tvMul)
        var tvDiv:Button=findViewById(R.id.tvDiv)
        var clr:Button =findViewById(R.id.tvCan)
        var opbrac:Button=findViewById(R.id.tvopbracket)
        var clbrac:Button=findViewById(R.id.tvclosebracket)
        var del:Button=findViewById(R.id.number_del)
        var eval:Button=findViewById(R.id.tvEqual)
        displayVal=findViewById(R.id.input_expression)
        displayRes=findViewById(R.id.answer)

        n1.setOnClickListener(){ expr=appendVal("1",expr) }
        n2.setOnClickListener(){ expr=appendVal("2",expr) }
        n3.setOnClickListener(){ expr=appendVal("3",expr) }
        n4.setOnClickListener(){ expr=appendVal("4",expr) }
        n5.setOnClickListener(){ expr=appendVal("5",expr) }
        n6.setOnClickListener(){ expr=appendVal("6",expr) }
        n7.setOnClickListener(){ expr=appendVal("7",expr) }
        n8.setOnClickListener(){ expr=appendVal("8",expr) }
        n9.setOnClickListener(){ expr=appendVal("9",expr) }
        n0.setOnClickListener(){ expr=appendVal("0",expr) }
        ndot.setOnClickListener(){ expr=appendVal(".",expr) }
        opbrac.setOnClickListener(){ expr=appendVal("(",expr) }
        clbrac.setOnClickListener(){ expr=appendVal(")",expr) }
        tvAdd.setOnClickListener(){ expr=appendVal("+",expr) }
        tvSub.setOnClickListener(){ expr=appendVal("-",expr) }
        tvMul.setOnClickListener(){ expr=appendVal("*",expr) }
        tvDiv.setOnClickListener(){ expr=appendVal("/",expr) }
        del.setOnClickListener(){ if(expr.isNotEmpty()){
            expr=expr.dropLast(1)
            displayVal.setText(expr)
        } }
        clr.setOnClickListener(){
            expr=""
            displayRes.setText(R.string.zero)
            displayVal.setText(R.string.zero)}
        eval.setOnClickListener(){ evalExpr(expr)
            data.add(displayVal.text.toString()+"="+ displayRes.text.toString())}





    }

    private fun evalExpr(expr: String) {
        try {
            val exprsion = ExpressionBuilder(expr).build()
            val result = exprsion.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                displayRes.setText(longResult.toString())
            else
                displayRes.setText(result.toString())
        }
        catch (e:Exception){
            displayRes.setText(R.string.syntax_error)
        }


    }

    fun appendVal(s: String,expr: String): String {
        var tempexpr =expr + s
        displayVal.setText(tempexpr)
        return tempexpr
    }

    fun history(view: View) {
        val intent = Intent(this,History::class.java).apply {
            intent.putExtra("userHistory",data)
        }
        startActivity(intent)
    }


}

