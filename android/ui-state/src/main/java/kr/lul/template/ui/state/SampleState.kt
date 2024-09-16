package kr.lul.template.ui.state

import androidx.compose.runtime.Immutable
import kr.lul.version.Version
import java.time.Instant
import java.util.UUID

@Immutable
data class SampleState(
    val id: Int,
    val uuid: UUID,
    val version: Version,
    val createdAt: Instant
)
