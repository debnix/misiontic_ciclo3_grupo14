public class Persona {
	private int id;
	private String name;
	private String telefono;
	private int edad;

	public Persona(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getEdad() {
		return edad;
	}
}