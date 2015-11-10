package nz.bradcampbell.kotlinbootstrap

import javax.inject.Inject

class MainPresenter @Inject constructor(var model : MainModel) {
    var view : MainView? = null

    fun loadEntity() {
        view?.displayEntity(model.loadEntity())
    }
}
