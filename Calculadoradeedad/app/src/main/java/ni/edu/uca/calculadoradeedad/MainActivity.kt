package ni.edu.uca.calculadoradeedad

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var añoActual: Int = 0
    var añoActualMes: Int = 0
    var añoActualDia: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var texto1: TextView = findViewById<TextView>(R.id.fechaActual)
        var texto2: TextView = findViewById<TextView>(R.id.fechaNac)
        var texto3: TextView = findViewById<TextView>(R.id.edad)
        var boton: Button = findViewById<Button>(R.id.calcularEdad)
        var imagen: ImageView = findViewById<ImageView>(R.id.imagen)

        fechaActual(texto1)
        datePicker(texto2, boton, texto3, imagen)

    }

    private fun fechaActual(texto1: TextView){
        var formatoCompleto =  SimpleDateFormat("dd/MM/yyyy")

        var formatoAño = SimpleDateFormat("yyyy")
        var formatoMes = SimpleDateFormat("MM")
        var formatoDia = SimpleDateFormat("dd")

        var fechaActualCompleta = formatoCompleto.format(Date())

        var fechaActualAño = formatoAño.format(Date())
        var fechaActualMes = formatoMes.format(Date())
        var fechaActualDia = formatoDia.format(Date())

        texto1.text = "La fecha actual es $fechaActualCompleta"

        añoActual = Integer.parseInt(fechaActualAño)
        añoActualMes = Integer.parseInt(fechaActualMes)
        añoActualDia = Integer.parseInt(fechaActualDia)
    }

    fun datePicker(texto2: TextView, boton: Button, texto3: TextView, imagen: ImageView){

        var c = Calendar.getInstance()
        var año = c.get(Calendar.YEAR)
        var mes = c.get(Calendar.MONTH)
        var dia = c.get(Calendar.DAY_OF_MONTH)

        boton.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener {
                        datePicker, año, mes, dia -> texto2.text = "Naciste el $dia/${mes+1}/$año"
                var resultadoAño: Int = añoActual - año
                    var resultadoMesActualDias: Int = (añoActualMes * 30) + (añoActualDia)
                    var resultadoMesCumpleDias: Int = (mes * 30) + dia + 30

                    var resultadoFinalDias = resultadoMesActualDias - resultadoMesCumpleDias

                    var diasTotalActuales: Int = ((añoActual * 12) * 30) + (añoActualMes * 30) + (añoActualDia)
                    var diasTotalCumple: Int = ((año * 12) * 30) + (mes * 30) + (dia)

                    if (resultadoAño < 18){
                        texto3.text = "Tienes $resultadoAño, eres menor de edad"
                        imagen.setImageResource(R.drawable.juguete)
                    } else{
                        texto3.text = "Tienes $resultadoAño, eres mayor de edad"
                        imagen.setImageResource(R.drawable.factura)
                    }


                }, año, mes, dia)
            datePickerDialog.show()
        }
    }


}