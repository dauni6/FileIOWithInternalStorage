package com.dontsu.fileio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
/**
 * 준비물 : 파일경로, 파일이름, 내용
 * 쓸때는 파일경로, 파일이름, 그리고 내용이 필요하며
 * 읽을때는 파일경로와 파일이름만 있으면 된다.
 * */
class MainActivity : AppCompatActivity() {

    init {
        //timber initialize
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dirPath = filesDir.absolutePath //절대경로
        val filename = "SummerSongList.txt"
        val fileUtil = FileUtil()

        writeBtn.setOnClickListener{
            val content = inputET.text.toString()
            if (content.isNotEmpty()) {
                Timber.d("---메인 : dirPath = $dirPath")
                fileUtil.writeTextFile(dirPath, filename, content)
            } else {
                Toast.makeText(this@MainActivity, "적어도 한 글자를 입력해야됩니다.", Toast.LENGTH_SHORT).show()
            }
        }

        readBtn.setOnClickListener {
            val fullPath = "$dirPath/$filename"
            Timber.d("---메인 : fullPath = $fullPath")
            val content = fileUtil.readTextFile(fullPath)
            outputET.text = content

        }
    }

}
