package com.aplikasi.pintarit

object Constants {
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "Gambar di atas merupakan logo dari bahasa pemrograman?",
            R.drawable.logo_cpp, "Java",
            "Python",
            "C++",
            "Ruby",
            3)

        questionsList.add(q1)

        val q2 = Question(
            2,
            "Gambar di atas merupakan logo dari bahasa pemrograman?",
            R.drawable.logo_python, "Java",
            "Python",
            "C++",
            "Ruby",
            2)

        questionsList.add(q2)

        val q3 = Question(
            3,
            "Gambar di atas merupakan logo dari bahasa pemrograman?",
            R.drawable.logo_kotlin, "Java",
            "Python",
            "C++",
            "Kotlin",
            4)

        questionsList.add(q3)

        val q4 = Question(
            4,
            "Gambar di atas merupakan logo dari bahasa pemrograman?",
            R.drawable.logo_java, "Java",
            "Python",
            "C++",
            "Kotlin",
            1)

        questionsList.add(q4)

        val q5 = Question(
            5,
            "Hasil output dari kode c++ di atas adalah?",
            R.drawable.code_cpp, "Hello, Username!",
            "Hello, World",
            "Hello,Username!",
            "Username, Hello!",
            1)

        questionsList.add(q5)

        val q6 = Question(
            6,
            "Hasil output dari kode c++ di atas adalah?",
            R.drawable.code_cpp, "Hello, UserHello, World!",
            "Hello, User! Hello, World!",
            "Hello User World!",
            "User Hello World!!",
            2)

        val q7 = Question(
            7,
            "",
            R.drawable.komen_cpp, "/?",
            "//",
            "##",
            "$$",
            2)
        questionsList.add(q7)

        val q8 = Question(
            8,
            "",
            R.drawable.komen_kotlin, "^^",
            "##",
            "//",
            "??",
            3)
        questionsList.add(q8)

        val q9 = Question(
            9,
            "",
            R.drawable.komen_python, "::",
            "//",
            "**",
            "#",
            4)
        questionsList.add(q9)

        val q10 = Question(
            10,
            "",
            R.drawable.bahasa_apa_yang_buat_aplikasi_android, "Python",
            "Java",
            "Kotlin",
            "C",
            3)
        questionsList.add(q10)

        return questionsList
    }

}