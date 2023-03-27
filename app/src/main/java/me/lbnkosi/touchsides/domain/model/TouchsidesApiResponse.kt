package me.lbnkosi.touchsides.domain.model

data class TouchsidesApiResponse(
    var result: Result? = Result(),
    var success: Success? = Success(),
    var error: Error? = Error(),
    var status: String? = ""
)