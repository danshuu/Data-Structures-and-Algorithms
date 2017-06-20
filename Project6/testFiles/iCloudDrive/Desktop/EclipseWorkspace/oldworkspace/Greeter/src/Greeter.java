public class Greeter {

	private String thing;

	public Greeter() {
		thing = null;
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