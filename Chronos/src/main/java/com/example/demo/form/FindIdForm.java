package com.example.demo.form;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// HTMLフォームのth:object="${findId}"に対応するフォームクラス
@Data // Lombok: ゲッター、セッターなどを自動生成
@NoArgsConstructor // Lombok: 引数なしコンストラクタを自動生成
@AllArgsConstructor // Lombok: 全フィールドを引数とするコンストラクタを自動生成
public class FindIdForm {
    private String kensaku_id; // 社員番号を保持するフィールド
}