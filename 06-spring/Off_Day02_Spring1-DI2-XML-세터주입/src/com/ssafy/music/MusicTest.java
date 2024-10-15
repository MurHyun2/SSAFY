package com.ssafy.music;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MusicTest {
	public static void main(String[] args) {
		ApplicationContext container = new GenericXmlApplicationContext("music-config.xml");
		Album album = (Album) container.getBean("album");
		album.display();
	}
}
