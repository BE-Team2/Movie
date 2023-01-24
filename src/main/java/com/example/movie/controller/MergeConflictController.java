package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"Movie Controller"}, description = "Moive(영화) 정보 관련 RestController (select only)")
@RestController
public class MergeConflictController {

    @Autowired
    MovieService ms;

    @ApiOperation(value = "DB에 있는 모든 영화 정보를 반환", notes = "DB에 있는 모든 영화 상세정보를 반환합니다. / mypage에서 init 시 사용됨")
    @GetMapping("/api/movies")
    public List<MovieDTO> selectAllMovies() {
        return ms.selectMovies();
    }

    @ApiOperation(value = "Movie Code에 맞는 해당 영화의 상세정보 반환", notes = "영화코드에 맞는 해당 영화 상세정보를 반환합니다. 영화 상세페이지에서 init 시 사용됨")
    @GetMapping("/api/movie/{movieCd}")
    public MovieDTO selectMovieDetailByMovieCode(@PathVariable int movieCd) {
        return ms.selectMovieDetailByMovieCode(movieCd);
    }
}
