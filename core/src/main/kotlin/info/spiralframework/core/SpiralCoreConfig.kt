package info.spiralframework.core

import com.fasterxml.jackson.annotation.JsonProperty

open class SpiralCoreConfig(
        @JsonProperty("update_connect_timeout") val updateConnectTimeout: Int?,
        @JsonProperty("update_read_timeout") val updateReadTimeout: Int?
)