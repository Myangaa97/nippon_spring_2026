package mn.icode;

public interface Exportable {
	String toCSV();
	String toJSON();
	
	default void export() {
		System.out.println(toCSV());
        System.out.println(toJSON());
	}
}

class Contact implements Exportable {
	private String name;
	private String email;
	private String phone;
	
	public Contact(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toCSV() {
		return name + ", " + email + ", " + phone;
	}
	
	@Override
	public String toJSON() {
		return "{\"name\":\"" + name + "\", \"email\":\"" + email + "\", \"phone\":\"" + phone + "\"}";
		}
}
