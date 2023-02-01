package com.backbase.moviesapi.mapper;

import com.backbase.moviesapi.dto.Example;
import com.backbase.moviesapi.entity.MovieEntity;
import com.backbase.moviesapi.model.Movie;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import javax.imageio.ImageIO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * MovieMapper
 *
 * @author KB
 * @version 0.0.1
 *
 * */
@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "imdbID", target = "imdbId")
    @Mapping(source = "imdbVotes", target = "imdbVotes", qualifiedByName = "imdbVotes")
    @Mapping(source = "boxOffice", target = "boxOffice", qualifiedByName = "boxOffice")
    @Mapping(source = "imdbRating", target = "imdbRating", qualifiedByName = "imdbRating")
   // @Mapping(source = "poster", target = "image", qualifiedByName = "poster")
    MovieEntity exampleToMovieEntity(Example example);

    Movie convertToModel(MovieEntity movieEntity);

    List<Movie> convertToModel(List<MovieEntity> movieEntity);

    @Named("imdbVotes")
    default int getImdbVotes(String imdbVotes) {
        return Optional.ofNullable(imdbVotes)
            .map(votes ->  votes.equals("N/A") ? -1 :
                Integer.parseInt(votes.replaceAll("[^0-9]", "")))
            .orElse(-1);
    }

    @Named("boxOffice")
    default int getBoxOffice(String boxOffice) {
        return Optional.ofNullable(boxOffice)
            .map(box ->  box.equals("N/A") ? -1 :
                Integer.parseInt(box.replaceAll("[^0-9]", "")))
            .orElse(-1);
    }
    @Named("imdbRating")
    default Double getImdbRating(String imdbRating) {
        return Optional.ofNullable(imdbRating)
            .map(box ->  box.equals("N/A") ? -1 :
                Double.parseDouble(box.replaceAll("[^0-9]", "")))
            .orElse(-1.0);
    }

}
