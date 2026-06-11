package mn.icode;

interface Logger {
	String level();
	
	default void log(String message) {
		System.out.printf("[%s] %s%n", level(), message);
	}
	
	default void logError(String message) {
		System.out.printf("[%s] ERROR: %s%n", level(), message);
	}
}

class AppLogger implements Logger {
	@Override
	public String level() {
		return "DEBUG";
	}
	
	@Override
	public void log(String message) {
		System.out.printf("[DEBUG][%d] %s%n",
				System.currentTimeMillis(), message);
	}
}
