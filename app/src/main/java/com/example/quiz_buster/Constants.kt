import com.example.quiz_buster.Question
import com.example.quiz_buster.R
import java.util.*

object Constants {
    const val USERNAME: String = "username"
    const val TOTAL_NUMBER_OF_QUESTIONS: String = "totalNumberOfQuestions"
    const val CORRECT_ANSWERS: String = "correctAnswers"
    const val SKIPPED_ANSWERS: String = "skippedAnswers"
    fun getQuestions(): ArrayList<Question> {
        val questions = ArrayList<Question>()

        var options = ArrayList<String>()

//        Adding 1st Question
        options.add("Public method is accessible to all other classes in the hierarchy")
        options.add("Public method is accessible only to subclasses of its parent class")
        options.add("Public method can only be called by object of its class")
        options.add("Public method can be accessed by calling object of the public class")

        var question = Question(
            1,
            "Which of the statement is correct?",
            true,
            R.drawable.ques2,
            options,
            1
        )

        questions.add(question)

//        Adding 2nd Question
        options = ArrayList<String>()
        options.add("9")
        options.add("8")
        options.add("Compilation Error")
        options.add("Runtime Error")
        question = Question(2,
            "What will be the output of the following Java program?",
            true,
            R.drawable.ques2,
            options,
            3
        )
        questions.add(question)

//        Adding 3rd Question
        options = ArrayList<String>()
        options.add("this")
        options.add("super")
        options.add("extends")
        options.add("final")
        question = Question(2,
            "Which of this keyword can be used in a subclass to call the constructor of superclass?",
            false,
            0,
            options,
            2
        )
        questions.add(question)

//        Adding 4th Question
        options = ArrayList<String>()
        options.add("Method Overloading")
        options.add("Method Hiding")
        options.add("Method Overriding")
        options.add("None of the Above")
        question = Question(2,
            "What is the process of defining a method in a subclass having same name & type signature as a method in its superclass?",
            false,
            0,
            options,
            3
        )
        questions.add(question)

//        Adding 5th Question
        options = ArrayList<String>()
        options.add("2")
        options.add("Compilation Error")
        options.add("3")
        options.add("7")
        question = Question(2,
            "What will be the output of the following Java program?",
            true,
            R.drawable.ques5,
            options,
            4
        )
        questions.add(question)

//        Adding 6th Question
        options = ArrayList<String>()
        options.add("abstract")
        options.add("extends")
        options.add("abstract and extends")
        options.add("None of the Above")
        question = Question(2,
            "Which of these keywords cannot be used for a class which has been declared final?",
            false,
            0,
            options,
            1
        )
        questions.add(question)

//        Adding 7th Question
        options = ArrayList<String>()
        options.add("0")
        options.add("Value less than 0")
        options.add("Value greater than 0")
        options.add("compareTo() returns boolean")
        question = Question(2,
            "What is the value returned by function compareTo() if the invoking string is less than the string compared?",
            false,
            0,
            options,
            2
        )
        questions.add(question)

//        Adding 8th Question
        options = ArrayList<String>()
        options.add("2 2")
        options.add("Compilation Error")
        options.add("3 3")
        options.add("Runtime Error")
        question = Question(2,
            "What will be the output of the following Java code?",
            true,
            R.drawable.ques8,
            options,
            2
        )
        questions.add(question)

//        Adding 9th Question
        options = ArrayList<String>()
        options.add("Byte")
        options.add("String")
        options.add("Array")
        options.add("Class")
        question = Question(2,
            "Which of these classes is not included in java.lang?",
            false,
            0,
            options,
            3
        )
        questions.add(question)

//        Adding 10th Question
        options = ArrayList<String>()
        options.add("File")
        options.add("Writer")
        options.add("InputStream")
        options.add("Reader")
        question = Question(10,
            "Which of these class is not related to input and output stream in terms of functioning?",
            false,
            0,
            options,
            1
        )
        questions.add(question)

        return questions
    }
}