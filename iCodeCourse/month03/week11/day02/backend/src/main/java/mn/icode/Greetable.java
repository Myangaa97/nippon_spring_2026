package mn.icode;

public interface Greetable {
	String greet();
	default String greetLoud() {
		return greet().toUpperCase();
	}
}

class English implements Greetable {
	public String greeting;
	
	public English(String greeting) {
        this.greeting = greeting;
    }
	
	@Override
	public String greet() {
		return "Hello";
	}
	
	@Override
	public String greetLoud() {
		return "Hello";
	}
}

class Japanese implements Greetable {
	public String greeting;
	
	public Japanese(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public String greet() {
		return "Konnichiwa";
	}
	
	@Override
	public String greetLoud() {
		return "Konnichiwa";
	}
}