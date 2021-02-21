package titan.io.studentmsapi.model

import javax.persistence.*

@Entity
@Table(name = "result")
data class Result(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var roll: Int,
    var bangla: Int,
    var english: Int,
    var math: Int,
    var computer: Int,
    var physics: Int,
    var chemistry: Int,
    var biology: Int
)