package softeer.tenten.network.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import softeer.tenten.network.request.LoginRequest
import softeer.tenten.network.response.BaseResponse
import softeer.tenten.network.response.LoginResponse
import softeer.tenten.network.response.PopUpDetail
import softeer.tenten.network.response.PopUpList

interface PopUpStoreService {

    // 팝업 스토어 리스트 조회
    @GET("/api/pop-up")
    fun getPopUpList(): Call<BaseResponse<List<PopUpList>>>


    // 팝업 스토어 투표 내역 조회
    @GET("/api/pop-up/{id}/vote")
    fun getPopUpVoteRecord(
        @Path(value = "id") id: String,
    ): Call<BaseResponse<LoginRequest>>

    // 팝업 스토어 지역 투표
    @POST("/api/pop-up/{id}/vote")
    fun votePopUp(
        @Path(value = "id") id: String,
    ): Call<BaseResponse<LoginRequest>>


}
