package com.example.pinak.test2

import android.provider.BaseColumns

/**
 * Created by SR4PXM on 7/10/2017.
 */
object MeaningContract {

    class Meanings : BaseColumns {
        companion object {

            const val WORD = "word"
            const val  POS = "pos"
            const val IPA = "ipa"
            const val DEFINITION = "definition"
            const val EXAMPLE = "example"
            const val G_EXAMPLE = "g_example"
            const val PATTERN = "pattern"
            const val UK_AUDIO = "ukaudio"
            const val US_AUDIO = "usaudio"

        }
    }

}