package nz.bradcampbell.kotlinbootstrap

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface  AppComponent {
    fun inject(mainFragment: MainFragment)
}
