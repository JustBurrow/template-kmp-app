package kr.lul.template.model

import kr.lul.template.domain.SampleData

interface SampleModel {
    suspend fun create(): SampleData

    suspend fun read(id: Int): SampleData?

    suspend fun list(): List<SampleData>
}