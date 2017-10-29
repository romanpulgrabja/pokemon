package pokemon_2;

import java.util.ArrayList;



public class Trainer {
	
	private String firstname;
	private String lastname;
	private Pokemon pokemon;
	private ArrayList<Pokemon> pokemonlist;
	
	public Trainer(String firstname, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;
		this.pokemonlist = new ArrayList<Pokemon>();
		
	}

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**Eigentlich sollte eine Methode nicht gleichzeitig zwei sachen machen.
	 * Da der name "getPokemon" darauf hinweist, dass man etwas zurückbekommt und nicht etwas löscht.
	 * Hierfür sollte man eine Methode "removePokemon" implementiereun und die in der "execute"-Methode dann aufrufen.
	 * 
	*/
	public Pokemon getPokemon(Pokemon pokemon) {
		//this.pokemonlist.remove(pokemon);
		//pokemon.removeTrainer();
		return pokemon;
	}
	
	public void removePokemon(Pokemon pokemon) {
		this.pokemonlist.remove(pokemon);
		pokemon.removeTrainer();
	}

	public void setPokemon(Pokemon pokemon) {
		if(pokemon.getHasTrainer() == false){
			//this.pokemon = pokemon;
			pokemon.setTrainer(this);
			this.pokemonlist.add(pokemon);
		}
		else{
			System.out.println("Das Pokemon hat bereits einen Trainer");
		}
	}
	
	
	public void addPokemon(Pokemon pokemon){
		if(pokemon.getHasTrainer() == false){
			pokemon.setTrainer(this);
			pokemonlist.add(pokemon);
		}
		else{
			System.err.println("Das Pokemon hat bereits einen Trainer!");
		}
	}
	
		
	public ArrayList getpokemonlist(){
		return pokemonlist;
	}
	
	public String allPokemon(){
		return this.pokemonlist.toString();
	}
	
	public String allPoison(){
		String allpoison = "";
		for(int i = 0; i<pokemonlist.size(); i++ ){
			if(pokemonlist.get(i).getType() == Type.Poison){
				allpoison += pokemonlist.get(i).toString() + "; ";
			}
		}
		return allpoison;
	}

	public String getPokemonByIndex(int Index){
		String indexPokemon = "";
		try{
			indexPokemon = pokemonlist.get(Index).toString();
		}
		catch(IndexOutOfBoundsException e){
			System.err.println("Caught IOException: " + e.getMessage() + "Der Trainer hat nicht so viele Pokemon");
		}
		return indexPokemon;
	}

	@Override
	public String toString() {
		return "Trainer [firstname=" + firstname + ", lastname=" + lastname + ", pokemon=" + pokemonlist + "]";
	}
	
}
