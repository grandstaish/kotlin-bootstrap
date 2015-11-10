package nz.bradcampbell.kotlinbootstrap

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

class MainFragment : Fragment(), MainView {
    @Inject lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        val app = activity.application as App
        val component : AppComponent = app.getAppComponent()
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.loadEntity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.view = null
    }

    override fun displayEntity(entity: Entity) {
        Log.d("MainFragment", entity.title)
    }
}
