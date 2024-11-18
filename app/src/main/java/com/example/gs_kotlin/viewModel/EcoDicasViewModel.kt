import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class EcoDicasViewModel(application: Application) : AndroidViewModel(application) {

    private val _dicasLiveData = MutableLiveData<List<Dica>>()
    val dicasLiveData: LiveData<List<Dica>> = _dicasLiveData

    private val dicas = mutableListOf<Dica>()

    fun addDica(titulo: String, descricao: String) {
        dicas.add(Dica(titulo, descricao))
        _dicasLiveData.value = dicas
    }

    fun removeDica(dica: Dica) {
        dicas.remove(dica)
        _dicasLiveData.value = dicas
    }
}
