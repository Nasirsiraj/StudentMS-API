package titan.io.studentmsapi.model

import javax.persistence.*

@Entity
@Table(name="student")
data class Student(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,
        var name: String,
        var roll: Int,
        var reg: Int,
        var email: String,
        var department: String,
        var semester: String)