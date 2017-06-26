package com.example.pinak.test2
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

/**
 * Created by SR4PXM on 6/26/2017.
 */
interface WordCallBackListener <T> {

    fun onSuccess(`object`: T)
    fun onFailure(e: Exception)
}