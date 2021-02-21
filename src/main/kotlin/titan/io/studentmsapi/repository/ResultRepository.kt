package titan.io.studentmsapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import titan.io.studentmsapi.model.Result

@Repository
interface ResultRepository : JpaRepository<Result, Int> {
    fun findByRoll(roll: Int): Result?
}