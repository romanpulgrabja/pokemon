package pokemon_2;

import java.util.Date;

public class Swap {

	protected String ID;
	protected Date date;
	protected Trainer trainer1;
	protected Trainer trainer2;
	protected Pokemon pokemon1;
	protected Pokemon pokemon2;
	
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
		if(this.pokemon1.getSwapStatus() && this.pokemon2.getSwapStatus()) {
			if(this.pokemon1.getType() != this.pokemon2.getType() && this.trainer1 != this.trainer2) {
				Pokemon poke1 = this.trainer1.getPokemon(this.pokemon1);//get Pokemon entfernt das Pokemon aus der Pokemonlist des Trainers
				Pokemon poke2 = this.trainer2.getPokemon(this.pokemon2);
				this.trainer1.setPokemon(poke2);
				this.trainer2.setPokemon(poke1);
				poke1.setSwap(this);
				poke2.setSwap(this);
			} else {
				System.err.println("The pokemons " + pokemon1.getName() + " and " + pokemon2.getName() + " are of the same type and/or have the same trainer and cannot be swapped!");
			}
		} else {
			System.out.print("The pokemon cannot be swapped!");
		}
		
/*		if(this.trainer1 != this.trainer2){
			if(this.pokemon1.getType() != this.pokemon2.getType()){
				*//**
				 * Es was auch eingentlich in der Aufgabe so beschrieben, dass man gleichzeitig trainer und type mit
				 * nur einem "else" abf�ngt. If w�rde zuerst abfragen ob "getSwapStatus" wahr ist und dann type und trainer
				 * gleichzeitig in einem "if" abfangen um die Anforderungen genau zu implementieren.
				 *//*
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
		}*/
	}
	
	@Override
	public String toString(){
		//return "Trainer " + this.trainer1 + " hat mit dem Trainer " + this.trainer2 + " das Pokemon "
		//		+ this.pokemon1 + " gegen das Pokemon " + this.pokemon2 + " getauscht";
		return this.ID;
	}
	
}
