package com.playtech.chat.server.custom.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorCreater {
	private static Injector injector = Guice.createInjector(new LoggerModule());

	private InjectorCreater() {
	}

	public static Injector getInjector() {
		return injector;
	}
}
