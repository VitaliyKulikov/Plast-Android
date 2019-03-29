package com.bbook.app.models.network

import com.bbook.app.data.remote.base.ServerErrorResponse
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException

enum class ApiRequestStatus {
    RUNNING,
    SUCCESSFUL,
    FAILED
}

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
        val status: ApiRequestStatus,
        val commonError: CommonServerError? = null) {

    companion object {
        const val NO_INTERNET_CODE = "no_internet_code"
        const val UNKNOWN_ERROR = "unknown_error_code"
        const val BAD_REQUEST = "bad request"

        val LOADING = NetworkState(ApiRequestStatus.RUNNING)
        val SUCCESSFUL =
            NetworkState(ApiRequestStatus.SUCCESSFUL)

        fun error(msg: String?, title: String? = null, code: String? = null): NetworkState {
            val error = CommonServerError(
                code ?: UNKNOWN_ERROR, title ?: "error", msg
                    ?: "unknown error"
            )
            return NetworkState(
                ApiRequestStatus.FAILED,
                error
            )
        }

        fun error(t: Throwable?): NetworkState {
            return when (t) {
                is HttpException -> {
                    val errorBody = t.response()?.errorBody()
                    val serverError =
                        getCommonErrorFromResponse(errorBody)
                    NetworkState(
                        ApiRequestStatus.FAILED,
                        serverError
                    )
                }
                is IOException -> {
                    val serverError = CommonServerError(
                        NO_INTERNET_CODE,
                        "connection error",
                        "You do not have internet connection"
                    )
                    NetworkState(
                        ApiRequestStatus.FAILED,
                        serverError
                    )
                }
                else -> {
                    val serverError =
                        CommonServerError(UNKNOWN_ERROR, "error", "unknown error")
                    NetworkState(
                        ApiRequestStatus.FAILED,
                        serverError
                    )
                }
            }

        }

        fun error(errorBody: ResponseBody?): NetworkState {
            val serverError = getCommonErrorFromResponse(errorBody)
            return NetworkState(
                ApiRequestStatus.FAILED,
                serverError
            )
        }

        private fun getCommonErrorFromResponse(errorBody: ResponseBody?, alternateError: String? = null): CommonServerError? {
            return errorBody?.let {
                try {
                    val errorResponse = Gson().fromJson(errorBody.string(), ServerErrorResponse::class.java)
                    errorResponse?.serverError
                } catch (jse: JsonSyntaxException  ) {
                    jse.printStackTrace()
                    null
                } catch (jpe: JsonParseException){
                    jpe.printStackTrace()
                    null
                }
            } ?: CommonServerError(
                UNKNOWN_ERROR,
                "error",
                alternateError ?: "unknown error"
            )
        }
    }

}