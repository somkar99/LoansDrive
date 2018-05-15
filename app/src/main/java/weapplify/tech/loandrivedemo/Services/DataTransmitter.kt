package weapplify.tech.loandrivedemo.Services

import android.content.Context

/**
 * Created by nehagulati on 9/14/17.
 */

class DataTransmitter {
    lateinit var context: Context

    fun setUrl(url: String) {
        Url = url
    }

    fun setPOST(value: Boolean?) {
        if (value == true) {
            POST = 1
        }
    }

    fun sendRequest(context: Context) {
        this.context = context


    }

    companion object {
        var Url = ""
        var POST: Int = 0
        var GET = 0
    }


}
