package weapplify.tech.loandrivedemo.Upgrade

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.Environment

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

/*
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
*/
/*
@ReportsCrashes(
        mailTo = "Harsha.Gulati@weapplify.tech",
        mode = ReportingInteractionMode.DIALOG,
        resToastText = R.string.crash_toast_text,
        resDialogText = R.string.crash_dialog_text,
        resDialogIcon = android.R.drawable.ic_dialog_info,
        resDialogTitle = R.string.crash_dialog_title,
        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt,
        resDialogOkToast = R.string.crash_dialog_ok_toast)*/

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //     ACRA.init(this);
    }

    companion object {
        internal var TAG = "App"
        internal var myApp: App? = null

        val IMPORT_DB = "import db"
        val EXPORT_DB = "export db"

        val FROM = "FROM"
        var dbName = "loandrive.db"
        var userID = ""
        var DISPLAY_DATE = ""
        var DATE = ""
        var id = ""
        var imageURL = "http://www.weapplify.tech/bmw/UploadMultipleFiles.php"
        var sqlurl = "http://www.weapplify.tech/bmw/SQLOperation.php"
        var dataURL = "http://www.weapplify.tech/bmw/GetResults.php"

      lateinit  var calendar: Calendar
        var appName = "loandrive"

        var imageDir = Environment.getExternalStorageDirectory().toString() + "/" + App.appName + "/Images"

        var RESULT_CODE_WIFI = 100

        var PARTICIPANTS = "Participants"
        var MyPreferences = "MyAddress"

        val instance: App
            get() {
                if (myApp == null) {
                    myApp = App()
                }
                return myApp!!
            }

        var appData: Bundle
            get() = Bundle()
            set(b) {

            }


        //In which you need put here
        var date: String
            get() {
                calendar = Calendar.getInstance()

                if (DATE === "") {
                    val today = calendar.time
                    val myFormat = "dd/MM/yyyy"
                    val sdf = SimpleDateFormat(myFormat)
                    DATE = sdf.format(today)

                }

                return DATE
            }
            set(lsDate) {
                DATE = lsDate
            }

        //In which you need put here
        var displayDate: String
            get() {
                calendar = Calendar.getInstance()

                if (DISPLAY_DATE === "") {
                    val today = calendar.time
                    val myFormat = "dd-MMM"
                    val sdf = SimpleDateFormat(myFormat)
                    DATE = sdf.format(today)

                }

                return DATE
            }
            set(lsDate) {
                DATE = lsDate
            }


        val currentTimeStamp: String
            get() {
                val tsLong = System.currentTimeMillis() / 1000
                return tsLong.toString()
            }

        val context: Context
            get() = context

        fun uploadOKImage(sourceFile: String, llProductId: Long, llImageId: Long) {


            /* OkHttpClient client = new OkHttpClient();
        File file = new File(App.getImageDir() + "/" + sourceFile);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("ClientCode", "")
                .addFormDataPart("uploadedfile", App.getImageDir() + "/" + sourceFile,
                        RequestBody.create(MediaType.parse("image/png"), file))
                //RequestBody.create(MediaType.parse("image/png"), file))
                .build();

        Request request = new Request.Builder()
                .url(App.getImageURL())
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.v(TAG, "Image Upload Error " + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String in = response.body().string();
                Log.v(TAG, "PHP Response " + in);
                if (response.code() == 200) {
                    //mProduct.updatePMUploaded(llProductId, true);
                    //imageFiles.updateImageUpload(llImageId, true);
                    //callImageSql(llProductId);
                }
            }
        });
*/
        }
    }
}