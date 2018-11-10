package com.imooc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.yetus.audience.InterfaceAudience.Private;

public class MergeVideoMp3 {
	
	private String ffmpeg;
	
	public MergeVideoMp3(String ffmpeg) {
		super();
		this.ffmpeg = ffmpeg;
	}
	
	public void convertor(String videoInputPath, String mp3InputPath,
			Double seconds, String videoOutputPath) throws Exception {
		//ffmpeg -i /Users/guopeng/Desktop/imooc.mp4 demo.avi
		List<String> command = new ArrayList<>();
		command.add(ffmpeg);
		
		command.add("-i");
		command.add(videoInputPath);
		
		command.add("-i");
		command.add(mp3InputPath);
		
		command.add("-t");
		command.add(String.valueOf(seconds));
		
		command.add("-y");
		command.add(videoOutputPath);
		
//		command.add(videoOutputPath);
//		for (String c : command) {
//			System.out.print(c + " ");
//		}
		
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
		MergeVideoMp3 ffmpeg = new MergeVideoMp3("/usr/local/bin/ffmpeg");
		try {
			ffmpeg.convertor("/Users/guopeng/Desktop/imooc.mp4","/Users/guopeng/Desktop/imooc.mp3",7.1, "/Users/guopeng/Desktop/new.mp4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
