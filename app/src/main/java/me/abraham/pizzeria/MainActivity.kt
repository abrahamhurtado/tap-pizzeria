package me.abraham.pizzeria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sizeRadioGroup.setOnCheckedChangeListener { group, checkedId -> calculateTotal() }

        deliveryRadioGroup.setOnCheckedChangeListener { group, checkedId -> calculateTotal()  }

        val clickListener = View.OnClickListener { calculateTotal() }

        queso.setOnClickListener(clickListener)
        champinones.setOnClickListener(clickListener)
        aceitunas.setOnClickListener(clickListener)
        cebollas.setOnClickListener(clickListener)
        anchoas.setOnClickListener(clickListener)
        pimienta.setOnClickListener(clickListener)
        tomate.setOnClickListener(clickListener)
        pepperoni.setOnClickListener(clickListener)
        jamon.setOnClickListener(clickListener)

        calculateTotal()
    }



    private fun calculateTotal() {
        var total = 0.0
        // Primero checamos el tamaño
        val sizeRadio = findViewById<RadioButton>(sizeRadioGroup.checkedRadioButtonId)
        total += (sizeRadio.tag as String).toDouble()

        // Forma de entrega
        val deliveryRadioButton = findViewById<RadioButton>(deliveryRadioGroup.checkedRadioButtonId)
        total += (deliveryRadioButton.tag as String).toDouble()

        // Checamos cada una de las opciones
        total += if (queso.isChecked) (queso.tag as String).toDouble() else 0.0
        total += if (champinones.isChecked) (champinones.tag as String).toDouble() else 0.0
        total += if (aceitunas.isChecked) (aceitunas.tag as String).toDouble() else 0.0
        total += if (cebollas.isChecked) (cebollas.tag as String).toDouble() else 0.0
        total += if (anchoas.isChecked) (anchoas.tag as String).toDouble() else 0.0
        total += if (pimienta.isChecked) (pimienta.tag as String).toDouble() else 0.0
        total += if (tomate.isChecked) (tomate.tag as String).toDouble() else 0.0
        total += if (pepperoni.isChecked) (pepperoni.tag as String).toDouble() else 0.0
        total += if (jamon.isChecked) (jamon.tag as String).toDouble() else 0.0

        // Mostramos el total con formato de moneda
        totalTextView.text = NumberFormat.getCurrencyInstance().format(total)
    }
}
