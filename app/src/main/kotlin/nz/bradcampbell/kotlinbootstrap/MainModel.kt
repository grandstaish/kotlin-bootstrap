package nz.bradcampbell.kotlinbootstrap

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainModel @Inject constructor(var service : EntityService) {
    var cache: Entity? = null

    fun loadEntity(): Observable<Entity> {
        return Observable.concat(memory(), network())
                .first { entity -> entity != null }
    }

    private fun network(): Observable<Entity> {
        return service.loadEntity()
                .doOnNext { cache = it }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun memory(): Observable<Entity> {
        return Observable.just(cache)
    }
}
