package com.example.test1;

import java.io.IOException;
import java.lang.reflect.Type;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

@RestControllerAdvice
public class TestControllerAdvice extends RequestBodyAdviceAdapter {

	@ExceptionHandler(NullPointerException.class)
	public String test(HttpServletRequest request) {
		System.out.println("ExceptionHandler");
		return request.getLocalAddr();
	}

	// JSONの内容をSyainオブジェクトに反映する前に実行
	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		System.out.println("beforeBodyRead=" + inputMessage.getHeaders());// リクエストヘッダー

		return inputMessage;
	}

	// JSONの内容をSyainオブジェクトに反映した後に実行
	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		Syain syain = (Syain)body;
		System.out.println("afterBodyRead=" + syain.getSyainName()); //suzuki
		syain.setSyainName("i.suzuki");
		return body;
	}

	// beforeBodyRead,afterBodyRead,handleEmptyBodyを実行するか。tureは実行する。
	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		System.out.println("supports");
		// return false; //実行しない
		return true; // 実行する
	}

	// bodyが空の場合のみ呼び出される
	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		System.out.println("handleEmptyBody");
		return body;
	}
}