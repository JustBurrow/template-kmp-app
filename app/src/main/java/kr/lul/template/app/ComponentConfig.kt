package kr.lul.template.app

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.lul.template.model.SampleModel
import kr.lul.template.model.SampleModelImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ComponentConfig {
    companion object {
        private const val TAG = "ComponentConfig"
    }

    @Provides
    @Singleton
    fun provideSampleModel(): SampleModel {
        val model = SampleModelImpl()
        Log.d(TAG, "#provideSampleModel return : $model")
        return model
    }
}