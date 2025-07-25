package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AttendanceForm {
	
	//@NotNull(message = "勤務形態は必須です")
	private String workType;
	
	//@NotNull(message = "出勤日は必須です")
	private LocalDate workDate;
	
	//@NotNull(message = "開始時間は必須です")
	//@Size(min=8, max=15, message="8時から15時で指定してください。")
	private String startTimeHour;
	
	//@NotNull(message = "開始時間は必須です")
	//@Size(min=0, max=59, message="0分から59分で指定してください。")
	private String startTimeMinute;
	
	//@NotNull(message = "終了時間は必須です")
	//@Size(min=8, max=22, message="8時から22時で指定してください。")
	private String endTimeHour;
	
	//@NotNull(message = "終了時間は必須です")
	//@Size(min=0, max=59, message="0分から59分で指定してください。")
	//22時の場合は45分までに行う処理をどこかに追加する
	private String endTimeMinute;
	
	//@NotNull(message = "休憩時間は必須です")
	//休憩時間は勤務時間によるから今は追加しない
	private double breakTime;
	
	public AttendanceForm(String workType,LocalDate workDate) {
		this.workType = workType;
		this.workDate = workDate;
	}
//	
//	// 休憩時間のバリデーション
//    @AssertTrue(message = "実働時間が4時間以上の場合、1時間の休憩が必要です。")
//    public boolean isBreakTimeValid() {
//        // 実働時間を計算
//        LocalTime startTime = LocalTime.of(startTimeHour.getHour(), startTimeMinute.getMinute());
//        LocalTime endTime = LocalTime.of(endTimeHour.getHour(), endTimeMinute.getMinute());
//        double workingHours = java.time.Duration.between(startTime, endTime).toHours();
//
//        // 実働時間が4時間以上の場合、休憩時間が1時間であることを確認
//        return workingHours < 4 || breakTime >= 1;
//    }

//    // 終了時間のバリデーション
//    @AssertTrue(message = "22時の場合は45分までにしてください。")
//    public boolean isEndTimeValid() {
//        if (endTimeHour.getHour() == 22) {
//            return endTimeMinute.getMinute() <= 45;
//        }
//        return true; // 22時以外は制限なし
//    }
}
