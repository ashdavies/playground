package io.ashdavies.databinding.services

import io.ashdavies.databinding.models.Repo
import io.ashdavies.databinding.network.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GitHubService {

  @GET("search/repositories?sort=name")
  suspend fun repos(
      @Query("q", encoded = true) query: String,
      @Query("page") page: Int,
      @Query("per_page") itemsPerPage: Int
  ): Response<Repo>
}
