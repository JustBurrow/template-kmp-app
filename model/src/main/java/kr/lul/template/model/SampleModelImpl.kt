package kr.lul.template.model

import android.util.Log
import kr.lul.template.domain.SampleData
import javax.inject.Inject

class SampleModelImpl @Inject constructor() : SampleModel {
    companion object {
        private const val TAG = "SampleModelImpl"
    }

    private val list = mutableListOf<SampleData>()

    override suspend fun create(): SampleData {
        val data = SampleData(list.size + 1)
        list.add(data)
        list.sort()
        Log.d(TAG, "#create return : $data")
        return data
    }

    override suspend fun read(id: Int): SampleData? {
        val data = list.find { it.id == id }
        Log.d(TAG, "#read : $id => $data")
        return data
    }

    override suspend fun list(): List<SampleData> {
        val list = this.list.toList()
        Log.d(TAG, "#list return : $list")
        return list
    }

    override fun toString() = "$TAG(list=$list)"
}