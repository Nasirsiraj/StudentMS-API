package titan.io.studentmsapi.service

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import titan.io.studentmsapi.model.Result
import titan.io.studentmsapi.repository.ResultRepository

@Slf4j
@Service
class ResultService {
    @Autowired
    lateinit var resultRepository: ResultRepository
    // get result by id
    fun getResultById(id: Int): Result?{
        return resultRepository.findById(id).orElse(null)
    }
    // get result by roll
    fun getResultByRoll(roll: Int): Result?{
        return resultRepository.findByRoll(roll)
    }
    // get all result
    fun getAllResult(): MutableList<Result>{
        return resultRepository.findAll()
    }
    // post one result
    fun postOneResult(result: Result): Result?{
        return resultRepository.save(result)
    }
    // post all result
    fun postAllResult(results: MutableList<Result>): MutableList<Result>{
        return resultRepository.saveAll(results)
    }
    // delete result by id
    fun deleteResultById(id: Int): String{
        val _result = resultRepository.findById(id).orElse(null)
        return if(_result == null){
            "result doesn't exist, id: $id"
        }else{
            resultRepository.deleteById(id)
            "result deleted, id: $id"
        }
    }
    // delete result by roll
    fun deleteResultByRoll(roll: Int): String{
        val _result = resultRepository.findByRoll(roll)
        return if(_result == null){
            "result doesn't exist, roll: $roll"
        }else{
            resultRepository.deleteById(_result.id)
            "result deleted, roll: $roll"
        }
    }
    // delete result by result
    fun deleteResultByResult(result: Result): String{
        val _result = resultRepository.findById(result.id).orElse(null)
        return if(_result == null){
            "result doesn't exist, id: ${result.id}"
        }else {
            resultRepository.deleteById(result.id)
            "result deleted, id: ${result.id}"
        }
    }
    // update result by result
    fun updateResultByResult(result: Result): Result?{
        val existingResult = resultRepository.findById(result.id).orElse(null)
        if(existingResult == null){
            return null
        }else{
            existingResult.roll = result.roll
            existingResult.bangla = result.bangla
            existingResult.english = result.english
            existingResult.math = result.math
            existingResult.computer = result.computer
            existingResult.physics = result.physics
            existingResult.chemistry = result.chemistry
            existingResult.biology = result.biology

            return resultRepository.save(existingResult)
        }
    }
}