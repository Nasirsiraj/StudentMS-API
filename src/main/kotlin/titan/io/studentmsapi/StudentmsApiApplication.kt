package titan.io.studentmsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import titan.io.studentmsapi.model.Student

@SpringBootApplication
class StudentmsApiApplication

fun main(args: Array<String>) {
    runApplication<StudentmsApiApplication>(*args)
    println("Welcome to student management system api")
}
