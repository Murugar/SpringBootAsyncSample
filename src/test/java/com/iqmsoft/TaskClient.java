package com.iqmsoft;

import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

import com.iqmsoft.TaskRequest;

public class TaskClient {
	
	public static void main(String[] args) {
		AsyncRestTemplate template = new AsyncRestTemplate();
		TaskRequest requestBody = new TaskRequest();
		requestBody.setTaskName("Task no. 8");
		requestBody.setTaskParameters(new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen"}); 
		HttpEntity<TaskRequest> requestEntity = new HttpEntity<TaskRequest>(requestBody);
		ListenableFuture<ResponseEntity<String>> lFutureResponse = template.postForEntity("http://localhost:8080/task", requestEntity, String.class);
		lFutureResponse.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {

			@Override
			public void onSuccess(ResponseEntity<String> responseEntity) {
				System.out.println(responseEntity.getBody());
			}

			@Override
			public void onFailure(Throwable err) {
				System.out.println(err);
			}
		});
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lFutureResponse = template.postForEntity("http://localhost:8080/process-task", requestEntity, String.class);
		lFutureResponse.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {

			@Override
			public void onSuccess(ResponseEntity<String> responseEntity) {
				System.out.println(responseEntity.getBody());
			}

			@Override
			public void onFailure(Throwable err) {
				System.out.println(err);
			}
		});
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		lFutureResponse = template.postForEntity("http://localhost:8080/process-webtask", requestEntity, String.class);
		lFutureResponse.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {

			@Override
			public void onSuccess(ResponseEntity<String> responseEntity) {
				System.out.println(responseEntity);
				System.out.println(responseEntity.getBody());
			}

			@Override
			public void onFailure(Throwable err) {
				System.out.println(err);
			}
		});
	}

}
