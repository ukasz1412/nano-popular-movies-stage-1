package com.rabbit.green.movies.app.di;

import com.rabbit.green.movies.app.movies.browse.MoviesBrowserActivity;
import com.rabbit.green.movies.app.movies.browse.MoviesBrowserModule;
import com.rabbit.green.movies.app.movies.details.MovieDetailsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@SuppressWarnings({"unused", "WeakerAccess"})
@Module
public abstract class ActivityContributorModule {
    @ContributesAndroidInjector(modules = MoviesBrowserModule.class)
    abstract MoviesBrowserActivity contributeMoviesBrowserActivity();

    @ContributesAndroidInjector
    abstract MovieDetailsActivity contributeMovieDetailsActivity();
}
