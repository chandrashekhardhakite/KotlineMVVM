package com.chandra.kotlinemvvm.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Couroutines {




    fun main(work:suspend (()->Unit))= CoroutineScope(Dispatchers.Main).launch {
        work()
    }

    fun io(work:suspend (()->Unit))= CoroutineScope(Dispatchers.IO).launch {
        work()
    }
}