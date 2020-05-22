package common

interface ILogger {
    fun <T> log(message: String? = null, obj: T? = null)
}