package softeer.tenten.fragments.moreInfo

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import softeer.tenten.EventDetailActivity
import softeer.tenten.R

class EventDetailBottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_detail_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val clearButton = view.findViewById<ImageButton>(R.id.eventBottomSheetXButton)
        val participateBtn = view.findViewById<AppCompatButton>(R.id.participateBtn)

        // 다이어로그 닫기
        clearButton.setOnClickListener {
            dismiss()
        }

        // 참여 인증 버튼 클릭
        participateBtn.setOnClickListener {
            val inputVal = view.findViewById<EditText>(R.id.eventBottomSheetCode).text.toString()
            var validCode: Boolean = validateCode(inputVal)
            val alertDialogBuilder = AlertDialog.Builder(context) // 인증 코드 유효성 검사 결과 알림 다이어로그

            if (validCode) { // 유효한 코드이면 참여 완료 & 이벤트 상세 페이지 이동
                // db에 이벤트 참여 정보 업데이트 필요~~~~~~

                alertDialogBuilder.setMessage("참여 완료되었습니다.")

                // 확인 버튼 클릭시 이벤트 상세 페이지로 다시 이동
                alertDialogBuilder.setPositiveButton("확인") { dialog, which ->
                    startActivity(Intent(context, EventDetailActivity::class.java))
                }
//                // 취소 버튼 설정 및 클릭 이벤트 처리
//                alertDialogBuilder.setNegativeButton("취소") { dialog, which ->
//                }

                // 다이얼로그 출력
                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.show()
            } else { // 재입력 필요
                alertDialogBuilder.setMessage("유효하지 않은 코드 입니다.")

                alertDialogBuilder.setPositiveButton("확인") { dialog, which ->
                }

                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }
    }

    // 인증코드 유효성 검사
    // db 데이터ㅓ 필요~~~~~~~~₩~~
    fun validateCode(code: String): Boolean {
        return true
    }
}