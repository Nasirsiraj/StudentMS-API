package titan.io.studentmsapi.service

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import titan.io.studentmsapi.model.Student
import titan.io.studentmsapi.repository.StudentRepository

@Slf4j
@Service
class StudentService {
    @Autowired
    lateinit var studentRepository: StudentRepository

    // get all student
     fun getAllStudent(): MutableList<Student> {
        return studentRepository.findAll()
    }
    // get student by id
    fun getStudentById(id: Int): Student?{
        return studentRepository.findById(id).orElse(null)
    }
    // post all student
    fun postAllStudent(students: MutableList<Student>): MutableList<Student>{
        return studentRepository.saveAll(students)
    }
    // post one student
    fun postStudent(student: Student): Student{
        return studentRepository.save(student)
    }
    // delete student by id
    fun deleteStudentById(id: Int): String{
        val student_: Student ?= studentRepository.findById(id).orElse(null)
        if(student_ == null){
            return "student not found. id: $id"
        }else{
            studentRepository.deleteById(id)
            return "student deleted. id: $id"
        }
    }
    // delete student by obj
    fun deleteStudentByObj(student: Student): String{
        val student_: Student ?= studentRepository.findById(student.id).orElse(null)
        if(student_ == null){
            return "student not found. id: ${student.id}"
        }else{
            studentRepository.delete(student)
            return "student deleted. id: ${student.id}"
        }
    }
    // update student by obj
    fun updateStudentByObj(student: Student): Student? {
        val student_: Student ?= studentRepository.findById(student.id).orElse(null)
        if(student_ == null){
            return null
        }else{
            student_.id = student.id
            student_.name = student.name
            student_.roll = student.roll
            student_.reg = student.reg
            student_.email = student.email
            student_.department = student.department
            student_.semester = student.semester

            return studentRepository.save(student_)
        }

    }
}