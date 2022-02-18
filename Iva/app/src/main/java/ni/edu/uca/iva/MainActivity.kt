package ni.edu.uca.iva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.iva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        ObtenerDatos()
        setContentView(binding.root)
    }

    private fun ObtenerDatos() = binding.buttonCalculate.setOnClickListener {
        val precio = ObtenerPrecio()
        binding.editTextIva.text = precio.iva.toString()
        binding.editTextNetPrecio.text = precio.netoTotal.toString()
    }

    private fun ObtenerPrecio(): Precio =
        Precio(binding.editTextPrecio.double)



}