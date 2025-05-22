package com.smhrd.map;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapVO {

 private Double map_idx;  // 위치 식별자 
 private String sido; // 시도 
 private String sigungu; // 시군구 
 private String addr; // 주소 
 private String org_name; // 기관 명 
 private String org_type; // 기관 타입 
 private String org_tel; // 기관 연락처 
 private Double lat; // 위도 
 private Double lon; // 경도 
 private Timestamp created_at; // 등록 일자 
 private String admin_id; // 관리자 아이디 

 }