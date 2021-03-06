package com.rabbit.green.movies.app.di;

import com.rabbit.green.movies.app.BuildConfig;
import com.rabbit.green.movies.app.data.source.IMoviesRepository;
import com.rabbit.green.movies.app.data.source.net.IMoviesRestService;
import com.rabbit.green.movies.app.data.source.net.MoviesRetrofitRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@SuppressWarnings("WeakerAccess")
@Module
public class ApiModule {

    @SuppressWarnings("SameReturnValue")
    @Provides
    @Named("apiKey")
    public String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @SuppressWarnings("SameReturnValue")
    @Provides
    @Named("baseUrl")
    public String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named("baseUrl") String basUrl) {
        return new Retrofit.Builder()
                .baseUrl(basUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public IMoviesRestService provideMoviesRestService(Retrofit retrofit) {
        return retrofit.create(IMoviesRestService.class);
    }

    @SuppressWarnings("SameParameterValue")
    @Provides
    @Singleton
    public IMoviesRepository provideMoviesRepository(IMoviesRestService restService,
                                                     @Named("apiKey") String apiKey) {
        return new MoviesRetrofitRepository(restService, apiKey);
    }
}
