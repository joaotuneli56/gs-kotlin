import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gs_kotlin.R

class EcoDicasAdapter(private val onItemClick: (Dica) -> Unit) :
    RecyclerView.Adapter<EcoDicasAdapter.DicaViewHolder>() {

    private val dicas = mutableListOf<Dica>()

    inner class DicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val descricao: TextView = itemView.findViewById(R.id.tvDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dica, parent, false)
        return DicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.titulo.text = dica.titulo
        holder.descricao.text = dica.descricao
        holder.itemView.setOnClickListener { onItemClick(dica) }
    }

    override fun getItemCount(): Int = dicas.size

    fun updateDicas(newDicas: List<Dica>) {
        dicas.clear()
        dicas.addAll(newDicas)
        notifyDataSetChanged()
    }
}
