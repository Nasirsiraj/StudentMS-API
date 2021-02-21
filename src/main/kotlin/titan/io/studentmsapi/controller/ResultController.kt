package titan.io.studentmsapi.controller

import lombok.extern.slf4j.Slf4j
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import titan.io.studentmsapi.model.Result
import titan.io.studentmsapi.service.ResultService

@Slf4j
@RestController
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
class ResultController {
    lateinit var resultService: ResultService

    // get result by id
    @GetMapping("/result/{id}")
    fun getResultById(@PathVariable @NotNull id: Int): Result?{
        return resultService.getResultById(id)
    }
    // get result by roll
    @GetMapping("/result/{roll}")
    fun getResultByRoll(@PathVariable @NotNull roll: Int): Result?{
        return resultService.getResultByRoll(roll)
    }
    // get all result
    @GetMapping("/results")
    fun getAllResult(): MutableList<Result>{
        return resultService.getAllResult()
    }
    // post one result
    @PostMapping("/result")
    fun postOneResult(@RequestBody @NotNull result: Result): Result?{
        return resultService.postOneResult(result)
    }
    // post all result
    @PostMapping("/results")
    fun postAllResult(@RequestBody @NotNull results: MutableList<Result>): MutableList<Result>{
        return resultService.postAllResult(results)
    }
    // delete result by id
    @DeleteMapping("/result/{id}")
    fun deleteByResultId(@PathVariable @NotNull id: Int): String{
        return resultService.deleteResultById(id)
    }
    // delete result by roll
    @DeleteMapping("/resultByRoll/{roll}")
    fun deleteResultByRoll(@PathVariable @NotNull roll: Int): String{
        return resultService.deleteResultByRoll(roll)
    }
    // delete result by result
    @DeleteMapping("/result")
    fun deleteResultByResult(@RequestBody @NotNull result: Result): String{
        return resultService.deleteResultByResult(result)
    }
    // update result by result
    @PutMapping("/result")
    fun updateResultByResult(@RequestBody @NotNull result: Result): Result?{
        return  resultService.updateResultByResult(result)
    }
}