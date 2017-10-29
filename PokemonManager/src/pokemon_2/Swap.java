package pokemon_2;

import java.util.Date;

public class Swap {

	private String ID;
	private Date date;
	private Trainer trainer1;
	private Trainer trainer2;
	private Pokemon pokemon1;
	private Pokemon pokemon2;
	
	public Swap(Pokemon pokemona, Pokemon pokemonb){
		this.trainer1 = pokemona.getTrainer();
		this.trainer2 = pokemonb.getTrainer();
		this.pokemon1 = pokemona;
		this.pokemon2 = pokemonb;
		this.date = this.setDate();
		this.ID = this.setID();
		
	}
	
	public String setID(){
		String newID = this.trainer1.getLastname() + this.trainer2.getLastname() + this.date.toString();
		return newID;
	}
	
	public Date setDate(){
		Date newDate = new Date();
		return newDate;
	}
	
	public void execute(){
		if(this.trainer1 != this.trainer2){
			if(this.pokemon1.getType() != this.pokemon2.getType()){
				if(this.pokemon1.getSwapStatus() == true && this.pokemon2.getSwapStatus() == true){
					Pokemon poke1 = this.trainer1.getPokemon(this.pokemon1);//get Pokemon entfernt das Pokemon aus der Pokemonlist des Trainers
					Pokemon poke2 = this.trainer2.getPokemon(this.pokemon2);
					this.trainer1.setPokemon(poke2);
					this.trainer2.setPokemon(poke1);
					poke1.setSwap(this);
					poke2.setSwap(this);
				}
				else{
					System.err.println("One of the trainers doesn't allow the swap!");
				}
			}
			else{
				System.err.println("This Pokemon cannot be swapped, as they are of the same type!");
			}
		}
		else{
			System.err.println("A trainer can't swap a pokemon with himself!");
		}
	}
	
	@Override
	public String toString(){
		//return "Trainer " + this.trainer1 + " hat mit dem Trainer " + this.trainer2 + " das Pokemon "
		//		+ this.pokemon1 + " gegen das Pokemon " + this.pokemon2 + " getauscht";
		return this.ID;
	}
	
}
