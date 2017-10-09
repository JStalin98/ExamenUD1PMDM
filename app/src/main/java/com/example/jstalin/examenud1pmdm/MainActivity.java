package com.example.jstalin.examenud1pmdm;

/*
Aplicacion que dado un numero entero positivo, te calcula su factorial
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements android.view.View.OnClickListener{

    // Variables privadas necesarias para el uso de la aplicacion
    private TextView resultado; // Variabla para mostrar resultado
    private  Button btCalcular; // Variable para dar funsion al boton
    private EditText numero; // Variable para obtener el numero introducido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Obtiene la interfaz del archivo xml

        //Obtenermos los compentes del activiti_main.xml mediante el id y los casteamos
        resultado = (TextView) findViewById(R.id.tvResultado);
        btCalcular = (Button)findViewById(R.id.btCalcular);
        numero = (EditText) findViewById(R.id.etNumero);
        btCalcular.setOnClickListener(this); // Ponemos el boton a la escucha


    }

    /*
    Metodo que calcula el factorial del numero introducido en el edit text
     */
    public long calcularFactorial(){
        long fac = 1;
        try {
            fac = Long.parseLong(numero.getText().toString()); // Obtenemos el numero del campo edit text

            //Inicializa el bucle al numero  que se ha introducido los castea a entero y resta uno
            /*
            El bucle lo que hace es ir restando 1 en cada vuelta el numero introducido por el usuario, y almacenando en una vairbale fac
            la multiplicacion del factorial de dicho numero
             */
            for(int i=(int)fac-1; i>0; i--){
                fac = i * fac;
            }
        } catch (NumberFormatException e) {
            resultado.setText("EL VALOR A INTRODUCIR DEBE SER UN NUMERO"); // Si produce excepcion en la conversion muestra mensaje en el campo resultado
        }


      return fac;
    }

    // Evento que se produce al pulsar el boton
    public void onClick(View v) {
        if(!numero.getText().toString().equals("")) { // Si no hay nada escrito no hace nada
            if(numero.getText().toString().equals("0")){ // Compara el numero con cero, dado qque el factorial de 0 es 1
                resultado.setText("1");
            }else if((Long.parseLong(numero.getText().toString())<0)){ // Verifica que el numero no sea negativo y muestra mensaje si lo es
                resultado.setText("No se puede calcular el factorial de un numero negativo");
            }else {
                resultado.setText(calcularFactorial() + ""); // Si no se cumplen las condiciones arriba, esque no hay prolemas y ejecuta el metodo calcularFactorial, que lo esciribimos en el cmapo resultado
            }
        }

    }


}

