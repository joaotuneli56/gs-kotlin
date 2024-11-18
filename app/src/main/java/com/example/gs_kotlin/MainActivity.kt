import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gs_kotlin.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EcoDicasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        val adapter = EcoDicasAdapter { dica ->
            viewModel.removeDica(dica)
            Toast.makeText(this, "Dica removida: ${dica.titulo}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(EcoDicasViewModel::class.java)

        viewModel.dicasLiveData.observe(this) { dicas ->
            adapter.updateDicas(dicas)
        }

        button.setOnClickListener {
            val titulo = editText.text.toString()
            if (titulo.isBlank()) {
                editText.error = "Digite um título"
                return@setOnClickListener
            }

            viewModel.addDica(titulo, "Descrição padrão para $titulo")
            editText.text.clear()
        }
    }
}
