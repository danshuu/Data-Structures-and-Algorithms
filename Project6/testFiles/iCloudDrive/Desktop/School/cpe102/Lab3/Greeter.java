public class Greeter {

	private String thing; // instance variable

	// constructor 
	public Greeter() {
		this.thing = null;
	}

	public Greeter(String name) {
		this.thing = name;
	}

	public String greet() {
		if (thing == null) {
			return "Heeeyyyy buddy!";
		} else {
			return "Hello " + thing;
		}
		
	}
}