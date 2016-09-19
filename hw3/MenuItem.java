public class MenuItem{
	
	private String label;
	private int id;
	private int Choice;
	private boolean enabled = true;

	/* ------------ */
	/* Constructors */
	/* ------------ */

	public MenuItem(int id, String label){
		this.id = id;
		this.label = label;
	}

	/* --------------- */
	/* Mutator Methods */
	/* --------------- */

	public void setChoice(int choice){
		this.Choice = choice;
	}

	public void setEnabled(boolean on_or_off){
		this.enabled = on_or_off;
	}

	/* ---------------- */
	/* Accessor Methods */
	/* ---------------- */

	public String getLabel(){
		return this.label;
	}

	public int getId(){
		return this.id;
	}

	public int getChoice(){
		return this.Choice;
	}

	public boolean getEnabled(){
		return this.enabled;
	}


}
