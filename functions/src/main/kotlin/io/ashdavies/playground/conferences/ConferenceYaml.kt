package io.ashdavies.playground.conferences

import io.ashdavies.playground.database.Conference
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ConferenceYaml(
    @SerialName("name") val name: String,
    @SerialName("website") val website: String,
    @SerialName("location") val location: String,
    @SerialName("online") val online: Boolean? = false,
    @SerialName("status") val status: String? = null,
    @SerialName("date_start") val dateStart: String,
    @SerialName("date_end") val dateEnd: String,
    @SerialName("cfp") val cfp: Cfp? = null,
) {

    @Serializable
    data class Cfp(
        @SerialName("start") val start: String,
        @SerialName("end") val end: String,
        @SerialName("site") val site: String? = null,
    )
}

internal fun ConferenceYaml.toConference(id: String) = Conference(
    cfpSite = cfp?.site ?: website,
    cfpStart = cfp?.start,
    dateStart = dateStart,
    location = location,
    cfpEnd = cfp?.end,
    dateEnd = dateEnd,
    website = website,
    online = online,
    status = status,
    name = name,
    id = id,
)