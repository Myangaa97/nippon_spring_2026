package mn.icode;

interface Serializable {
	String serialize();
	default void print() {
		System.out.println(serialize());
	}
}

class User implements Serializable {
	String name;
	String email;
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String serialize() {
		return "User{name=" + name + ", email=" + email + "}";
	}
}

class Config implements Serializable {
	String key;
	String value; 
	
	public Config(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String serialize() {
		return "Config{key=" + key + ", value=" + value + "}";
	}
}
