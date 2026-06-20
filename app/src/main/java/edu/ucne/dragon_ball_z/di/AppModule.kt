package edu.ucne.dragon_ball_z.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.dragon_ball_z.data.remote.DragonBallApi
import edu.ucne.dragon_ball_z.data.repository.PlanetRepositoryImp
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule{

    @Provides
    @Singleton
    fun provideMoshi(): Moshi{
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    @Provides
    @Singleton
    fun provideApi(moshi: Moshi): DragonBallApi{
        return Retrofit
            .Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create(DragonBallApi::class.java)
    }
    @Provides
    @Singleton
    fun provideRepository(api: DragonBallApi): PlanetRepository {
        return PlanetRepositoryImp(api)
    }
}