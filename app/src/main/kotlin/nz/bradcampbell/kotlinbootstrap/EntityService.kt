package nz.bradcampbell.kotlinbootstrap

import rx.Observable
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class EntityService @Inject constructor() {
    fun loadEntity() : Observable<Entity> {
        return Observable.just(Entity("Test"))
                .delay(1500, TimeUnit.MILLISECONDS, Schedulers.io())
    }
}
