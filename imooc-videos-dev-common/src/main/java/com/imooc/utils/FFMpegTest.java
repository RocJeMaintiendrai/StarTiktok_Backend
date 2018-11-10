package com.imooc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.yetus.audience.InterfaceAudience.Private;

public class FFMpegTest {
	
	private String ffmpeg;
	
	public FFMpegTest(String ffmpeg) {
		super();
		this.ffmpeg = ffmpeg;
	}
	
	public void convertor(String videoInputPath, String videoOutputPath) throws Exception {
//		ffmpeg -i input.mp4 -y output.avi
		List<String> command = new ArrayList<>();
		command.add(ffmpeg);
		command.add("-i");
		command.add(videoInputPath);
		command.add(videoOutputPath);
		for (String c : command) {
			System.out.print(c + " ");
		}
		
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		String line="";
		while((line = br.readLine()) != null) {
			
		}
		
		if(br != null) {br.close();}
		if(inputStreamReader != null) {inputStreamReader.close();}
		if(errorStream != null) {errorStream.close();}
		
	}

	public static void main(String[] args) {
		FFMpegTest ffmpeg = new FFMpegTest("/usr/local/bin/ffmpeg");
		try {
			ffmpeg.convertor("/Users/guopeng/Desktop/imooc.mp4", "/Users/guopeng/Desktop/demo.avi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
