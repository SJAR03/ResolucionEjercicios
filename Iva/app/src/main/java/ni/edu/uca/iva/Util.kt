package ni.edu.uca.iva

import android.widget.EditText

val EditText.double : Double get() = text.toString().toDouble()