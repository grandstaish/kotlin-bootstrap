package nz.bradcampbell.kotlinbootstrap

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainModel @Inject constructor() {
    fun loadEntity(): Entity {
        return Entity("test")
    }
}
