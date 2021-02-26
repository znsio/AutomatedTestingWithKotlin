import Log.Log
import Log.Log.i

object Logger {
    private lateinit var logRepo: LogRepository

    fun i(tag: String, msg: String, tr: Throwable? = null): Int  {
        insertIntoLogDatabase(createLogModel("i", tag, msg, tr))
        return if (BuildConfig.DEBUG) Log.i(tag, msg, tr) else 0
    }

    private fun insertIntoLogDatabase(log: LogModel) {
        //Insert into Log DB
        logRepo.upsert(log)
    }

    private fun createLogModel(type: String, tag: String, msg: String, tr: Throwable?) =
        LogModel(0, type, tag, msg, if (tr != null) tr.message + "\n" + tr?.stackTrace.contentToString() else null)

    fun setLogRepo(logRepo: LogRepository) {
        this.logRepo = logRepo
    }
}