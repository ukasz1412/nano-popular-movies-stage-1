package com.rabbit.green.movies.app;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import com.rabbit.green.movies.app.data.cache.MoviesCacheManager;
import com.rabbit.green.movies.app.data.cache.MoviesContentProvider;
import com.rabbit.green.movies.app.data.cache.MoviesContract;
import com.rabbit.green.movies.app.data.model.Movie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MoviesContentProviderTest extends ProviderTestCase2<MoviesContentProvider>{

    private MoviesCacheManager cacheManager;

    /**
     * Constructor.
     */
    public MoviesContentProviderTest() {
        super(MoviesContentProvider.class, MoviesContract.AUTHORITY);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        cacheManager = new MoviesCacheManager(getMockContentResolver());
    }

    @Test
    public void testInsert() {
        cacheManager = new MoviesCacheManager(getMockContentResolver());
        Movie movie = new Movie();
        movie.setId(999);
        movie.setOriginalTitle("Original title");
        movie.setTitle("Title");
        movie.setPosterPath("/poster_path");
        movie.setReleaseDate("01-01-2000");
        movie.setVoteAverage(8.88f);
        movie.setOverview("Plot");
        cacheManager.insertMovie(movie);
        assertFalse(cacheManager.getCachedMovies().isEmpty());
        assertNotNull(cacheManager.getMovie(999));
    }
}