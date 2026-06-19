package edu.ucne.dragon_ball_z.data.repository

import android.R.attr.name
import coil3.compose.AsyncImagePainter
import edu.ucne.dragon_ball_z.data.remote.DragonBallApi
import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.data.remote.dto.PlanetDto
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
import javax.inject.Inject


class PlanetRepositoryImp @Inject constructor(
    private val api: DragonBallApi
): PlanetRepository{
    override suspend fun getPlanets(
        page: Int,
        limit: Int,
        nama: String?,
        isDestroyed: Boolean?
    ): Resource<List<PlanetDto>>{
        return try {
            val response = api.getPlanets(page,limit,nama,isDestroyed)

            if(response.isSuccessFul && response.body()!= null){
                val data = response.body()!!.items
                Success(data)
            }else{
                Error("Error del servidor: ${response.messege()}")
            }
        }catch (e: Exception){
            if(!name.isNullOrBlank()){
                try {
                    val alternativeResponse =
                        api.getPlanets(page = 1, limit = 50, nama = null, isDestroyed = null)
                    if(alternativeResponse.isSuccessFul && alternativeResponse.body() != null){
                        val filteredList = alternativeResponse.body() !!.items.filter{
                            it.neme.contains(name, ignoreCase = true)
                        }
                        Success(filteredList)
                    }else{
                        Error("Error al filtrar localmente.")
                    }
                }catch (nestedException: Exception){
                    Error("Error en filtro: ${nestedException.localizedMessage}")
                }
            }else{
                Error("Error de conexion: ${e.localizedMessage}")
            }
        }
    }

    override suspend fun getPlanetDetail(id: Int): Resource<PlanetDto> {
        return try {
            val response = api.getPlanetDetail(id)
            if(response.isSuccessful && response.body() != null){
                Success(response.body() !!)
            }else{
                Error("Planeta no encontrado.")
            }
        }catch (e: Exception){
            Error("Error: ${e.message}")
        }
    }
}