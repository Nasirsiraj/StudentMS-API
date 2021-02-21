package titan.io.studentmsapi.controller

import lombok.extern.slf4j.Slf4j
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import titan.io.studentmsapi.model.Student
import titan.io.studentmsapi.service.StudentService

@Slf4j
@RestController
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
class StudentController {
    @Autowired
    lateinit var studentService: StudentService

    // get all student
    @GetMapping("/students")
    fun getAllStudent(): MutableList<Student> {
        return studentService.getAllStudent()
    }
    // get student by id
    @GetMapping("/student/{id}")
    fun getStudentById(@PathVariable id: Int): Student?{
        return studentService.getStudentById(id)
    }
    // get student by roll
    @GetMapping("studentByRoll/{roll}")
    fun getStudentByRoll(@PathVariable @NotNull roll: Int): Student?{
        return studentService.getStudentByRoll(roll)
    }
    // get student by reg
    @GetMapping("/studentByReg/{reg}")
    fun getStudentByReg(@PathVariable @NotNull reg: Int): Student?{
        return studentService.getStudentByReg(reg)
    }
    // post all student
    @PostMapping("/students")
    fun postAllStudent(@RequestBody students: MutableList<Student>): MutableList<Student>{
        return studentService.postAllStudent(students)
    }
    // post one student
    @PostMapping("/student")
    fun postOneStudent(@RequestBody student:Student): Student{
        return studentService.postStudent(student)
    }
    // delete student by id
    @DeleteMapping("/student/{id}")
    fun deleteStudentById(@PathVariable id: Int): String{
        return studentService.deleteStudentById(id)
    }
    // delete student by obj
    @DeleteMapping("/student")
    fun deleteStudentByObj(@RequestBody student: Student): String{
        return studentService.deleteStudentByObj(student)
    }
    // update student by obj
    @PutMapping("/student")
    fun updateStudent(@RequestBody student: Student): Student? {
        return studentService.updateStudentByObj(student)
    }
}
