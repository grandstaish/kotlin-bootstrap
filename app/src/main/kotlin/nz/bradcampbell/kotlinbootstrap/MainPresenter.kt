package nz.bradcampbell.kotlinbootstrap

import rx.Subscription
import javax.inject.Inject

class MainPresenter @Inject constructor(var model : MainModel) {
    private var subscription : Subscription? = null
    var view : MainView? = null

    fun loadEntity() {
        if (subscription == null || subscription!!.isUnsubscribed) {
            subscription = model.loadEntity().subscribe {
                entity -> view?.displayEntity(entity)
            }
        }
    }
}
