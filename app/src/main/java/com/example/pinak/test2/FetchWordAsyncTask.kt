package com.example.pinak.test2

import android.content.Context
import android.os.AsyncTask

/**
 * Created by SR4PXM on 6/26/2017.
 */
class FetchWordAsyncTask: AsyncTask<String, String, String>() {

    var mCallBack: WordCallBackListener<String>? = null
    var mContext: Context? = null
    var mException: Exception? = null
    init {
        this.mCallBack = mCallBack
        this.mContext = mContext
    }



    override fun doInBackground(vararg p0: String?): String {
        try {
            //need to implement something
        }catch (e: Exception){
            mException = e
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(result: String?)  {
        //super.onPostExecute(result)
        if(mCallBack != null &&  result != null){
            if (mException == null) {
                (mCallBack as WordCallBackListener<String>).onSuccess(result)
            } else (mCallBack as WordCallBackListener<String>).onFailure(mException as Exception)
        }
    }
}

