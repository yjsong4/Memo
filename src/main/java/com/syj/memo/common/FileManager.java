package com.syj.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	// final : 변수가 아니라 상수로 만들어 준다
	public final static String FILE_UPLOAD_PATH = "D:\\YJ\\project\\upload\\memo";
	
	// 파일 객체를 전달 받고,
	// 특정 위치에 파일을 저장하고,
	// 클라이언트가 접근할 수 있는 url 문자열을 돌려준다.
	public static String saveFile(int userId, MultipartFile file) {
		
		if(file == null) {
			return null;
		}
		
		// 같은 이름의 파일 처리
		// 디렉토리(파일)를 만들어서 파일을 저장
		// 로그인 한 사용자 userId를 디렉토리 이름에 추가
		// 현재 시간 정보를 디렉토리 이름에 추가
		// UNIX TIME : 1970년 1월 1일부터 흐른 시간을 milli second(1/000)로 표현한 시간
		// ex) 3_523975832
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 디렉토리 생성
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath);
		if(!directory.mkdir()) {
			// 디렉토리 생성 실패
			return null;
		}
		
		// 파일 저장
		String filePath = directoryPath + "/" + file.getOriginalFilename();
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			
			// 파일 저장 실패
			return null;
		}
		
		// 저장된 파일을 클라이언트가 접근할 수 있는 url 문자열을 리턴
		// 파일 저장 경로 : D:\\YJ\\project\\upload\\memo/3+13454313/test.png
		// url 규칙 :  /images/3+13454313/test.png
		return "/images" + directoryName + "/" + file.getOriginalFilename();	
	}

}
