package kr.lul.template.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.lul.template.model.SampleModel
import javax.inject.Inject
import kotlin.random.Random

@HiltAndroidApp
class TemplateApplication : Application() {
    companion object {
        private const val TAG = "TemplateApplication"
    }

    private val scope = CoroutineScope(SupervisorJob())

    @Inject
    lateinit var sampleModel: SampleModel

    override fun onCreate() {
        Log.i(TAG, "#onCreate called.")
        super.onCreate()

        scope.launch {
            for (i in 0..Random.nextInt(7, 19)) {
                sampleModel.create()
                delay(Random.nextLong(100L))
            }
            Log.d(TAG, "#onCreate : sampleModel=$sampleModel")
        }
    }
}