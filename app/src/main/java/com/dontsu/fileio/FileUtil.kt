package com.dontsu.fileio

import java.io.*

class FileUtil {

    fun readTextFile(fullPath: String): String {
        val file = File(fullPath)
        if (!file.exists()) return "해당 파일이 없습니다."

        //Reader 종류는 txt를 읽어들인다
        val reader = FileReader(file)
        val buffer = BufferedReader(reader)
        var temp: String?
        var result = ""
        while (true) {
            temp = buffer.readLine()
            if (temp == null) break
            else result += temp + "\n"
        }
        buffer.close()
        reader.close()
        return result
    }

    fun writeTextFile(directory: String, filename: String, content: String) {
        //파일 경로 체크, 이러한 경로를 찾고자 한다.
        val dir = File(directory)
        if (!dir.exists()) { //경로가 없다면?
            dir.mkdirs() // 해당 경로까지의 디렉토리를 만들 것.
        }

        val writer = FileWriter("$directory/$filename")
        val buffer = BufferedWriter(writer)
        buffer.write(content)
        buffer.close()
        writer.close()
    }
}
